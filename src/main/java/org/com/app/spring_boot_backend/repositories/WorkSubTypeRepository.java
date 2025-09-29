package org.com.app.spring_boot_backend.repositories;

import org.com.app.spring_boot_backend.entities.works.WorkSubType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkSubTypeRepository extends JpaRepository<WorkSubType,Long> {
}
