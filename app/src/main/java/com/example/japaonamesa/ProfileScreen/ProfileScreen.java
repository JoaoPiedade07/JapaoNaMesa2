package com.example.japaonamesa.ProfileScreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.japaonamesa.Adapter.Category.CategoryAdapter;
import com.example.japaonamesa.Adapter.History.HistoryAdapter;
import com.example.japaonamesa.FavouriteScreen.FavouriteScreen;
import com.example.japaonamesa.HomeScreen.HomeScreen;
import com.example.japaonamesa.Model.Category.CategoryModel;
import com.example.japaonamesa.Model.History.HistoryModel;
import com.example.japaonamesa.R;

import java.util.ArrayList;
import java.util.List;

public class ProfileScreen extends AppCompatActivity {

    LinearLayout homescreen, favouritescreen;
    private RecyclerView recyclerViewHistoryList;
    private ArrayList<HistoryModel> historyModels = new ArrayList<>();
    private HistoryAdapter historyAdapter;

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

        recyclerViewHistoryList = findViewById(R.id.RecomendList);
        recyclerViewHistoryList.setHasFixedSize(true);
        recyclerViewHistoryList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        historyModels.add(new HistoryModel(R.drawable.rollspng, "Spring Rolls", 16, 0));
        historyModels.add(new HistoryModel(R.drawable.misopng, "Miso Soup", 17, 0));
        historyModels.add(new HistoryModel(R.drawable.gyosapng, "Gyosas", 18, 0));
        historyModels.add(new HistoryModel(R.drawable.tunasahimipng, "Tuna Sashimi", 7, 0));
        historyModels.add(new HistoryModel(R.drawable.udonpng, "Udon", 19, 0));
        historyModels.add(new HistoryModel(R.drawable.nigiripng, "Salmon nigiri", 20, 0));

        historyAdapter = new HistoryAdapter(historyModels, this);  // Instanciar o adaptador
        recyclerViewHistoryList.setAdapter(historyAdapter);

    }
}