package org.phamsodiep.template.webapp.util;


import java.lang.annotation.Annotation;
import java.util.Set;
import java.util.function.Consumer;

import org.phamsodiep.template.webapp.stereotypes.Advertise;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Controller;


public class AdvertiseScanner {
  private Set<BeanDefinition> beanDefinitions;


  public AdvertiseScanner(String basePackage) {
    ClassPathScanningCandidateComponentProvider scanner =
      new ClassPathScanningCandidateComponentProvider(true);
    scanner.addIncludeFilter(new AnnotationTypeFilter(Controller.class));
    this.beanDefinitions = scanner.findCandidateComponents(basePackage);
  }

  public void scanPackage(Consumer<Advertise> consumer) {
    for (BeanDefinition bd : this.beanDefinitions) {
      String foundClassName = bd.getBeanClassName();
      try {
        Class<?> foundClass = Class.forName(foundClassName);
        for (Annotation at : foundClass.getAnnotations()) {
          if (at.annotationType() == Advertise.class) {
            consumer.accept((Advertise) at);
            break;
          }
        }
      }
      catch(Exception e) {
      }
    }
  }
}


