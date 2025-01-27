package com.example.japaonamesa.Recepies.Sushi.Sashimi.TunaSashimi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

import com.example.japaonamesa.CategoryScreen.Sushi.SushiCategoryScreen;
import com.example.japaonamesa.HomeScreen.HomeScreen;
import com.example.japaonamesa.R;
import com.example.japaonamesa.Recepies.Sushi.Nigiri.NigiriListItems;

public class TunaSashimiScreen extends AppCompatActivity {

    ImageView backCategorySashimi;
    Button btnListTSashimi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tuna_sashimi_screen);

        backCategorySashimi = findViewById(R.id.BackCategorySashimi);
        btnListTSashimi = findViewById(R.id.btnListTSashimi);

        backCategorySashimi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), SushiCategoryScreen.class);
                startActivity(intent);
                finish();
            }
        });

        btnListTSashimi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), TunaSashimiListItems.class);
                startActivity(intent);
                finish();
            }
        });
    }
}