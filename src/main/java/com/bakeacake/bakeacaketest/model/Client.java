package com.bakeacake.bakeacaketest.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private Integer id;
    private Integer user_id;
    private String name;
    private String phoneNumber;
    private String address;

    public Client(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Client(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Client(Integer user_id, String name, String phoneNumber, String address) {
        this.user_id = user_id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    @Override
    public String toString() {
        return name;
    }
}
