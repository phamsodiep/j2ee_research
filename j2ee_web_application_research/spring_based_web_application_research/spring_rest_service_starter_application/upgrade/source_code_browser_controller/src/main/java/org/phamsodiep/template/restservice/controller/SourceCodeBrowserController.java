package org.phamsodiep.template.restservice.controller;


import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/sourcecodebrowser")                             // entity name: SourceCodeBrowser
public class SourceCodeBrowserController {
  @PostMapping("/target")                                                 // composite property target of SourceCodeBrowser entity
  public ResponseEntity<String> postTarget(
    @Valid
    @RequestBody
    Target target
  ) {
    System.out.println("Emacs request update browser target to " + target);
    return new ResponseEntity<String>(HttpStatus.OK);
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

    public String toString() {
      return this.file + "@" + this.position;
    }
  }
}


