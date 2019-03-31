package org.phamsodiep.template.newnosql.repository.support;


import java.io.Serializable;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;


public class NewNosqlRepositoryFactoryBean <T extends Repository<S, ID>, S, ID extends Serializable>
  extends RepositoryFactoryBeanSupport<T, S, ID> {
  public NewNosqlRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
      super(repositoryInterface);
  }

  @Override
  protected RepositoryFactorySupport createRepositoryFactory() {
    return new NewNosqlRepositoryFactory();
  }
}


