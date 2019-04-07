package org.phamsodiep.template.restservice.controller;


import javax.validation.Valid;
import javax.servlet.ServletContext;
import java.net.Socket;
import java.io.InputStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping(value = "/sourcecodebrowser")                             // entity name: SourceCodeBrowser
public class SourceCodeBrowserController {
  private static final int[] EMACS_ACK_FORMAT;
  private static final String APP_CONFIG_VAR = "sourceCodeBrowserConfig";

  @Autowired
  private ServletContext servletContext;


  @PostMapping("/target")                                                 // composite property target of SourceCodeBrowser entity
  public ResponseEntity<String> postTarget(
    @Valid
    @RequestBody
    Target target
  ) {
    System.out.println("Emacs requests update browser target to:");
    System.out.println("\tFile: " + target.getFile());
    System.out.println("\tPosition: " + target.getPosition());

    // Assuming line 2 column 4 of file /etc/hosts is definition of target
    // request. Response this to Emacs so that it open file /etc/hosts at that
    // position via emacsclient protocol.
    // It is noted that file "/etc/hosts" is not make sense, but I wanna hide
    // my real environment information because of security. For real
    // environment, it may be
    // "/home/phamsodiep/emacs/hi-cloud-project/Main.java" or something likes
    // that.
    boolean result = this.requestEmacsClientOpenFile("/etc/hosts", 2, 4);
    System.out.print("Send request to client: ");
    System.out.println(result ? "successfully" : "unsuccessfully");
    return new ResponseEntity<String>(HttpStatus.OK);
  }

  @PostMapping("/config")
  public ResponseEntity<String> postConfig(
    @Valid
    @RequestBody
    Configuration config
  ) {
    Configuration previousCfg = this.getConfiguration();
    System.out.println("\nPrevious configuration:");
    System.out.println("\tHost: " + previousCfg.getHost());
    System.out.println("\tPort: " + previousCfg.getPort());
    System.out.println("\tKey: " + previousCfg.getAuthorizationKey());

    this.setConfiguration(config);
    Configuration readBack = this.getConfiguration();
    System.out.println("Emacs requests configuration update:");
    System.out.println("\tHost: " + readBack.getHost());
    System.out.println("\tPort: " + readBack.getPort());
    System.out.println("\tKey: " + readBack.getAuthorizationKey());
    return new ResponseEntity<String>(HttpStatus.OK);
  }

  private Configuration getConfiguration() {
    Configuration cfg = null;
    Object obj = servletContext.getAttribute(APP_CONFIG_VAR);

    if (obj == null) {
      cfg = new Configuration();
      servletContext.setAttribute(APP_CONFIG_VAR, cfg);
      return cfg;
    }
    if (this.checkConfigurationVariableConfict(obj)) {
      return new Configuration();
    }
    cfg = (Configuration) obj;
    return cfg;
  }

  private void setConfiguration(Configuration config) {
    Object obj = servletContext.getAttribute(APP_CONFIG_VAR);
    if (this.checkConfigurationVariableConfict(obj)) {
      return;
    }
    servletContext.setAttribute(APP_CONFIG_VAR, config);
  }

  private boolean checkConfigurationVariableConfict(Object currentValue) {
    if ((currentValue != null) && !(currentValue instanceof Configuration)) {
      StringBuffer sb = new StringBuffer(
        "\nApplication scope variable name '"
      );
      sb.append(APP_CONFIG_VAR);
      sb.append(
        "' conflict is detected. This variable expectation type is class of '"
      );
      sb.append(Configuration.class.getName());
      sb.append("', but found '");
      sb.append(currentValue.getClass().getName());
      sb.append("'.");
      System.err.println(sb.toString());
      return true;
    }
    return false;
  }

  private boolean requestEmacsClientOpenFile(
    String fileName,
    int line,
    int column
  ) {
    // Information sent to Emacs is as below format:
    // "-auth $authorizationKey -dir $workingDirectory -nowait -nowait
    //  -current-frame -tty /dev/pts/$clientTTY xterm -position +$line:$column
    //  -file $fileName\n"
    //
    // The format could be reduced as below:
    // "-auth $authorizationKey -nowait -nowait -current-frame -position
    //  +$line:$column -file $fileName\n"
    //
    // The reduced version is applied, because some information is not available
    // for server (E.g. TTY dev of server, working directory of server...). It
    // is not available because of security or server OS environment.
    //
    // It is noted that: 
    //   . The ending token "\n" of the format is important to notify Emacs 
    //     executes that response.

    boolean result = true;
    Configuration cfg = this.getConfiguration();

    if (cfg == null || cfg.getHost().length() == 0) {
      return false;
    }
    try {
      Socket sock = new Socket(cfg.getHost(), new Integer(cfg.getPort()));
      StringBuffer sb = new StringBuffer("-auth ");
      sb.append(cfg.getAuthorizationKey());
      sb.append(" -nowait -current-frame");
      sb.append(" -position +");
      sb.append(line);
      sb.append(':');
      sb.append(column);
      sb.append(" -file ");
      sb.append(fileName);
      sb.append("\n");
      sock.getOutputStream().write(sb.toString().getBytes());
      //System.out.println(sb.toString());
      // Read ACK and verify it.
      InputStream is = sock.getInputStream();
      boolean confirm = true;
      // Verify that ACK begins with EMACS_ACK_FORMAT
      for (int expectedCh : EMACS_ACK_FORMAT) {
        if (is.read() != expectedCh) {
          confirm = false;
          break;
        }
      }
      if (confirm) {
        // Verify that ACK ends with a pid (a sequence of digits)
        // and followed by a "\n" or "\r\n" (optional)
        while(is.available() > 0) {
          int ch = is.read();
          if (ch < '0' || ch > '9') {
            result = (ch == '\r' || ch == '\n');
            break;
          }
        }
      }
      else {
        result = false;
      }
      sock.close();
    }
    catch(Exception e) {
      result = false;
    }
    return result;
  }


  private static class Target {
    private String file;
    private Integer position;

    public void setFile(String file) {
      this.file = file;
    }

    public void setPosition(Integer position) {
      this.position = position;
    }

    String getFile() {
      return this.file;
    }

    Integer getPosition() {
      return this.position;
    }
  }


  private static class Configuration {
    private String host;
    private String port;
    private String authorizationKey;


    Configuration() {
      this.host = "";
      this.port = "8888";
      this.authorizationKey = "";
    }

    String getHost() {
      return this.host;
    }

    String getPort() {
      return this.port;
    }

    String getAuthorizationKey() {
      return this.authorizationKey;
    }

    public void setHost(String host) {
      this.host = host;
    }

    public void setPort(String port) {
      this.port = port;
    }

    public void setAuthorizationKey(String authorizationKey) {
      this.authorizationKey = authorizationKey;
    }
  }


  static {
    EMACS_ACK_FORMAT = "-emacs-pid ".chars().toArray();
  }
}


