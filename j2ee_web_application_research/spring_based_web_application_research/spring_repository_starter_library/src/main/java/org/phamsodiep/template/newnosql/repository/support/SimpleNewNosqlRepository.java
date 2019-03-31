package org.phamsodiep.template.newnosql.repository.support;


import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Properties;
import java.util.Enumeration;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.beans.BeanUtils;

import org.phamsodiep.template.newnosql.repository.NewNosqlRepository;


public class SimpleNewNosqlRepository<T, ID> implements
  NewNosqlRepository<T, ID> {
  private RepositoryInformation information;

  public SimpleNewNosqlRepository(RepositoryInformation information) {
    // @TODO: generic class T, ID param verify with RepositoryInformation
    this.information = information;
  }

  @Override
  public Page<T> findAll(Pageable pageable) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <S extends T> S save(S entity) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Optional<T> findById(ID id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean existsById(ID id) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Iterable<T> findAllById(Iterable<ID> ids) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public long count() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void deleteById(ID id) {
    // TODO Auto-generated method stub
  }

  @Override
  public void delete(T entity) {
    // TODO Auto-generated method stub
  }

  @Override
  public void deleteAll(Iterable<? extends T> entities) {
    // TODO Auto-generated method stub
  }

  @Override
  public void deleteAll() {
    // TODO Auto-generated method stub
  }

  @Override
  public <S extends T> Optional<S> findOne(Example<S> example) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <S extends T> long count(Example<S> example) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public <S extends T> boolean exists(Example<S> example) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public <S extends T> List<S> saveAll(Iterable<S> entites) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<T> findAll() {
    System.out.println("SimpleNewNosqlRepository::findAll() is invoked");
    final String dbname = "db.properties";
    ArrayList<T> result = new ArrayList<T>();
    try {
      Properties database = new Properties();
      Class repositoryClass = this.information.getRepositoryInterface();
      Class domainType = this.information.getDomainType();
      InputStream dbStream = repositoryClass.getResourceAsStream(dbname);
      database.load(dbStream);
      dbStream.close();
      Enumeration<?> keyEnumeration = database.propertyNames();
      while(keyEnumeration.hasMoreElements()) {
        String key = keyEnumeration.nextElement().toString();
        Integer value = new Integer(database.getProperty(key));
        Object item = BeanUtils.instantiateClass(domainType);
        Method method = BeanUtils.findMethod(domainType, "setString", String.class);
        method.invoke(item, key);
        method = BeanUtils.findMethod(domainType, "setInteger", Integer.class);
        method.invoke(item, value);
        result.add((T)item);
      }
    }
    catch(Exception e) {
      //e.printStackTrace();
    }
    return result;
  }

  @Override
  public List<T> findAll(Sort sort) {
    // TODO Auto-generated method stub
    return null;
  }


  @Override
  public <S extends T> List<S> findAll(Example<S> example) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
    // TODO Auto-generated method stub
    return null;
  }

/*  @Override
  public <S extends T> S insert(S entity) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <S extends T> List<S> insert(Iterable<S> entities) {
    // TODO Auto-generated method stub
    return null;
  }*/
}


