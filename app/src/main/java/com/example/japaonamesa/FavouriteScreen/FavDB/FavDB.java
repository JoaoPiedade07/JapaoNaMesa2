package com.example.japaonamesa.FavouriteScreen.FavDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class FavDB extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "FavoriteDB";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_NAME = "favorites";

    public FavDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS favorites (" +
                "id INTEGER PRIMARY KEY, " +   // ID como chave primária
                "title TEXT, " +                // Nome do item
                "image TEXT)";                 // Caminho ou referência da imagem
        db.execSQL(CREATE_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Adicionar aos favoritos
    public void addFavorite(int id, String title, String image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // Insere os valores no banco de dados
        values.put("id", id);          // O ID do item (Primary Key)
        values.put("title", title);      // O nome do item
        values.put("image", image);    // O caminho ou referência da imagem

        try {
            db.insertOrThrow("favorites", null, values);
        } catch (SQLiteConstraintException e) {
            Log.e("FavDB", "Erro ao inserir favorito: " + e.getMessage());
        } finally {
            db.close();
        }
    }



    // Remover dos favoritos com SQLiteDatabase
    public void removeFavorite(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.delete("favorites", "id=?", new String[]{String.valueOf(id)});
        } catch (Exception e) {
            Log.e("FavDB", "Erro ao remover favorito: " + e.getMessage());
        } finally {
            db.close();
        }
    }

    public boolean isFavorite(int id) { // Alterado para int
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("favorites", new String[]{"id"}, "id=?", new String[]{String.valueOf(id)}, null, null, null);
        boolean isFavorite = cursor.getCount() > 0; // Verifica se existe algum resultado
        cursor.close(); // Fecha o cursor
        return isFavorite;
    }

    // Buscar todos os favoritos
    public Cursor getAllFavorites() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

}

