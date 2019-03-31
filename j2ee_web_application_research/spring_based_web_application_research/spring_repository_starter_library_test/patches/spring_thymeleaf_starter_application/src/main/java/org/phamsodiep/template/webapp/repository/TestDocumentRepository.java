package org.phamsodiep.template.webapp.repository;


import org.phamsodiep.template.newnosql.repository.NewNosqlRepository;

import org.phamsodiep.template.webapp.model.TestDocument;


public interface TestDocumentRepository extends NewNosqlRepository<TestDocument, String> {
  TestDocument findByString(String string);
}


