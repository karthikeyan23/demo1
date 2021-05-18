package com.example.demo.schema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Set;

@Entity
@Audited
@Table(name = "table_2")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Table2 extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private aType aType;

    @OneToMany
    private Set<Table1> table1;

    public Table2(Table2 other) {
        this.aType = other.aType;
        this.table1 = other.table1;
        this.setTableParams(other);
    }
}
