package com.canavdan.todo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "MEMBER")
@SequenceGenerator(name = Member.ENTITY_SEQ, sequenceName = Member.ENTITY_SEQ, allocationSize = 1)
public class Member implements Serializable {

    public static final String ENTITY_SEQ = "MEMBER_SEQ";

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = ENTITY_SEQ, strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank(message = "Name is required")
    @Column(name = "NAME")
    private String name;
    @Column(name="SURNAME")
    private String surname;
    @Column(name = "EMAIL")
    private String email;
    @Size(min = 3,message = "Username must be minimum 4 characters.")
    @NotBlank(message = "Username is required")
    @Column(name = "USERNAME")
    private String username;
    @Size(min = 4,message = "Password must be minimum 4 characters.")
    @NotBlank(message = "Password is required")
    @Column(name = "PASSWORD")
    private String password;



    @Column(name = "REGISTER_AT")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date register_At;
    @Column(name = "UPDATED_AT")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updated_At;

    @PrePersist
    protected void onCreate(){
        this.register_At = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updated_At = new Date();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
