package org.phamsodiep.template.restservice.controller;


import javax.validation.Valid;
import javax.servlet.ServletContext;

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
}


