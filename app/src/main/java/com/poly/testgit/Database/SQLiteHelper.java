package com.poly.testgit.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.poly.testgit.DAO.UserDAO;

public class SQLiteHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = " dbEnglishVocabulary";
    public static final int VERSION = 1;

    public SQLiteHelper( Context context ) {
        super(context, DATABASE_NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserDAO.SQL_NGUOI_DUNG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists "+ UserDAO.TABLE_NAME);

        onCreate(db);
    }
}
