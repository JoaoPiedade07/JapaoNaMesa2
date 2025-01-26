package com.example.japaonamesa.Recepies.Rolls;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.japaonamesa.CategoryScreen.CategoryScreen;
import com.example.japaonamesa.HomeScreen.HomeScreen;
import com.example.japaonamesa.R;

public class SpringRollsScreen extends AppCompatActivity {

    ImageView backCategorySpringRolls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spring_rolls_screen);

        backCategorySpringRolls = findViewById(R.id.BackCategoryRolls);

        backCategorySpringRolls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(intent);
                finish();
            }
        });
    }
}