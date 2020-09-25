package com.example.lab2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "continueWatch";
    private static final int DB_VERSION = 4;

    DatabaseHelper (Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateDatabase(db, oldVersion, newVersion);
    }

    private void updateDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 4) {
            db.execSQL("CREATE TABLE TIME (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "TIMER INTEGER);");
            ContentValues contentValues = new ContentValues();
            contentValues.put("TIMER", 0);
            db.insert("TIME", null, contentValues);
        }
    }
}
