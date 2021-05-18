package com.example.demo.services;

import com.example.demo.repo.jpa.Table1Repository;
import com.example.demo.schema.Table1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class Table1Service {

    private Table1Repository table1Repository;

    @Autowired
    public Table1Service(Table1Repository table1Repository) {
        this.table1Repository = table1Repository;
    }

    public Table1 getEntity(UUID pKey) {
        return this.table1Repository.getOne(pKey);
    }

    public List<Table1> getEntityList(List<UUID> table1List) {
        return this.table1Repository.findAllById(table1List);
    }
}
