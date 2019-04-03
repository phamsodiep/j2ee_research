package org.phamsodiep.template.webapp.controller;


import java.util.HashSet;
import java.util.Set;

import org.phamsodiep.template.webapp.model.ViewLink;
import org.phamsodiep.template.webapp.stereotypes.Advertise;
import org.phamsodiep.template.webapp.util.AdvertiseScanner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Advertise(
  path=ConverterController.NAMESPACE,
  name="Converter utilities group"
)
@Controller
public class ConverterController {
  // View configuration: template names and urls
  static final String NAMESPACE                       = "converts";
  private static final String URL_PREFIX              = "/" + NAMESPACE;
  private static final String HOME_URL                = URL_PREFIX;
  private static final String HOME_TEMPLATE           = NAMESPACE + "/home";


  @RequestMapping(
    value  = ConverterController.HOME_URL,
    method = {RequestMethod.GET}
  )
  public String processConvertHomePage(ModelMap model) {
    Set<ViewLink> links = scanConverterNamespaceControllerAdvertise();
    model.addAttribute("links", links);
    return ConverterController.HOME_TEMPLATE;
  }

  private Set<ViewLink> scanConverterNamespaceControllerAdvertise() {
    final String namespacePrefix = NAMESPACE + "/";
    String packageName = HomeController.CONTROLLER_PACKAGE_NAME;
    Set<ViewLink> result = new HashSet<ViewLink>();
    AdvertiseScanner scanner = new AdvertiseScanner(packageName);
    scanner.scanPackage( ads -> {
      String adsPath = ads.path();
      if (adsPath.startsWith(namespacePrefix)) {
        ViewLink link = new ViewLink();
        link.setPath(adsPath);
        link.setName(ads.name());
        result.add(link);
      }
    });
    return result;
  }
}


