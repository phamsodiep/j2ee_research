package org.phamsodiep.skeleton;


import javax.ejb.Local;


@Local
public interface HostManagementSessionBeanLocal {
  String getRootUserName();
}


