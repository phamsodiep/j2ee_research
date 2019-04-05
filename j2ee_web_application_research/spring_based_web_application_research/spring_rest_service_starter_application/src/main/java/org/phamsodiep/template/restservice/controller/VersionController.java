package org.phamsodiep.template.restservice.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "/")
public class VersionController {
  @GetMapping("/version")
  public ResponseEntity<Version> getVersion() {
    return new ResponseEntity<Version>(
      new Version(0, 0, 1),
      HttpStatus.OK
    );
  }

  private static final class Version {
    private int major;
    private int minor;
    private int patch;


    Version(int major, int minor, int patch) {
      this.major = major;
      this.minor = minor;
      this.patch = patch;
    }

    public int getMajor() {
      return this.major;
    }

    public int getMinor() {
      return this.minor;
    }

    public int getPatch() {
      return this.patch;
    }
  }
}


