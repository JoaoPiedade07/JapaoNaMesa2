package com.example.japaonamesa.Recepies.Sushi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.japaonamesa.CategoryScreen.CategoryScreen;
import com.example.japaonamesa.HomeScreen.HomeScreen;
import com.example.japaonamesa.R;

public class SashimiScreen extends AppCompatActivity {

    ImageView backCategorySashimi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sashimi_screen);

        backCategorySashimi = findViewById(R.id.BackCategorySashimi);

        backCategorySashimi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(intent);
                finish();
            }
        });

    }
}