package org.com.app.spring_boot_backend.documents.repositories;


import org.com.app.spring_boot_backend.documents.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository  extends JpaRepository<Document, Integer> {


}


