package com.bakeacake.bakeacaketest.repository;

public class DataManager {
    private static DataManager dataManager_instance;
    private Integer loggedInUserId = null;
    private String selectedCakeTitle = null;
    private Integer clientId = null;
    private Integer orderId = null;
    private String orderStatus = "Pending";

    DataManager(){}

    public static DataManager getInstance() {
        if (dataManager_instance == null) dataManager_instance = new DataManager();
        return dataManager_instance;
    }

    public Integer getLoggedInUserId() {return loggedInUserId;}

    public void setLoggedInUserId(Integer loggedInUserId) {
        this.loggedInUserId = loggedInUserId;
    }


    public String getSelectedCakeTitle() {
        return selectedCakeTitle;
    }

    public void setSelectedCakeTitle(String selectedCakeTitle) {
        this.selectedCakeTitle = selectedCakeTitle;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
