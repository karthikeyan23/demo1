package com.example.demo.schema;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.type.TextType;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import static com.example.demo.utils.IdGenerator.UUID_NAMESPACE;

@Getter
@Setter
@NoArgsConstructor
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class),
        @TypeDef(name = "pgsql_enum", typeClass = PostgreSQLEnumType.class),
        @TypeDef(name = "pgsql_text", typeClass = TextType.class)
})
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID pKey;

    @Version
    private long version;

    @CreatedDate
    @Column(columnDefinition = "timestamp with time zone")
    private Instant createdAt;

    @LastModifiedDate
    @Column(columnDefinition = "timestamp with time zone")
    private Instant changedAt;

    @CreatedBy
    private UUID createdBy;

    @LastModifiedBy
    private UUID changedBy;


    protected <T extends BaseEntity> void setTableParams(T entity) {
        setPKey(entity.getPKey());
        setVersion(entity.getVersion());
        setCreatedBy(entity.getCreatedBy());
        setChangedBy(entity.getChangedBy());
        setCreatedAt(entity.getCreatedAt());
        setChangedAt(entity.getChangedAt());
    }
}
