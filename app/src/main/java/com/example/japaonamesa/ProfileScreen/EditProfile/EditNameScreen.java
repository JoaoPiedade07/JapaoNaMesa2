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

import com.example.japaonamesa.ProfileScreen.ProfileScreen;
import com.example.japaonamesa.R;

public class EditNameScreen extends AppCompatActivity {

    ImageView backeditProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_name_screen);

        backeditProfile = findViewById(R.id.backeditProfile);

        backeditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EditProfileScreen.class);
                startActivity(intent);
                finish();
            }
        });

    }
}