package com.example.japaonamesa.Recepies;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.japaonamesa.CategoryScreen.CategoryScreen;
import com.example.japaonamesa.R;

public class TemplateRecepies extends AppCompatActivity {

    ImageView backScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.template_recepies);

        backScreen = findViewById(R.id.backToCategory);

        backScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), CategoryScreen.class);
                startActivity(intent);
                finish();
            }
        });
    }
}