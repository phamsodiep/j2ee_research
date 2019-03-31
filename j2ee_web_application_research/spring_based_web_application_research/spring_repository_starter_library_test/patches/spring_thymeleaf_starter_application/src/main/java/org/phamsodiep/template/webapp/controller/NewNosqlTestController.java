package org.phamsodiep.template.webapp.controller;


import org.phamsodiep.template.webapp.stereotypes.Advertise;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import org.phamsodiep.template.webapp.repository.TestDocumentRepository;
import org.phamsodiep.template.webapp.model.TestDocument;


@Advertise(
  path="testnewnosql",
  name="Thymeleaf with @EnableNewNosqlRepositories to test spring_repository_starter_library"
)
@Controller
public class NewNosqlTestController {
  @Autowired
  private TestDocumentRepository repository;

  @RequestMapping(
    value  = "/testnewnosql",
    method = {RequestMethod.GET, RequestMethod.POST}
  )
  public String testNewNosqlRepositoryPage(
    final SearchForm form,
    Model model
  ) {
    if (form.getKey() != null) {
      try {
        TestDocument tdoc = this.repository.findByString(form.getKey());
        form.setTestDocument(tdoc);
      }
      catch(Exception e) {
      }
    }
    else {
      form.setKey("");
    }
    model.addAttribute("form", form);
    model.addAttribute("tdocs", this.repository.findAll());
    return "testnewnosql";
  }

  public static class SearchForm {
    private TestDocument testDocument;
    private String key;


    public TestDocument getTestDocument() {
      return this.testDocument;
    }

    public String getKey() {
      return this.key;
    }

    public void setTestDocument(TestDocument testDocument) {
      this.testDocument = testDocument;
    }

    public void setKey(String key) {
      this.key = key;
    }
  }
}


