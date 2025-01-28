package com.example.japaonamesa.Model.Category.Soups;

public class SoupsModel {
    private int soupImage;
    private String soupName;
    private int key_id;
    private int favStatus;


    public SoupsModel(int soupImage, String soupName, int key_id, int favStatus) {
        this.soupImage = soupImage;
        this.soupName = soupName;
        this.key_id = key_id;
        this.favStatus = favStatus;
    }

    public int getSoupImage() {
        return soupImage;
    }

    public void setSoupImage(int soupImage) {
        this.soupImage = soupImage;
    }

    public String getSoupName() {
        return soupName;
    }

    public void setSoupName(String soupName) {
        this.soupName = soupName;
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
