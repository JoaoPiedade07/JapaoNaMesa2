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



    }
}