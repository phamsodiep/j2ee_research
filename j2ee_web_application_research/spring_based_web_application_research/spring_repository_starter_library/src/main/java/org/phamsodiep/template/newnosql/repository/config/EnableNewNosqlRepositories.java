package org.phamsodiep.template.newnosql.repository.config;


import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ComponentScan.Filter;

import org.phamsodiep.template.newnosql.repository.config.NewNosqlRepositoriesRegistrar;
import org.phamsodiep.template.newnosql.repository.support.NewNosqlRepositoryFactoryBean;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(NewNosqlRepositoriesRegistrar.class)
public @interface EnableNewNosqlRepositories {
  String[] value() default {};
  String[] basePackages() default {};
  Class<?>[] basePackageClasses() default {};
  Class<?> repositoryFactoryBeanClass() default NewNosqlRepositoryFactoryBean.class;
  String namedQueriesLocation() default "";
  String repositoryImplementationPostfix() default "Impl";
  Filter[] includeFilters() default {};
  Filter[] excludeFilters() default {};
}


