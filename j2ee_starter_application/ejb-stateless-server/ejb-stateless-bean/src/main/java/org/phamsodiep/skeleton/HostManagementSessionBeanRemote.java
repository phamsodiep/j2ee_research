package org.phamsodiep.skeleton;


import javax.ejb.Remote;
import java.util.Collection;


@Remote
public interface HostManagementSessionBeanRemote {
  Collection<String> getHosts();
}


