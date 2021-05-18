package com.example.demo.restapi;

import com.example.demo.models.Table2Model;
import com.example.demo.schema.Table1;
import com.example.demo.schema.Table2;
import com.example.demo.services.Table2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RepositoryRestController
@RequestMapping("/table2")
@ExposesResourceFor(Table1.class)
@Slf4j
public class Table2Resource {
    private Table2Service table2Service;

    @Autowired
    public Table2Resource(Table2Service table2Service) {
        this.table2Service = table2Service;
    }

    @PostMapping("/create-wih-ref")
    public ResponseEntity createWithRef(@RequestBody Table2Model table2b,
                                        PersistentEntityResourceAssembler resourceAssembler){
        return ResponseEntity.ok(resourceAssembler.toModel(this.table2Service.createWithRel(table2b)));
    }
}


