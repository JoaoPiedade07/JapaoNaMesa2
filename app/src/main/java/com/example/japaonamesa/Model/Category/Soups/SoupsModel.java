package com.example.japaonamesa.Model.Category.Soups;

public class SoupsModel {
    private int soupImage;
    private String soupName;
    private String key_id;
    private String favStatus;


    public SoupsModel(int soupImage, String soupName, String key_id, String favStatus) {
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
