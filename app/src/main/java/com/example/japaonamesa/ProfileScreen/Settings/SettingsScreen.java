package com.example.japaonamesa.ProfileScreen.Settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.japaonamesa.ProfileScreen.ProfileScreen;
import com.example.japaonamesa.R;
import com.example.japaonamesa.SignAndLogIn.LogInScreen;
import com.example.japaonamesa.SignAndLogIn.SignInScreen;
import com.example.japaonamesa.WelcomeScreen;
import com.google.firebase.auth.FirebaseAuth;

public class SettingsScreen extends AppCompatActivity {

    ImageView backProfileBtn;

    TextView logOutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_screen);

        //Back to profile
        backProfileBtn = findViewById(R.id.backProfileBtn);

        backProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProfileScreen.class);
                startActivity(intent);
                finish();
            }
        });

        //Log Out Btn
        logOutBtn = findViewById(R.id.txtLogOut);

        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), WelcomeScreen.class));
                finish();
            }
        });

    }
}