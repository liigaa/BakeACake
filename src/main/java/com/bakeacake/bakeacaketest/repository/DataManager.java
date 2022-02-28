package com.bakeacake.bakeacaketest.repository;

public class DataManager {
    private static DataManager dataManager_instance;
    private Integer loggedInUserId = null;
    private String selectedCakeTitle = null;
    private Double selectedTinSize = null;

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

    public Double getSelectedTinSize() {
        return selectedTinSize;
    }

    public void setSelectedTinSize(Double selectedTinSize) {
        this.selectedTinSize = selectedTinSize;
    }


}
