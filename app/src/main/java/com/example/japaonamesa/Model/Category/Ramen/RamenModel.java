package com.example.japaonamesa.Model.Category.Ramen;

public class RamenModel {

    private int ramenImage;
    private String ramenName;
    private String key_id;
    private String favStatus;


    public RamenModel(int ramenImage, String ramenName, String key_id, String favStatus) {
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
