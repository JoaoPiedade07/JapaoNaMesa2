package com.example.japaonamesa.ProfileScreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.japaonamesa.Adapter.AchievementsAdapter;
import com.example.japaonamesa.Adapter.Category.CategoryAdapter;
import com.example.japaonamesa.Adapter.Recomended.RecomendedAdapter;
import com.example.japaonamesa.FavouriteScreen.FavouriteScreen;
import com.example.japaonamesa.HomeScreen.HomeScreen;
import com.example.japaonamesa.HomeScreen.NonScrollingGridLayoutManager;
import com.example.japaonamesa.Model.AchievementsModel;
import com.example.japaonamesa.Model.Category.CategoryModel;
import com.example.japaonamesa.Model.Recomended.RecomendedModel;
import com.example.japaonamesa.ProfileScreen.EditProfile.EditProfileScreen;
import com.example.japaonamesa.ProfileScreen.Settings.SettingsScreen;
import com.example.japaonamesa.R;

import java.util.ArrayList;
import java.util.List;

public class ProfileScreen extends AppCompatActivity {

    LinearLayout homescreen, favouritescreen;
    private RecyclerView recyclerViewCategoryList, recyclerViewRecomendList;
    private ArrayList<RecomendedModel> recomendedModels = new ArrayList<>();
    private RecomendedAdapter recomendedAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_screen);

        //Navbar
        homescreen = findViewById(R.id.HomeScreen);
        favouritescreen = findViewById(R.id.FavouriteScreen);

        homescreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }
        });

        favouritescreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FavouriteScreen.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }
        });

        recyclerViewCategoryList = findViewById(R.id.CategoryList);
        recyclerViewCategoryList.setHasFixedSize(true);
        recyclerViewCategoryList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<CategoryModel> categoryModels = new ArrayList<>() ;
        categoryModels.add(new CategoryModel(R.drawable.sushipng, "Sushi"));
        categoryModels.add(new CategoryModel(R.drawable.ramenpng, "Ramen"));
        categoryModels.add(new CategoryModel(R.drawable.rollspng, "Rolls"));
        categoryModels.add(new CategoryModel(R.drawable.gyosapng, "Gyosas"));
        categoryModels.add(new CategoryModel(R.drawable.udonpng, "Udon"));
        categoryModels.add(new CategoryModel(R.drawable.misopng, "Soups"));
        categoryModels.add(new CategoryModel(R.drawable.sobapng, "Soba"));

        CategoryAdapter categoryAdapter = new CategoryAdapter(categoryModels, this);

        recyclerViewCategoryList.setAdapter(categoryAdapter);

        recyclerViewRecomendList = findViewById(R.id.RecomendList);
        recyclerViewRecomendList.setHasFixedSize(true);
        recyclerViewRecomendList.setLayoutManager(new NonScrollingGridLayoutManager(this, 2));

        recomendedModels.add(new RecomendedModel(R.drawable.rollspng, "Spring Rolls", 16, 0));
        recomendedModels.add(new RecomendedModel(R.drawable.misopng, "Miso Soup", 17, 0));
        recomendedModels.add(new RecomendedModel(R.drawable.gyosapng, "Gyosas", 18, 0));
        recomendedModels.add(new RecomendedModel(R.drawable.tunasahimipng, "Tuna Sashimi", 7, 0));
        recomendedModels.add(new RecomendedModel(R.drawable.udonpng, "Udon", 19, 0));
        recomendedModels.add(new RecomendedModel(R.drawable.nigiripng, "Salmon nigiri", 20, 0));

        recomendedAdapter = new RecomendedAdapter(recomendedModels, this);  // Instanciar o adaptador
        recyclerViewRecomendList.setAdapter(recomendedAdapter);

    }
}