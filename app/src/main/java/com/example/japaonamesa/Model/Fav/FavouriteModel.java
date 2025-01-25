package com.example.japaonamesa.Model.Fav;

public class FavouriteModel {
    private int id;          // Identificador único para o item
    private String title;    // Título do item favorito
    private int image;       // Referência ao recurso de imagem (R.drawable)

    // Construtor vazio (necessário para algumas bibliotecas, como Firebase)
    public FavouriteModel() {
    }

    // Construtor com parâmetros
    public FavouriteModel(int id, String title, int image) {
        this.id = id;
        this.title = title;
        this.image = image;
    }

    // Getter e Setter para o ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter e Setter para o título
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter e Setter para a imagem
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

