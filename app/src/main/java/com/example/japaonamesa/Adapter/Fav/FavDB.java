package com.example.japaonamesa.Adapter.Fav;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class FavDB extends SQLiteOpenHelper {
    private static int DB_VERSION = 1;
    private static String DATABASE_NAME = "FavDatabase";
    private static String TABLE_NAME = "favoriteTable";

    public static String KEY_ID = "id";
    public static String ITEM_TITLE = "itemName";
    public static String ITEM_IMAGE = "itemImage";
    public static String FAVORITE_STATUS = "fStatus";
    private static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + KEY_ID + " TEXT," + ITEM_TITLE + " TEXT,"
            + ITEM_IMAGE + " TEXT," + FAVORITE_STATUS + " TEXT)";

    public FavDB(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //create empty table
    public void insertEmpty() {
        SQLiteDatabase database = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        //enter your value
        for (int x = 1 ; x < 11 ; x++) {
            cv.put(KEY_ID, x);
            cv.put(FAVORITE_STATUS, "0");

            database.insert(TABLE_NAME, null, cv);
        }
    }

    //insert data into database
    public void insertIntoTheDatabase(String item_name, int item_image, String id, String fav_status) {
        SQLiteDatabase database;
        database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ITEM_TITLE, item_name);
        cv.put(ITEM_IMAGE, item_image);
        cv.put(KEY_ID, id);
        cv.put(FAVORITE_STATUS, fav_status);
        database.insert(TABLE_NAME, null, cv);
        Log.d("FavDB Status", item_name + ", favstatus - " + fav_status + " - . " + cv);
    }

    //read all data
    public Cursor read_all_data(String id) {
        SQLiteDatabase database = this.getReadableDatabase();
        String sql = "select * from " + TABLE_NAME + " where " + KEY_ID + "=" + id + "";
        return database.rawQuery(sql, null, null);
    }

    //remove line from database
    public void remove_fav(String id) {
        SQLiteDatabase database = this.getWritableDatabase();
        String sql = "UPDATE " + TABLE_NAME + " SET " + FAVORITE_STATUS + " ='0' WHERE " + KEY_ID + "=" + id + "";
        database.execSQL(sql);
        Log.d("remove", id.toString());
    }

    //select all favorite list
    public Cursor select_all_favorite_list() {
        SQLiteDatabase database = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + FAVORITE_STATUS + " ='1'";
        return database.rawQuery(sql, null, null);
    }
}
