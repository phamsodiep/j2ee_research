package org.phamsodiep.template.webapp.model;


import org.springframework.web.multipart.MultipartFile;


public final class ClassHierarchyInspectorForm {
  private MultipartFile jarLibfile;
  private String packageName;
  private String classNameList;


  public MultipartFile getJarLibfile() {
    return this.jarLibfile;
  }

  public void setJarLibfile(MultipartFile jarLibfile) {
    this.jarLibfile = jarLibfile;
  }

  public String getPackageName() {
    return this.packageName;
  }

  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }

  public String getClassNameList() {
    return this.classNameList;
  }

  public void setClassNameList(String classNameList) {
    this.classNameList = classNameList;
  }
}


