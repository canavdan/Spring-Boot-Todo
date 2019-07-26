package com.canavdan.todo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Entity
@Table(name = "TODO_ITEM")
@SequenceGenerator(name = TodoItem.ENTITY_SEQ, sequenceName = TodoItem.ENTITY_SEQ, allocationSize = 1)
public class TodoItem {

    public static final String ENTITY_SEQ = "TODO_ITEM_SEQ";

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = ENTITY_SEQ, strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "NAME")
    @NotBlank(message = "To-do name is required")
    private String name;
    @Column(name="DESCRIPTION")
    private String description;
    @NotBlank(message = "Priority is required")
    @Column(name = "PRIORITY")
    private String priority;


    /*@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MEMBER_ID", nullable = false)
    private Member member;*/
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "STATUS_ID", nullable = false)
    private Status status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TODO_LIST_ID", nullable = false)
    private TodoList todoList;

    @Column(name = "DEADLINE")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date deadline;
    @Column(name = "CREATED_AT")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date created_At;
    @Column(name = "UPDATED_AT")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updated_At;

    @PrePersist
    protected void onCreate(){
        this.created_At = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updated_At = new Date();
    }

}
