package com.example.japaonamesa.HomeScreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.japaonamesa.Adapter.Category.CategoryAdapter;

import com.example.japaonamesa.Adapter.Recomended.RecomendedAdapter;
import com.example.japaonamesa.CategoryScreen.CategoryScreen;
import com.example.japaonamesa.FavouriteScreen.FavDB.FavDB;
import com.example.japaonamesa.FavouriteScreen.FavouriteScreen;
import com.example.japaonamesa.Model.Category.CategoryModel;
import com.example.japaonamesa.Model.Recomended.RecomendedModel;
import com.example.japaonamesa.ProfileScreen.ProfileScreen;
import com.example.japaonamesa.R;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeScreen extends AppCompatActivity {

    LinearLayout homescreen, favouritescreen, profilescreen;

    TextView txtCategoryScreen;

    private RecyclerView recyclerViewCategoryList, recyclerViewRecomendList;
    private ArrayList<RecomendedModel> recomendedModels = new ArrayList<>();
    private RecomendedAdapter recomendedAdapter;
    private FavDB favDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        favDB = new FavDB(this);

        //NavBar
        homescreen = findViewById(R.id.homeScreen);
        favouritescreen = findViewById(R.id.favouriteScreen);
        profilescreen = findViewById(R.id.profileScreen);

        favouritescreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FavouriteScreen.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
            }
        });

        profilescreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProfileScreen.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });

        //Btn para ir para a lista de categorias
        txtCategoryScreen = findViewById(R.id.txtCategoryScreen);

        txtCategoryScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CategoryScreen.class);
                startActivity(intent);
                finish();
            }
        });


        //RecyclerView for CategoryList
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
    // Método para atualizar a lista de recomendados quando necessário
    public void updateRecomendedList() {
        if (recomendedAdapter != null) {
            recomendedAdapter.notifyDataSetChanged();  // Notifica o adaptador que a lista foi alterada
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateRecomendedList();  // Atualiza a lista quando a Activity for retomada
    }
}



