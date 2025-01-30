package com.example.japaonamesa.Model.History;

public class HistoryModel {

    private int historyImage;
    private String historyName;
    private int key_id;
    private int favStatus;

    public HistoryModel(int image, String name, int key_id, int favStatus) {
        this.historyImage = image;
        this.historyName = name;
        this.key_id = key_id;
        this.favStatus = favStatus;

    }

    public int getImage() {
        return historyImage;
    }

    public String getName() {
        return historyName;
    }
    public int getKey_id() {
        return key_id;
    }
    public int getFavStatus() {
        return favStatus;
    }
    public void setFavStatus(int favStatus) {
        this.favStatus = favStatus;
    }
}
