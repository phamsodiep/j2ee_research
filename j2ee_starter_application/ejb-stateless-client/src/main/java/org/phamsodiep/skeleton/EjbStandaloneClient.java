package org.phamsodiep.skeleton;


import javax.naming.InitialContext;
import java.util.Collection;


public class EjbStandaloneClient {
  public static void main(String args[]) {
    final String jndiUri = "phamsodiep/ejb/HostManagementSessionBean";
    try {
      InitialContext ic = new InitialContext();
      HostManagementSessionBeanRemote h =
      (HostManagementSessionBeanRemote) ic.lookup(jndiUri);
      Collection<String> hosts = h.getHosts();
      for (String host : hosts) {
        System.out.println(host);
      }
    } catch(Exception e) {
        e.printStackTrace();
    }
  }
}


