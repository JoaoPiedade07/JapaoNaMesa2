package com.example.japaonamesa.CategoryScreen.Ramen;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.japaonamesa.Adapter.Category.Ramen.RamenAdapter;
import com.example.japaonamesa.CategoryScreen.CategoryScreen;
import com.example.japaonamesa.Model.Category.Ramen.RamenModel;

import com.example.japaonamesa.R;

import java.util.ArrayList;

public class RamenCategoryScreen extends AppCompatActivity {

    ImageView backToCategoryRamen;
    private ArrayList<RamenModel> ramenModels = new ArrayList<>();
    private RecyclerView CategoryRamenScreenList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ramen_category_screen);

        backToCategoryRamen = findViewById(R.id.backToCategoryRamen);

        backToCategoryRamen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CategoryScreen.class);
                startActivity(intent);
                finish();
            }
        });

        CategoryRamenScreenList = findViewById(R.id.CategoryRamenScreenList);
        CategoryRamenScreenList.setHasFixedSize(true);
        CategoryRamenScreenList.setLayoutManager(new GridLayoutManager(this, 2));


        ramenModels.add(new RamenModel(R.drawable.ramenpng, "Ramen", "8", "0"));
        ramenModels.add(new RamenModel(R.drawable.ramenpng, "Ramen", "9", "0"));
        ramenModels.add(new RamenModel(R.drawable.ramenpng, "Ramen", "10", "0"));
        ramenModels.add(new RamenModel(R.drawable.ramenpng, "Ramen", "11", "0"));
        ramenModels.add(new RamenModel(R.drawable.ramenpng, "Ramen", "12", "0"));
        ramenModels.add(new RamenModel(R.drawable.ramenpng, "Ramen", "13", "0"));
        ramenModels.add(new RamenModel(R.drawable.ramenpng, "Ramen", "14", "0"));
        ramenModels.add(new RamenModel(R.drawable.ramenpng, "Ramen", "15", "0"));

        RamenAdapter ramenAdapter = new RamenAdapter(ramenModels, this);

        CategoryRamenScreenList.setAdapter(ramenAdapter);

    }
}