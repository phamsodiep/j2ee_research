package org.phamsodiep.template.newnosql.repository.support;


import java.lang.reflect.Method;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.NamedQueries;
import org.springframework.data.repository.query.RepositoryQuery;
import org.springframework.data.repository.query.QueryMethod;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.beans.BeanUtils;


public class NewNosqlRepositoryQuery implements RepositoryQuery {
  private Method method;
  private RepositoryMetadata metadata;
  private ProjectionFactory factory;
  private NamedQueries namedQueries;


  public NewNosqlRepositoryQuery(
    Method method,
    RepositoryMetadata metadata,
    ProjectionFactory factory,
    NamedQueries namedQueries) {
    this.method = method;
    this.metadata = metadata;
    this.factory = factory;
    this.namedQueries = namedQueries;
  }

  @Override
  public Object execute(Object[] parameters) {
    System.out.println("NewNosqlRepositoryQuery::execute(Object[]) is invoked");
    Object obj = null;
    if (this.method.getParameterTypes().length == 1
      && this.method.getParameterTypes()[0] == String.class
    ) {
      try {
        // load data from "database"
        Properties prop = new Properties();
        Class repositoryClass = this.metadata.getRepositoryInterface();
        InputStream in = repositoryClass.getResourceAsStream("db.properties");
        prop.load(in);
        in.close();
        String key = (String) parameters[0];
        Integer value = new Integer(prop.getProperty(key));
        // map data to POJO
        Class domainType = this.metadata.getDomainType();
        obj = BeanUtils.instantiateClass(domainType);
        Method method = BeanUtils.findMethod(
          domainType,
          "setString",
          String.class
        );
        method.invoke(obj, key);
        method = BeanUtils.findMethod(domainType, "setInteger", Integer.class);
        method.invoke(obj, value);
      }
      catch(Exception e) {
        //e.printStackTrace();
      }
    }
    else {
      System.out.println("This repository method is not support yet!");
    }
    return obj;
  }

  @Override
  public QueryMethod getQueryMethod() {
    return new QueryMethod(this.method, this.metadata, this.factory);
  }
}


