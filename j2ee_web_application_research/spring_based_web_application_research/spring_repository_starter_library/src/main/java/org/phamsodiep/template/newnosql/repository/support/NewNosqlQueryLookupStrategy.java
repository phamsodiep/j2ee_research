package org.phamsodiep.template.newnosql.repository.support;


import java.lang.reflect.Method;

import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.NamedQueries;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.data.repository.query.RepositoryQuery;
import org.springframework.data.projection.ProjectionFactory;


public class NewNosqlQueryLookupStrategy implements QueryLookupStrategy {
  @Override
  public RepositoryQuery resolveQuery(
    Method method,
    RepositoryMetadata metadata,
    ProjectionFactory factory,
    NamedQueries namedQueries
  ) {
    return new NewNosqlRepositoryQuery(method, metadata, factory, namedQueries);
  }
}


