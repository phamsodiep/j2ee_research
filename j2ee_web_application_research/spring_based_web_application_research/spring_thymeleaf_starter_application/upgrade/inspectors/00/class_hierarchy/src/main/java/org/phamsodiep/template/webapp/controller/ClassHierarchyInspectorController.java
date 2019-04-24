package org.phamsodiep.template.webapp.controller;


import java.io.InputStream;
import java.util.Map;
import java.util.HashMap;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import org.phamsodiep.template.webapp.stereotypes.Advertise;
import org.phamsodiep.template.webapp.model.ClassHierarchyInspectorForm;
import org.phamsodiep.template.webapp.model.ViewLink;


@Advertise(
  path=ClassHierarchyInspectorController.NAMESPACE,
  name="Class hierarchy inspect utility"
)
@Controller
public class ClassHierarchyInspectorController {
  // View configuration: template names and urls
  private static final String CLASS_HIERARCHY_INSPECTOR = "/class_hierarchy";
  static final String         NAMESPACE                 =
    InspectorController.NAMESPACE + CLASS_HIERARCHY_INSPECTOR;
  private static final String CLASS_HIERARCHY_INSPECTOR_URL = "/" + NAMESPACE;
  private static final String CLASS_HIERARCHY_INSPECTOR_TEMPLATE = NAMESPACE;

  private static final String INSPECTED_LIB_VAR_NAME = "inspectedLibs";
  private static final String UPLOAD_LIB_RESOURCE_URL =
    CLASS_HIERARCHY_INSPECTOR_URL + "/" + INSPECTED_LIB_VAR_NAME;
  private static final String CLASS_HIERARCHY_INSPECTOR_RESULT_URL =
    CLASS_HIERARCHY_INSPECTOR_URL + "/result";


  @Autowired
  private ServletContext servletContext;


  @RequestMapping(
    value = UPLOAD_LIB_RESOURCE_URL + "/{filename}",
    method = RequestMethod.GET
  )
  public ResponseEntity<Resource> processGetInspectedLibResource(
    @PathVariable(value = "filename") String fileName
  ) {
    HttpHeaders header = new HttpHeaders();
    header.add(
      HttpHeaders.CONTENT_DISPOSITION,
      "attachment; filename=" + fileName
    );
    header.add("Cache-Control", "no-cache, no-store, must-revalidate");
    header.add("Pragma", "no-cache");
    header.add("Expires", "0");

    ByteArrayResource resource = null;
    int bufferLength = 0;
    Object obj = servletContext.getAttribute(INSPECTED_LIB_VAR_NAME);
    if (obj != null && obj instanceof Map) {
      Map<String, byte[]> jarLibMap = (Map<String, byte[]>) obj;
      byte[] buffer = jarLibMap.get(fileName);
      if (buffer != null) {
        bufferLength = buffer.length;
        resource = new ByteArrayResource(buffer);
      }
    }
    if (resource == null) {
      resource = new ByteArrayResource(new byte[0]);
    }

    return ResponseEntity.ok()
      .headers(header)
      .contentLength(bufferLength)
      .contentType(MediaType.parseMediaType("application/java-archive"))
      .body(resource);
  }

  @RequestMapping(
    value  = CLASS_HIERARCHY_INSPECTOR_URL,
    method = {RequestMethod.GET}
  )
  public String processDisplayClassHierarchyInspectorPage(
   ModelMap model
  ) {
    model.addAttribute("formModel", new ClassHierarchyInspectorForm());
    return CLASS_HIERARCHY_INSPECTOR_TEMPLATE;
  }

  @RequestMapping(
    value  = CLASS_HIERARCHY_INSPECTOR_URL,
    method = {RequestMethod.POST}
  )
  public String processClassHierarchyInspectorUpload(
    final ClassHierarchyInspectorForm formObj
  ) {
    String fileName = "";
    // Read uploaded content
    try {
      byte[] buffer = null;
      MultipartFile file = formObj.getJarLibfile();
      fileName = file.getOriginalFilename();
      InputStream is = file.getInputStream();
      for(int size = is.available(); size > 0; size = is.available()) {
        byte[] chunkBuffer = new byte[size];
        int realSize = is.read(chunkBuffer);
        if (buffer == null) {
          if (realSize == size) {
            buffer = chunkBuffer;
          }
          else {
            buffer = new byte[realSize];
            System.arraycopy(chunkBuffer, 0, buffer, 0, realSize);
          }
        }
        else {
          byte[] oldBuffer = buffer;
          int oldSize = oldBuffer.length;
          buffer = new byte[realSize + oldSize];
          System.arraycopy(oldBuffer, 0, buffer, 0, oldSize);
          System.arraycopy(chunkBuffer, 0, buffer, oldSize, realSize);
        }
      }

      // Put content buffer to application scope variable
      Object obj = servletContext.getAttribute(INSPECTED_LIB_VAR_NAME);
      if (obj == null) {
        Map<String, byte[]> jarLibMap = new HashMap<String, byte[]>();
        jarLibMap.put(fileName, buffer);
        servletContext.setAttribute(INSPECTED_LIB_VAR_NAME, jarLibMap);
      }
      else if (obj instanceof Map) {
        Map<String, byte[]> jarLibMap = (Map<String, byte[]>) obj;
        jarLibMap.put(fileName, buffer);
      }
      else {
        System.err.println(
          "Conflict session variable name '"
          + INSPECTED_LIB_VAR_NAME
          + "' detected"
        );
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return "redirect:" + CLASS_HIERARCHY_INSPECTOR_RESULT_URL + "/" + fileName;
  }

  @RequestMapping(
    value = CLASS_HIERARCHY_INSPECTOR_RESULT_URL + "/{filename}",
    method = {RequestMethod.GET}
  )
  public String processDisplayClassHierarchyInspectorResultPage(
    @PathVariable(value = "filename") String fileName,
    ModelMap model
  ) {
    ViewLink link = new ViewLink();
    link.setName(fileName);
    link.setPath(UPLOAD_LIB_RESOURCE_URL + "/" + fileName);
    model.addAttribute("link", link);
    // This is a temporary page so harded code exists.
    return InspectorController.NAMESPACE + "/showdownloadpage";
  }
}


