package org.phamsodiep.template.webapp.controller;


import java.util.HashSet;
import java.util.Set;

import org.phamsodiep.template.webapp.model.ViewLink;
import org.phamsodiep.template.webapp.util.AdvertiseScanner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
  static final String CONTROLLER_PACKAGE_NAME;

  @GetMapping("/")
  public String homePage(Model model) {
    Set<ViewLink> links = scanFirstLevelControllerAdvertise();
    model.addAttribute("links", links);
    return "index";
  }

  private Set<ViewLink> scanFirstLevelControllerAdvertise() {
    Set<ViewLink> result = new HashSet<ViewLink>();
    AdvertiseScanner scanner = new AdvertiseScanner(CONTROLLER_PACKAGE_NAME);
    scanner.scanPackage( ads -> {
      String adsPath = ads.path();
      if (adsPath.indexOf('/') < 0) {
        ViewLink link = new ViewLink();
        link.setPath(adsPath);
        link.setName(ads.name());
        result.add(link);
      }
    });
    return result;
  }


  static {
    CONTROLLER_PACKAGE_NAME = HomeController.class.getPackage().getName();
  }
}


