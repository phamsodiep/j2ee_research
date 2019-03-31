package org.phamsodiep.template.newnosql.repository.support;


import java.util.Optional;

import org.springframework.lang.Nullable;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.data.repository.core.support.RepositoryComposition.RepositoryFragments;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.EntityInformation;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.data.repository.query.QueryLookupStrategy.Key;
import org.springframework.data.repository.query.EvaluationContextProvider;

import org.phamsodiep.template.newnosql.repository.support.NewNosqlQueryLookupStrategy;


public class NewNosqlRepositoryFactory extends RepositoryFactorySupport {
  public NewNosqlRepositoryFactory() {

  }

  @Override
  protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
    return SimpleNewNosqlRepository.class;
  }

  @Override
  protected RepositoryFragments getRepositoryFragments(RepositoryMetadata metadata) {
    RepositoryFragments fragments = RepositoryFragments.empty();
    return fragments;
  }

  @Override
  protected Object getTargetRepository(RepositoryInformation information) {
    return new SimpleNewNosqlRepository(information);
  }

  @Override
  protected Optional<QueryLookupStrategy> getQueryLookupStrategy(
      @Nullable Key key,
      EvaluationContextProvider evaluationContextProvider
  ) {
    return Optional.of(new NewNosqlQueryLookupStrategy());
  }

  @Override
  public <T, ID> EntityInformation<T, ID> getEntityInformation(
    Class<T> domainClass
  ) {
    // TODO Auto-generated method stub
    return null;
  }
}


