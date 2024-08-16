package com.example.japaonamesa.ProfileScreen.EditProfile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.japaonamesa.R;

public class EditUsernameScreen extends AppCompatActivity {

    ImageView BackeditProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_username_screen);

        BackeditProfile = findViewById(R.id.BackeditProfile);

        BackeditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EditProfileScreen.class);
                startActivity(intent);
                finish();
            }
        });

    }
}