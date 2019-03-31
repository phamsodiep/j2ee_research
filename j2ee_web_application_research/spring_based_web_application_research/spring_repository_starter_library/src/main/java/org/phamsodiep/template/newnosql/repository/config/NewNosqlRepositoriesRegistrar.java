package org.phamsodiep.template.newnosql.repository.config;


import java.lang.annotation.Annotation;

import org.springframework.data.repository.config.RepositoryBeanDefinitionRegistrarSupport;
import org.springframework.data.repository.config.RepositoryConfigurationExtension;


public class NewNosqlRepositoriesRegistrar extends RepositoryBeanDefinitionRegistrarSupport {
  @Override
  protected Class<? extends Annotation> getAnnotation() {
    return EnableNewNosqlRepositories.class;
  }

  @Override
  protected RepositoryConfigurationExtension getExtension() {
    return new NewNosqlRepositoryConfigurationExtension();
  }
}


