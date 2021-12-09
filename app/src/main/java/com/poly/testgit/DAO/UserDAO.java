package com.poly.testgit.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.poly.testgit.user.user;
import com.poly.testgit.Database.SQLiteHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDAO {
    private SQLiteHelper dbHelper;
    private SQLiteDatabase db;


    public static final String TABLE_NAME = "NguoiDung";
    public static final String SQL_NGUOI_DUNG = "CREATE TABLE NguoiDung (username text primary key, " +
            "password text, repassword text)";
    public static final String TAG = "UserDAO";



    public UserDAO(Context context) {
        dbHelper = new SQLiteHelper(context);
    }

    public boolean insert(String username, String password, String repassword) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("repassword", repassword);

        long ins = db.insert(TABLE_NAME, null, contentValues);
        if (ins == -1) return false;
        else return true;
    }
    public Boolean checkLogin(String usernameLg, String passwordLg) {
        boolean check = false;
        String countQuery = " SELECT * FROM NguoiDung WHERE username = ? AND password = ? ";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, new String[]{usernameLg, passwordLg});
        if (cursor.getCount() > 0) {
            check = true;
        }
        return check;
    }

    public Boolean checkUsername(String username) {
        boolean check = true;
        String countQuery = " SELECT * FROM NguoiDung WHERE username = ? ";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, new String[]{username});
        if (cursor.getCount() > 0) {
            check = false;
        }
        return check;
    }



}
