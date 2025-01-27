package com.example.japaonamesa.Model.Category.Sushi;

public class SushiModel {

    private int sushiImage;
    private String sushiName;
    private int key_id;
    private int favStatus;


    public SushiModel(int sushiImage, String sushiName, int key_id, int favStatus) {
        this.sushiImage = sushiImage;
        this.sushiName = sushiName;
        this.key_id = key_id;
        this.favStatus = favStatus;
    }

    public int getSushiImage() {
        return sushiImage;
    }

    public void setSushiImage(int sushiImage) {
        this.sushiImage = sushiImage;
    }

    public String getSushiName() {
        return sushiName;
    }

    public void setSushiName(String sushiName) {
        this.sushiName = sushiName;
    }

    public int getKey_id() {
        return key_id;
    }

    public void setKey_id(int key_id) {
        this.key_id = key_id;
    }

    public int getFavStatus() {
        return favStatus;
    }

    public void setFavStatus(int favStatus) {
        this.favStatus = favStatus;
    }
}
