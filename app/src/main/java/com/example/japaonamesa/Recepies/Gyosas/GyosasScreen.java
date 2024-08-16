package com.example.japaonamesa.Recepies.Gyosas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.japaonamesa.HomeScreen.HomeScreen;
import com.example.japaonamesa.R;

public class GyosasScreen extends AppCompatActivity {

    ImageView backCategoryGyosas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gyosas_screen);

        backCategoryGyosas = findViewById(R.id.BackCategoryGyosas);

        backCategoryGyosas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(intent);
                finish();
            }
        });
    }
}