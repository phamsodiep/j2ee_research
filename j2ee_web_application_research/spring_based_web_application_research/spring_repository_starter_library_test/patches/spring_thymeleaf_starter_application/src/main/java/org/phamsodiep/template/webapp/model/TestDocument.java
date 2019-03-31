package org.phamsodiep.template.webapp.model;


import org.phamsodiep.template.newnosql.core.mapping.Document;


@Document
public class TestDocument {
  private Integer integer;
  private String string;


  public Integer getInteger() {
    return this.integer;
  }

  public String getString() {
    return this.string;
  }

  public void setInteger(Integer integer) {
    this.integer = integer;
  }

  public void setString(String string) {
    this.string = string;
  }
}


