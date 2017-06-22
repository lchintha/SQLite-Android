package com.example.chint.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by chint on 6/15/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static String DBNAME = "profile.db";

    public DBHelper(Context context) {
        super(context, DBNAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USERS (ID INTEGER PRIMARY KEY AUTOINCREMENT, PHONE NUMBER, PASSWORD TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USERS");
        onCreate(db);
    }
    public void insertFunction(String a, String b){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO USERS (PHONE, PASSWORD) VALUES ('"+a+"', '"+b+"')");
    }
    public String importFunction(String a){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT PHONE, PASSWORD FROM USERS";
        Cursor cursor = db.rawQuery(query, null);
        String b, c;
        c="Not Found";
        if(cursor.moveToFirst()){
            do{
                b = cursor.getString(0);
                if(b.equals(a)){
                    c = cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext());
        }
        return c;
    }
}
