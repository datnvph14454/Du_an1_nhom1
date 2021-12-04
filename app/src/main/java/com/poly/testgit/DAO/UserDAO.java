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
            "password text, repassword text, phone text, hoten text)";
    public static final String TAG = "UserDAO";
    public UserDAO (Context context){
        dbHelper = new SQLiteHelper(context);
        db = dbHelper.getWritableDatabase();


    }
    //insert
    public int inserNguoiDung(user nd){
        ContentValues values = new ContentValues();
        values.put("username",nd.getUsername());
        values.put("password",nd.getPassword());
        values.put("repassword",nd.getRepasswprd());
        values.put("phone",nd.getPhone());
        values.put("hoten",nd.getHoten());
        try {
            if(db.insert(TABLE_NAME,null,values)== -1){
                return -1;
            }
        }catch (Exception ex){
            Log.e(TAG,ex.toString());
        }
        return 1;
    }
    //getAll
    public List<user> getAllNguoiDung(){
        List<user> dsNguoiDung = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME,null,null,null,null,null,null);
        c.moveToFirst();
        while (c.isAfterLast()==false){
            user ee = new user();
            ee.setUsername(c.getString(0));
            ee.setPassword(c.getString(1));
            ee.setPhone(c.getString(2));
            ee.setHoten(c.getString(3));
            dsNguoiDung.add(ee);
            Log.d("//=====",ee.toString());
            c.moveToNext();
        }
        c.close();
        return dsNguoiDung;

    }
    //update
    public int updateNguoiDung(user nd){
        ContentValues values = new ContentValues();
        values.put("username",nd.getUsername());
        values.put("password",nd.getPassword());
        values.put("repassword",nd.getRepasswprd());
        values.put("phone",nd.getPhone());
        values.put("hoten",nd.getHoten());
        int result = db.update(TABLE_NAME,values,"username=?", new String[]{nd.getUsername()});
        if (result == 0){
            return -1;
        }
        return 1;
    }
    public int changePasswordNguoiDung(user nd){
        ContentValues values = new ContentValues();
        values.put("username",nd.getUsername());
        values.put("password",nd.getPassword());

        int result = db.update(TABLE_NAME,values,"username=?", new String[]{nd.getUsername()});
        if (result == 0){
            return -1;
        }
        return 1;
    }
    public int updateInfoNguoiDung(String username,String phone, String name){
        ContentValues values = new ContentValues();
        values.put("phone",phone);
        values.put("hoten",name);
        int result = db.update(TABLE_NAME,values,"username=?", new String[]{username});
        if (result == 0){
            return -1;
        }
        return 1;
    }
    //check login
    public int checkLogin(String username, String password){
        int result = db.delete(TABLE_NAME,"username=? AND password=?",new String[]{username,password});
        if (result == 0)
            return -1;
        return 1;
    }


}
