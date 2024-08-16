package com.example.japaonamesa.CategoryScreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.japaonamesa.Adapter.Category.CategoryScreenAdapter;
import com.example.japaonamesa.HomeScreen.HomeScreen;
import com.example.japaonamesa.Model.Category.CategoryScreenModel;
import com.example.japaonamesa.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryScreen extends AppCompatActivity {

    RecyclerView recyclerViewCatList;
    ImageView backToHomeScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_screen);

        recyclerViewCatList = findViewById(R.id.CategoryScreenList);
        recyclerViewCatList.setHasFixedSize(true);
        recyclerViewCatList.setLayoutManager(new GridLayoutManager(this,2));

        List<CategoryScreenModel> categoryScreenModels = new ArrayList<>() ;
        categoryScreenModels.add(new CategoryScreenModel(R.drawable.sushipng,"Sushi"));
        categoryScreenModels.add(new CategoryScreenModel(R.drawable.ramenpng,"Ramen"));
        categoryScreenModels.add(new CategoryScreenModel(R.drawable.rollspng,"Rolls"));
        categoryScreenModels.add(new CategoryScreenModel(R.drawable.gyosapng,"Gyosas"));
        categoryScreenModels.add(new CategoryScreenModel(R.drawable.udonpng,"Udon"));
        categoryScreenModels.add(new CategoryScreenModel(R.drawable.misopng,"Soups"));
        categoryScreenModels.add(new CategoryScreenModel(R.drawable.sobapng,"Soba"));

        CategoryScreenAdapter categoryScreenAdapter = new CategoryScreenAdapter(categoryScreenModels, this);

        recyclerViewCatList.setAdapter(categoryScreenAdapter);

        backToHomeScreen = findViewById(R.id.backToHome);

        backToHomeScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(intent);
                finish();
            }
        });

    }
}