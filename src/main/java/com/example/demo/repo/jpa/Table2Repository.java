package com.example.demo.repo.jpa;

import com.example.demo.schema.Table1;
import com.example.demo.schema.Table2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "table2", path = "table2")
public interface Table2Repository extends JpaRepository<Table2, UUID> {
}
