package com.example.japaonamesa.Model.Category.Ramen;

public class RamenModel {

    private int ramenImage;
    private String ramenName;
    private int key_id;
    private int favStatus;


    public RamenModel(int ramenImage, String ramenName, int key_id, int favStatus) {
        this.ramenImage = ramenImage;
        this.ramenName = ramenName;
        this.key_id = key_id;
        this.favStatus = favStatus;
    }

    public int getRamenImage() {
        return ramenImage;
    }

    public void setRamenImage(int ramenImage) {
        this.ramenImage = ramenImage;
    }

    public String getRamenName() {
        return ramenName;
    }

    public void setRamenName(String ramenName) {
        this.ramenName = ramenName;
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
