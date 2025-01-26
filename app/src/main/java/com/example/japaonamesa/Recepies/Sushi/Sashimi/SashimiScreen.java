package com.example.japaonamesa.Recepies.Sushi.Sashimi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

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