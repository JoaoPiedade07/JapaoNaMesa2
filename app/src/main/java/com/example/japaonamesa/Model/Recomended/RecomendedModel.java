package com.example.japaonamesa.Model.Recomended;

public class RecomendedModel {

    private int recomendedImage;
    private String recomendedName;
    private String key_id;
    private String favStatus;

    public RecomendedModel(int image, String name, String key_id, String favStatus) {
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
    public String getKey_id() {
        return key_id;
    }
    public String getFavStatus() {
        return favStatus;
    }
    public void setFavStatus(String favStatus) {
        this.favStatus = favStatus;
    }



}
