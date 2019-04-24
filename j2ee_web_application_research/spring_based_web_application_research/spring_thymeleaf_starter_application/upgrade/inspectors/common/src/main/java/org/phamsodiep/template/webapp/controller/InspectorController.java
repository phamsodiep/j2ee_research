package org.phamsodiep.template.webapp.controller;


import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.phamsodiep.template.webapp.model.ViewLink;
import org.phamsodiep.template.webapp.stereotypes.Advertise;
import org.phamsodiep.template.webapp.util.AdvertiseScanner;


@Advertise(
  path=InspectorController.NAMESPACE,
  name="Inspector utilities group"
)
@Controller
public class InspectorController {
  // View configuration: template names and urls
  static final String NAMESPACE                       = "inspectors";
  private static final String URL_PREFIX              = "/" + NAMESPACE;
  private static final String HOME_URL                = URL_PREFIX;
  private static final String HOME_TEMPLATE           = NAMESPACE + "/home";


  @RequestMapping(
    value  = InspectorController.HOME_URL,
    method = {RequestMethod.GET}
  )
  public String processInspectorHomePage(ModelMap model) {
    Set<ViewLink> links = scanInspectorNamespaceControllerAdvertise();
    model.addAttribute("links", links);
    return InspectorController.HOME_TEMPLATE;
  }

  private Set<ViewLink> scanInspectorNamespaceControllerAdvertise() {
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


