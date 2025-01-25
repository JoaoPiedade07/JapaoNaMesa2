package com.example.japaonamesa.FavouriteScreen.FavDB;

public class FavItem {
    private int id;
    private String title;
    private int image;

    // Construtor
    public FavItem(int id, String title, int image) {
        this.id = id;
        this.title = title;
        this.image = image;
    }

    // Getter para 'id'
    public int getId() {
        return id;
    }

    // Setter para 'id' (opcional, caso precise alterar o valor depois)
    public void setId(int id) {
        this.id = id;
    }

    // Getters e Setters para os outros campos
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
