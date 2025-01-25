package com.example.japaonamesa.FavouriteScreen;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.japaonamesa.Adapter.Fav.FavouriteAdapter;
import com.example.japaonamesa.FavouriteScreen.FavDB.FavDB;
import com.example.japaonamesa.FavouriteScreen.FavDB.FavItem;
import com.example.japaonamesa.HomeScreen.HomeScreen;
import com.example.japaonamesa.ProfileScreen.ProfileScreen;
import com.example.japaonamesa.R;

import java.util.ArrayList;
import java.util.List;

public class FavouriteScreen extends AppCompatActivity {

    private LinearLayout homescreen, profilescreen;
    private RecyclerView recyclerViewFavList;
    private List<FavItem> favItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favourite_screen);

        // Inicializar botões de navegação
        homescreen = findViewById(R.id.Homescreen);
        profilescreen = findViewById(R.id.Profilescreen);

        // Navegação para a HomeScreen
        homescreen.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            finish();
        });

        // Navegação para a ProfileScreen
        profilescreen.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ProfileScreen.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            finish();
        });

        // Configurar RecyclerView
        recyclerViewFavList = findViewById(R.id.FavouriteList);
        recyclerViewFavList.setHasFixedSize(true);
        recyclerViewFavList.setLayoutManager(new GridLayoutManager(this, 2));

        // Carregar favoritos do banco de dados
        loadFavorites();
    }

    /**
     * Método para carregar a lista de favoritos do banco de dados e configurar o adaptador
     */
    private void loadFavorites() {
        // Instanciar o banco de dados
        FavDB favDB = new FavDB(this);

        // Obter os dados salvos no banco de dados
        Cursor cursor = favDB.getAllFavorites();

        // Verificar se há dados e processar o cursor
        if (cursor != null && cursor.moveToFirst()) {
            favItemList.clear(); // Limpar a lista antes de adicionar novos itens
            do {
                try {
                    // Obter dados de cada coluna
                    int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                    String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                    int image = cursor.getInt(cursor.getColumnIndexOrThrow("image"));

                    // Adicionar o item à lista
                    favItemList.add(new FavItem(id, title, image));
                } catch (Exception e) {
                    e.printStackTrace(); // Log de erro para diagnóstico
                }
            } while (cursor.moveToNext());
            cursor.close();
        }

        // Configurar o RecyclerView com o adaptador
        FavouriteAdapter adapter = new FavouriteAdapter(this, favItemList);
        recyclerViewFavList.setAdapter(adapter);
    }
}
