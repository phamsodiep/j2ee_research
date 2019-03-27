package org.phamsodiep.skeleton;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.Collection;
import java.util.ArrayList;

@Stateless(
  name="HostManagementSessionBean",
  mappedName="phamsodiep/ejb/HostManagementSessionBean"
)
@Local(HostManagementSessionBeanLocal.class)
@Remote(HostManagementSessionBeanRemote.class)
public class HostManagementSessionBean implements
  HostManagementSessionBeanLocal, HostManagementSessionBeanRemote  {

  @Override
  public Collection<String> getHosts() {
    ArrayList<String> result = new ArrayList<String>();
    result.add("localhost");
    result.add("phamsodiep.blogspot.com");
    result.add("phamsodiep.appspot.com");
    return result;
  }

  @Override
  public String getRootUserName() {
    return "administrator";
  }
}


