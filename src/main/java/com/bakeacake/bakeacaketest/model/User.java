package com.bakeacake.bakeacaketest.model;

import java.sql.Timestamp;

import lombok.*;
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String username;
    private String password;
    private String email;
    private Timestamp createdAt;
    private Timestamp updatedAt;


    public User(Integer id, String name, String username, String email, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public User(String name, String username, String password, String email) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;

    }


}
