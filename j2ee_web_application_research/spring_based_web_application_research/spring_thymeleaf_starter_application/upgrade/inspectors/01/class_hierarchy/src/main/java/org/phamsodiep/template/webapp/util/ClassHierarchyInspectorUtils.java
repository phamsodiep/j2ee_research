package org.phamsodiep.template.webapp.util;


import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;


public class ClassHierarchyInspectorUtils {
  public static List<Node> buildInterfaceHierarchies(
    ClassLoader classLoader,
    String packageName,
    String[] interfaceNames
  )
    throws ClassNotFoundException {
    // Compute parentChildrenMap which represent parent child relationship
    //  Retrieve all ancestors (summonAncestors)
    //  From this outcome, build a map represent the parent child relationship
    List<Class<?>> rootClasses = new ArrayList<Class<?>>();
    Map<Class<?>, List<Class<?>>> parentChildrenMap =
      new HashMap<Class<?>, List<Class<?>>>();
    for (String interfaceName: interfaceNames) {
      String classFullName = packageName + "." + interfaceName;  
      Class<?> clazz = classLoader.loadClass(classFullName);
      List<Class> ancestors = summonAncestors(clazz);
      boolean isRoot = isRootNode(ancestors, packageName, interfaceNames);

      if (isRoot) { 
        rootClasses.add(clazz);
      }
      else {
        // Build a map represent the parent child relationship
        //   key:   target query class (act as an ancestor)
        //   value: all of its children
        for (Class<?> ancestor : ancestors) {
          List<Class<?>> parentChildren = parentChildrenMap.get(ancestor);
          if (parentChildren == null) {
            parentChildren = new ArrayList<Class<?>>();
            parentChildrenMap.put(ancestor, parentChildren);
            parentChildren = parentChildrenMap.get(ancestor);
          }
          parentChildren.add(clazz);
        }
      }
    }
    List<Node> result = new ArrayList<Node>();
    for (Class<?> rootClass : rootClasses) {
      result.add(buildInterfaceHierarchy(rootClass, parentChildrenMap));
    }
    return result;
  }

  private static Node buildInterfaceHierarchy(
    Class<?> rootClass,
    Map<Class<?>, List<Class<?>>> parentChildrenMap
  ) {
    Node rootNode = new Node();
    List<Node> children = new ArrayList<Node>();
    rootNode.setClazz(rootClass);
    rootNode.setChildren(children);
    List<Class<?>> childClasses = parentChildrenMap.get(rootClass);
    if (childClasses != null) {
      for (Class<?> childClass: childClasses) {
        Node subTree = buildInterfaceHierarchy(childClass, parentChildrenMap);
        children.add(subTree);
      }
    }
    return rootNode;
  }

  private static List<Class> summonAncestors(Class clazz){
    // It is noted that:
    //   . A class implements many interfaces
    //   . An interface has never had super class
    // We need summon class ancestors first, then summon interface ancestors
    // so that we do not need re-summon class ancestor for the new
    // summoned interface ancestor get.
    ArrayList<Class> ancestors = new ArrayList<Class>();

    // Summon class ancestors
    Class classAncestor = clazz.getSuperclass();
    if (classAncestor != null && !(classAncestor.equals(Object.class))) {
      ancestors.add(classAncestor);
      for(int i = 0; i < ancestors.size(); i++) {
        Class ancestor = ancestors.get(i);
        classAncestor = ancestor.getSuperclass();
        if (classAncestor != null && !(classAncestor.equals(Object.class))) {
          ancestors.add(classAncestor);
        }
      }
    }

    // Summon interfaces
    ancestors.addAll(Arrays.asList(clazz.getInterfaces()));
    for(int i = 0; i < ancestors.size(); i++) {
      Class ancestor = ancestors.get(i);
      Class[] implementedIfs = ancestor.getInterfaces();
      ancestors.addAll(Arrays.asList(implementedIfs));
    }
    return ancestors;
  }

  private static boolean isRootNode(
    List<Class> ancestors,
    String packageName,
    String[] candidateAncestorSimpleNames
  ) {
    boolean isRoot = true;
    int n = candidateAncestorSimpleNames.length;
    // Travel candidateAncestorSimpleNames
    // if there is a candidate ancestor is accepted as an ancestor.
    // That mean target node is not root any more.
    for (int i = 0; i < n && isRoot; i++) {
      String candidateAncestorSimpleName = candidateAncestorSimpleNames[i];
      String candidateAncestorName =
        packageName + "." + candidateAncestorSimpleName;
      for(Class clazz : ancestors) {
        String ancestorName = clazz.getName();
        if (candidateAncestorName.compareTo(ancestorName) == 0) {
          isRoot = false;
          break;
        }
      }
    }

    return isRoot;
  }


  public static final class Node {
    private Class clazz;
    private List<Node> children;

    public Class getClazz() {
      return clazz;
    }
    public void setClazz(Class clazz) {
      this.clazz = clazz;
    }
    public List<Node> getChildren() {
      return children;
    }
    public void setChildren(List<Node> children) {
      this.children = children;
    }
  }
}


