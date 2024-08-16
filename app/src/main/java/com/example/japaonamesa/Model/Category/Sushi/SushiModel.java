package com.example.japaonamesa.Model.Category.Sushi;

public class SushiModel {

    private int sushiImage;
    private String sushiName;
    private String key_id;
    private String favStatus;


    public SushiModel(int sushiImage, String sushiName, String key_id, String favStatus) {
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

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getFavStatus() {
        return favStatus;
    }

    public void setFavStatus(String favStatus) {
        this.favStatus = favStatus;
    }
}
