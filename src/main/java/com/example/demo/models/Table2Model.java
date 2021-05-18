package com.example.demo.models;

import com.example.demo.schema.aType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Table2Model implements Serializable {
    private aType aType;
    private List<UUID> table1;
}
