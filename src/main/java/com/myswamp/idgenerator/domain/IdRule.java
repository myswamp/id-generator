package com.myswamp.idgenerator.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="idg_id_rule")
public class IdRule {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "bigint(20)", nullable = false)
    private int id;

    @Column(name = "business_tag", columnDefinition = "varchar(255)",nullable = false, unique = true)
    private String businessTag;

    @Column(name = "max_id", columnDefinition = "bigint(20)", nullable = false)
    private long maxId;

    @Column(columnDefinition = "int(10)", nullable = false)
    private int step;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private int description;

    @Column(name = "created_on", columnDefinition = "timestamp default current_timestamp", nullable = false)
    private Date createdOn;

    @Column(name = "updated_on", columnDefinition = "timestamp on update current_timestamp", nullable = false)
    private Date updatedOn;
}