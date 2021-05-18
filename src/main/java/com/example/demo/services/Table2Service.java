package com.example.demo.services;

import com.example.demo.models.Table2Model;
import com.example.demo.repo.jpa.Table2Repository;
import com.example.demo.schema.BaseEntity;
import com.example.demo.schema.Table1;
import com.example.demo.schema.Table2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class Table2Service {

    private Table2Repository table2Repository;
    private Table1Service table1Service;

    @Autowired
    public Table2Service(Table2Repository table2Repository, Table1Service table1Service) {
        this.table2Repository = table2Repository;
        this.table1Service = table1Service;
    }

    public Table2 createWithRel(Table2Model table2b) {
        List<UUID> table1List = table2b.getTable1();
        List<Table1> table1s = this.table1Service.getEntityList(table1List);
        Table2 table2 = new Table2();
        table2.setAType(table2b.getAType());
        table2.setTable1(table1s.stream().collect(Collectors.toSet()));
        return this.table2Repository.save(table2);
    }
}
