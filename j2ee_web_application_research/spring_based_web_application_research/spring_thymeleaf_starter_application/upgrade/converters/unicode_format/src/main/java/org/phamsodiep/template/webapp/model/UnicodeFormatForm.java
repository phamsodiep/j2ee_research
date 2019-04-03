package org.phamsodiep.template.webapp.model;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class UnicodeFormatForm {
  private static final Map<String, String> formats = UnicodeFormatForm.getFormatDomainValues();
  private Integer cursorPosition;
  private char format;
  private String input;
  private String output;


  public UnicodeFormatForm() {
    this.format = 'i';
    this.input  = "";
    this.output = "";
  }

  public final Map<String, String> getFormats() {
    return UnicodeFormatForm.formats;
  }

  public Integer getCursorPosition() {
    return this.cursorPosition;
  }

  public char getFormat() {
    return format;
  }

  public String getInput() {
    return this.input;
  }

  public String getOutput() {
    return output;
  }

  public void setCursorPosition(Integer cursorPosition) {
    this.cursorPosition = cursorPosition;
  }

  public void setFormat(char format) {
    this.format = format;
  }

  public void setInput(String unicode) {
    this.input = unicode;
  }

  public void setOutput(String output) {
    this.output = output;
  }

  private static final Map<String, String> getFormatDomainValues() {
    Map<String, String> formats = new HashMap<String, String>();
    formats.put("Italic", "i");
    formats.put("Bold", "b");
    formats.put("Embedded", "*");
    return Collections.unmodifiableMap(formats); 
  }
}

