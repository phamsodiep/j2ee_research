package org.phamsodiep.template.webapp.controller;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.phamsodiep.template.webapp.model.UnicodeFormatForm;
import org.phamsodiep.template.webapp.stereotypes.Advertise;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Advertise(
  path=UnicodeFormatController.NAMESPACE,
  name="Plain text format applied unicode code point shifting."
)
@Controller
public class UnicodeFormatController {
  // View configuration: template names and urls
  private static final String UNICODE_CONVERTER       = "/unicode_format";
  static final String         NAMESPACE               = ConverterController.NAMESPACE + UNICODE_CONVERTER;
  private static final String UNICODE_FORMAT_URL      = "/" + NAMESPACE;
  private static final String UNICODE_FORMAT_TEMPLATE = NAMESPACE;

  // Unicode formater constants
  private static final char   FMT_HIGH_CH             = (char)(0xD835);
  private static final char   FMT_BOLD_LOW_UC_CH      = (char)(0xDE08 - 26*2);
  private static final char   FMT_BOLD_LOW_LC_CH      = (char)(0xDE08 - 26);
  private static final char   FMT_ITALIC_LOW_UC_CH    = (char)(0xDE08);
  private static final char   FMT_ITALIC_LOW_LC_CH    = (char)(0xDE08 + 26);
  private static final Pattern ITALIC_PATTERN;
  private static final Pattern BOLD_PATTERN;

  @RequestMapping(
    value  = UnicodeFormatController.UNICODE_FORMAT_URL,
    method = {RequestMethod.GET, RequestMethod.POST}
  )
  public String processUnicodeFormatConvertPage(
    final UnicodeFormatForm formObj,
    ModelMap model,
    final HttpServletRequest req
  ) {
    if (req.getMethod().compareToIgnoreCase("POST") == 0) {
      String output = this.doUnicodeFormatConvert(
        formObj.getFormat(), formObj.getInput()
      );
      formObj.setOutput(output);
    }
    model.addAttribute("formModel", formObj);
    return UnicodeFormatController.UNICODE_FORMAT_TEMPLATE;
  }

  private String doUnicodeEmbeddedFormatConvert(String input) {
    StringBuffer result = new StringBuffer();
    Matcher matcher = BOLD_PATTERN.matcher(input);
    char format = '!';
    int inputLength = input.length();
    int i;
    int pre = 0;
    String oStr = null;
    String iStr = null;

    for (i = 0; i < inputLength; matcher.region(i, inputLength)) {
      // look for bold format request
      matcher.usePattern(BOLD_PATTERN);
      if (matcher.lookingAt()) {
        format = 'b';
      }
      else {
        // look for italic format request
        matcher.usePattern(ITALIC_PATTERN);
        if (matcher.lookingAt()) {
          format = 'i';
        }
        else {
          format = '!';
        }
      }
      // Do format if it is requested
      if (format != '!') {
        i = matcher.start();
        // Bold format pattern has just been matched
        // Extract its matched string
        iStr = matcher.group().substring(3, matcher.group().length() - 4);
        // Do bold format
        oStr = this.doUnicodeFormatConvert(format, iStr);
        // Test if previous unformat string exists, if yes do append them
        if (pre < i) {
          result.append(input.substring(pre, i));
        }
        pre = matcher.end();
        // Previous unformat string is processed, now append the formatted one
        result.append(oStr);
        i = pre;
      }
      else {
        i++;
      }
    }
    // Test if there is unformat string remains, if yes do append them
    if (pre < inputLength) {
      result.append(input.substring(pre, inputLength));
    }
    return result.toString();
  }

  private String doUnicodeFormatConvert(char format, String input) {
    if (input.length() == 0) {
      return "";
    }
    if (format == '*') {
      return this.doUnicodeEmbeddedFormatConvert(input);
    }
    int inputLength = input.length();
    StringBuffer result = new StringBuffer();
    Pattern pattern = Pattern.compile("[a-zA-Z]");
    Matcher matcher = pattern.matcher(input);
    int previous = 0;
    while (matcher.find()) {
      char inCh = matcher.group().charAt(0);
      char[] outCh = UnicodeFormatController.format(format, inCh);
      int start = matcher.start();
      if (previous < start) {
        result.append(input.substring(previous, start));
      }
      previous = matcher.end();
      result.append(outCh);
    }
    if (previous < inputLength) {
      result.append(input.substring(previous, inputLength));
    }
    return result.toString();
  }

  private static char[] format(char format, char ch) {
    boolean isBold = true;
    if (format == 'i') {
      isBold = false;
    }
    else if (format != 'b') {
      return new char[] {ch};
    }
    boolean isUpper = Character.isUpperCase(ch);
    char lowChar = (char)(isBold ?
      (isUpper ?
        (ch - 'A' + FMT_BOLD_LOW_UC_CH) :
        (ch - 'a' + FMT_BOLD_LOW_LC_CH)
      ) :
      (isUpper ?
        (ch - 'A' + FMT_ITALIC_LOW_UC_CH) :
        (ch - 'a' + FMT_ITALIC_LOW_LC_CH)
      )
    );
    int codePoint = Character.toCodePoint(FMT_HIGH_CH, lowChar);
    return Character.toChars(codePoint);
  }

  static {
    ITALIC_PATTERN = Pattern.compile(
      "(\\[i\\]){1}.*(\\[/i\\]){1}"
    );
    BOLD_PATTERN = Pattern.compile(
      "(\\[b\\]){1}.*(\\[/b\\]){1}"
    );
  }
}

