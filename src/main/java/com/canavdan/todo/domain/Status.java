package com.canavdan.todo.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "STATUS")
@SequenceGenerator(name = Status.ENTITY_SEQ, sequenceName = Status.ENTITY_SEQ, allocationSize = 1)
public class Status implements Serializable {

    public static final String ENTITY_SEQ = "STATUS_SEQ";

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = ENTITY_SEQ, strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "STATUS")
    private String status;

}
