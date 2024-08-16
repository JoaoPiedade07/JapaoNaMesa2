package com.example.japaonamesa.FavouriteScreen;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.japaonamesa.Adapter.Fav.FavDB;
import com.example.japaonamesa.Adapter.Fav.FavouriteAdapter;
import com.example.japaonamesa.FavouriteScreen.FavDB.FavItem;
import com.example.japaonamesa.HomeScreen.HomeScreen;
import com.example.japaonamesa.Model.Fav.FavouriteModel;
import com.example.japaonamesa.ProfileScreen.ProfileScreen;
import com.example.japaonamesa.R;

import java.util.ArrayList;
import java.util.List;

public class FavouriteScreen extends AppCompatActivity {

    LinearLayout homescreen, profilescreen;

    private List<FavItem> favItemList = new ArrayList<>();
    private RecyclerView recyclerViewFavList;
    private FavDB favDB;
    private FavouriteAdapter favAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favourite_screen);

        homescreen = findViewById(R.id.Homescreen);
        profilescreen = findViewById(R.id.Profilescreen);

        // Initialize favDB
        favDB = new FavDB(this); // Initialize the database object


        homescreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
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

        recyclerViewFavList = findViewById(R.id.FavouriteList);
        recyclerViewFavList.setHasFixedSize(true);
        recyclerViewFavList.setLayoutManager(new GridLayoutManager(this,2));

        loadData();

    }

    private void loadData() {
        if (favItemList != null) {
            favItemList.clear();
        }
        SQLiteDatabase database = favDB.getReadableDatabase();
        Cursor cursor = favDB.select_all_favorite_list();
        try {
                while (cursor.moveToNext()) {
                    String title = cursor.getString(cursor.getColumnIndex(FavDB.ITEM_TITLE));
                    String id = cursor.getString(cursor.getColumnIndex(FavDB.KEY_ID));
                    int image = Integer.parseInt(cursor.getString(cursor.getColumnIndex(FavDB.ITEM_IMAGE)));
                    FavItem favItem = new FavItem(title, id, image);
                    favItemList.add(favItem);
                }
        } finally {
            if (cursor != null && cursor.isClosed())
                cursor.close();
            database.close();
        }

        favAdapter = new FavouriteAdapter((ArrayList<FavItem>) favItemList, this);
        recyclerViewFavList.setAdapter(favAdapter);
    }
}