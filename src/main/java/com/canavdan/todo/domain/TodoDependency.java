package com.canavdan.todo.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TODO_DEPENDENCY")
@SequenceGenerator(name = TodoDependency.ENTITY_SEQ, sequenceName = TodoDependency.ENTITY_SEQ, allocationSize = 1)
public class TodoDependency implements Serializable {

    public static final String ENTITY_SEQ = "TODO_DEPENDENCY_SEQ";

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = ENTITY_SEQ, strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TODO_ITEM_ID", nullable = false)
    private TodoItem todoItem;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TODO_ITEM_ID2", nullable = false)
    private TodoItem todoItem2;

}
