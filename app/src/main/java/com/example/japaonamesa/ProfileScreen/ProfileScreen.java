package com.example.japaonamesa.ProfileScreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.japaonamesa.Adapter.AchievementsAdapter;
import com.example.japaonamesa.FavouriteScreen.FavouriteScreen;
import com.example.japaonamesa.HomeScreen.HomeScreen;
import com.example.japaonamesa.Model.AchievementsModel;
import com.example.japaonamesa.ProfileScreen.EditProfile.EditProfileScreen;
import com.example.japaonamesa.ProfileScreen.Settings.SettingsScreen;
import com.example.japaonamesa.R;

import java.util.ArrayList;
import java.util.List;

public class ProfileScreen extends AppCompatActivity {

    LinearLayout homescreen, favouritescreen;

    ImageView settingsBtn;

    Button editProfile;

    private RecyclerView recyclerViewAchievementsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_screen);

        //Navbar
        homescreen = findViewById(R.id.HomeScreen);
        favouritescreen = findViewById(R.id.FavouriteScreen);

        homescreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }
        });

        favouritescreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FavouriteScreen.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }
        });

        //Settings
        settingsBtn = findViewById(R.id.SettingsBtn);

        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SettingsScreen.class);
                startActivity(intent);
                finish();
            }
        });

        //Edit profile
        editProfile = findViewById(R.id.EditProfileBtn);

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EditProfileScreen.class);
                startActivity(intent);
                finish();
            }
        });

        //Achievements

        recyclerViewAchievementsList = findViewById(R.id.AchievementsList);
        recyclerViewAchievementsList.setHasFixedSize(true);
        recyclerViewAchievementsList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<AchievementsModel> achievementsModels = new ArrayList<>() ;
        achievementsModels.add(new AchievementsModel(R.drawable.ramen, "Cook 2 recepies"));
        achievementsModels.add(new AchievementsModel(R.drawable.ramen, "Ramen"));
        achievementsModels.add(new AchievementsModel(R.drawable.ramen, "Udon"));
        achievementsModels.add(new AchievementsModel(R.drawable.ramen, "Soba"));
        achievementsModels.add(new AchievementsModel(R.drawable.ramen, "Udon3"));
        achievementsModels.add(new AchievementsModel(R.drawable.ramen, "Udon2"));
        achievementsModels.add(new AchievementsModel(R.drawable.ramen, "Cook 10 recepies"));
        achievementsModels.add(new AchievementsModel(R.drawable.ramen, "Cook 20 recepies"));
        achievementsModels.add(new AchievementsModel(R.drawable.ramen, "Cook 35 recepies"));

        AchievementsAdapter achievementsAdapter = new AchievementsAdapter(achievementsModels);

        recyclerViewAchievementsList.setAdapter(achievementsAdapter);

    }
}