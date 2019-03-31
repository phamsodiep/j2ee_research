package org.phamsodiep.template.newnosql.repository;


import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;


@NoRepositoryBean
public interface NewNosqlRepository<T, ID> extends
  PagingAndSortingRepository<T, ID>,
  QueryByExampleExecutor<T> {

  @Override
  <S extends T> List<S> saveAll(Iterable<S> entites);

  @Override
  List<T> findAll();

  @Override
  List<T> findAll(Sort sort);

  @Override
  <S extends T> List<S> findAll(Example<S> example);

  @Override
  <S extends T> List<S> findAll(Example<S> example, Sort sort);

  //<S extends T> S insert(S entity);

  //<S extends T> List<S> insert(Iterable<S> entities);
}


