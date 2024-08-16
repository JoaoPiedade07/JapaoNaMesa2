package com.example.japaonamesa.FavouriteScreen.FavDB;

public class FavItem {

    private String favName;
    private String key_id;
    private int favImage;

    public FavItem(String favName, String key_id, int favImage) {
        this.favName = favName;
        this.key_id = key_id;
        this.favImage = favImage;
    }

    public String getFavName() {
        return favName;
    }

    public String getKey_id() {
        return key_id;
    }

    public int getFavImage() {
        return favImage;
    }
}
