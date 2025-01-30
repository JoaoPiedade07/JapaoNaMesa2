package com.example.japaonamesa.HomeScreen.Settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.japaonamesa.HomeScreen.HomeScreen;
import com.example.japaonamesa.HomeScreen.Settings.EditProfile.EditProfileScreen;
import com.example.japaonamesa.ProfileScreen.ProfileScreen;
import com.example.japaonamesa.R;
import com.example.japaonamesa.WelcomeScreen;
import com.google.firebase.auth.FirebaseAuth;

public class SettingsScreen extends AppCompatActivity {

    ImageView backProfileBtn;

    LinearLayout logOutBtn, accountBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_screen);

        //Back to profile
        backProfileBtn = findViewById(R.id.backProfileBtn);

        backProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(intent);
                finish();
            }
        });

        //Log Out Btn
        logOutBtn = findViewById(R.id.LayoutLogOut);
        accountBtn = findViewById(R.id.LayoutAccount);

        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), WelcomeScreen.class));
                finish();
            }
        });

        accountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), EditProfileScreen.class));
                finish();
            }
        });

    }
}