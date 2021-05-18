package com.example.demo.schema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Audited
@Table(name = "table_1")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Table1 extends BaseEntity{
    @Column(name = "key_field")
    private UUID key;

    @Enumerated(EnumType.STRING)
    private aType aType;

    @Type(type ="pgsql_text")
    @Column(columnDefinition = "text")
    private String remarks;

    @ManyToOne
    @JoinColumn(name = "test")
    private Table2 table2;

    public Table1(Table1 other){
        this.key = other.key;
        this.aType = other.aType;
        this.remarks = other.remarks;
        this.setTableParams(other);
    }

}
