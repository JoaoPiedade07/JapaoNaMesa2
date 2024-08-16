package com.example.japaonamesa.Recepies.Udon;

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

public class TempuraUdonScreen extends AppCompatActivity {

    ImageView backCategoryTempuraUdon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tempura_udon_screen);

        backCategoryTempuraUdon = findViewById(R.id.BackCategoryTempuraUdon);

        backCategoryTempuraUdon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(intent);
                finish();
            }
        });

    }
}