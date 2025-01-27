package com.example.japaonamesa.Recepies.Sushi.Nigiri;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.japaonamesa.HomeScreen.HomeScreen;
import com.example.japaonamesa.R;

public class NigirisScreen extends AppCompatActivity {

    ImageView backCategoryNigirs;

    Button btnListNigiris;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nigiris_screen);

        backCategoryNigirs = findViewById(R.id.BackCategoryNigirs);
        btnListNigiris = findViewById(R.id.btnListNigiris);

        btnListNigiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), NigiriListItems.class);
                startActivity(intent);
                finish();
            }
        });

        backCategoryNigirs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(intent);
                finish();
            }
        });
    }
}