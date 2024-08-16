package com.example.japaonamesa.Model;

public class AchievementsModel {

    private int AchievementsImage;
    private String AchievementsName;

    public AchievementsModel(int image, String name) {
        this.AchievementsImage = image;
        this.AchievementsName = name;
    }

    public int getAchievementsImage() { return AchievementsImage;
    }

    public String getAchievementsName() { return AchievementsName;
    }
}
