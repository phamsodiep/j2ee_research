package org.phamsodiep.template.newnosql.repository.config;


import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.data.repository.config.RepositoryConfigurationExtensionSupport;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.config.AnnotationRepositoryConfigurationSource;
import org.springframework.data.repository.config.XmlRepositoryConfigurationSource;

import org.phamsodiep.template.newnosql.repository.NewNosqlRepository;
import org.phamsodiep.template.newnosql.core.mapping.Document;


public class NewNosqlRepositoryConfigurationExtension extends
  RepositoryConfigurationExtensionSupport {

	@Override
	public String getRepositoryFactoryBeanClassName() {
    // TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getModulePrefix() {
		return "newnosql";
	}

  @Override
  protected boolean useRepositoryConfiguration(RepositoryMetadata metadata) {
    return true;
  }
  
  @Override
  protected Collection<Class<?>> getIdentifyingTypes() {
    return Collections.singleton(NewNosqlRepository.class);
  }
  
  @Override
  public void postProcess(BeanDefinitionBuilder builder, AnnotationRepositoryConfigurationSource config) {
    // TODO Auto-generated method stub
  }

  @Override
  public void postProcess(BeanDefinitionBuilder builder, XmlRepositoryConfigurationSource config) {
    // TODO Auto-generated method stub
  }

  @Override
  public String getModuleName() {
    return "NewNosqlDB";
  }

  @Override
  protected Collection<Class<? extends Annotation>> getIdentifyingAnnotations() {
    return Collections.singleton(Document.class);
  }
}


