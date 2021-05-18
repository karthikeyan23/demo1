package com.example.demo.restapi;

import com.example.demo.schema.Table1;
import com.example.demo.services.Table1Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RepositoryRestController
@RequestMapping("/table1")
@ExposesResourceFor(Table1.class)
@Slf4j
public class Table1Resource {

    private Table1Service table1Service;

    @Autowired
    public Table1Resource(Table1Service table1Service) {
        this.table1Service = table1Service;
    }

    @GetMapping("/test/{flag}")
    public ResponseEntity test(@RequestBody Object body, @PathVariable Boolean flag ){
        log.info(flag.toString());
        return ResponseEntity.ok(body);
    }
}
