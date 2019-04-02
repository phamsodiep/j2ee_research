package org.phamsodiep.template.webapp.controller;


import java.util.Set;
import java.util.HashSet;
import java.lang.annotation.Annotation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.config.BeanDefinition;

import org.phamsodiep.template.webapp.model.ViewLink;
import org.phamsodiep.template.webapp.stereotypes.Advertise;


@Controller
public class HomeController {
  private static final String CONTROLLER_PACKAGE_NAME;
  private static final String HOME_CONTROLLER_CLASS;

  @GetMapping("/")
  public String homePage(Model model) {
    Set<ViewLink> links = scanControllerAdvertise();
    model.addAttribute("links", links);
    return "index";
  }

  private Set<ViewLink> scanControllerAdvertise() {
    final String packageName = CONTROLLER_PACKAGE_NAME;
    Set<ViewLink> result = new HashSet<ViewLink>();
    ClassPathScanningCandidateComponentProvider scanner =
      new ClassPathScanningCandidateComponentProvider(true);
    scanner.addIncludeFilter(new AnnotationTypeFilter(Controller.class));
    Set<BeanDefinition> bds = scanner.findCandidateComponents(packageName);

    for (BeanDefinition bd : bds) {
      String foundClassName = bd.getBeanClassName();
      try {
        if (foundClassName.compareTo(HOME_CONTROLLER_CLASS) != 0) {
          Class<?> foundClass = Class.forName(foundClassName);
          for (Annotation at : foundClass.getAnnotations()) {
            if (at.annotationType() == Advertise.class) {
              Advertise advertise = (Advertise) at;
              String adPath = advertise.path();
              if (adPath.indexOf('/') < 0) {
                ViewLink link = new ViewLink();
                link.setPath(adPath);
                link.setName(advertise.name());
                result.add(link);
              }
              break;
            }
          }
        }
      }
      catch(Exception e) {
        //e.printStackTrace();
      }
    }

    return result;
  }

  static {
    CONTROLLER_PACKAGE_NAME = HomeController.class.getPackage().getName();
    HOME_CONTROLLER_CLASS = HomeController.class.getName();
  }
}


