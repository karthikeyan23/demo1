package com.example.demo.repo.jpa;

import com.example.demo.schema.Table1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "table1", path = "table1")
public interface Table1Repository extends JpaRepository<Table1, UUID> {
}
