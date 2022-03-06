package com.bakeacake.bakeacaketest.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer id;
    private String client;
    private Integer client_id;
    private String cake;
    private String tinSize;
    private String datePicker;
    private String deliveryTime;
    private String deliveryOptions;
    private String description;
    private String status;

    public Order(String tinSize, String datePicker,
                 String deliveryTime, String deliveryOptions, String description,
                 String status) {
        this.tinSize = tinSize;
        this.datePicker = datePicker;
        this.deliveryTime = deliveryTime;
        this.deliveryOptions = deliveryOptions;
        this.description = description;
        this.status = status;
    }

    public Order(Integer client_id, String tinSize, String datePicker,
                 String deliveryTime, String deliveryOptions, String description,
                 String status) {
        this.client_id = client_id;
        this.tinSize = tinSize;
        this.datePicker = datePicker;
        this.deliveryTime = deliveryTime;
        this.deliveryOptions = deliveryOptions;
        this.description = description;
        this.status = status;
    }

    public Order(String client, String cake, String tinSize,
                 String datePicker, String deliveryTime, String deliveryOptions,
                 String description, String status) {
        this.client = client;
        this.cake = cake;
        this.tinSize = tinSize;
        this.datePicker = datePicker;
        this.deliveryTime = deliveryTime;
        this.deliveryOptions = deliveryOptions;
        this.description = description;
        this.status = status;
    }

    public Order(String client, Integer client_id, String cake, String tinSize,
                 String datePicker, String deliveryTime, String deliveryOptions,
                 String description, String status) {
        this.client = client;
        this.client_id = client_id;
        this.cake = cake;
        this.tinSize = tinSize;
        this.datePicker = datePicker;
        this.deliveryTime = deliveryTime;
        this.deliveryOptions = deliveryOptions;
        this.description = description;
        this.status = status;
    }

    @Override
    public String toString() {
        return client + "\n" + cake + "\n" + tinSize + "\n" + datePicker + "\n" +
                deliveryTime + "\n" +
                deliveryOptions +  "\n" +description +"\n" + status;
    }
}
