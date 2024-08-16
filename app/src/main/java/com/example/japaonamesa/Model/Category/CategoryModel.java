package com.example.japaonamesa.Model.Category;

public class CategoryModel {
    private int image;
    private String name;

    public CategoryModel(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}
