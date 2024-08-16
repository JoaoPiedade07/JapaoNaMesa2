package com.example.japaonamesa.Model.Fav;

public class FavouriteModel {

    private Integer imageFav;
    private String textFav;


    public FavouriteModel(Integer imageFav, String textFav) {
        this.imageFav = imageFav;
        this.textFav = textFav;
    }

    public void setImageFav(Integer imageFav) {
        this.imageFav = imageFav;
    }

    public void setTextFav(String textFav) {
        this.textFav = textFav;
    }

    public Integer getImageFav() { return imageFav;
    }

    public String getTextFav() { return textFav;
    }
}
