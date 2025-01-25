package com.example.japaonamesa.Model.Recomended;

public class RecomendedModel {

    private int recomendedImage;
    private String recomendedName;
    private int key_id;
    private int favStatus;

    public RecomendedModel(int image, String name, int key_id, int favStatus) {
        this.recomendedImage = image;
        this.recomendedName = name;
        this.key_id = key_id;
        this.favStatus = favStatus;

    }

    public int getImage() {
        return recomendedImage;
    }

    public String getName() {
        return recomendedName;
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
