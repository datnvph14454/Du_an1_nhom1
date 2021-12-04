package com.poly.testgit.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.poly.testgit.DAO.UserDAO;
import com.poly.testgit.NavigationDrawerActivity;
import com.poly.testgit.R;

public class LoginActivity extends AppCompatActivity {
    EditText edt_Lg_user, edt_Lg_pass;
    Button btn_Lg_DangKy, btn_Lg_DangNhap;
    CheckBox chk_save;
    UserDAO userDAO;
    RegisterActivity userRegster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        edt_Lg_pass = findViewById(R.id.edt_Lg_pass);
        edt_Lg_user = findViewById(R.id.edt_Lg_user);
        btn_Lg_DangKy = findViewById(R.id.btn_Lg_DangKy);
        btn_Lg_DangNhap = findViewById(R.id.btn_Lg_DangNhap);
        chk_save = findViewById(R.id.chk_save);
        userDAO = new UserDAO(LoginActivity.this);



        btn_Lg_DangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));

            }
        });




        btn_Lg_DangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Đăng nhập thành công",Toast.LENGTH_LONG).show();
                new Handler().postDelayed(() -> {

                    startActivity(new Intent(LoginActivity.this, NavigationDrawerActivity.class));
                    finish();
                },1500);
            }
        });

    }
    public void checkLogin(View v){
        userRegster = new RegisterActivity();
        String strUser = userRegster.edt_Re_user.getText().toString();
        String strPass = userRegster.edt_Re_pass.getText().toString();

        strUser = edt_Lg_user.getText().toString();
        strPass = edt_Lg_pass.getText().toString();

        if(strUser.isEmpty() || strPass.isEmpty()){

            Toast.makeText(getApplicationContext(), "Tên đăng nhập hoặc mật khẩu không chính xác", Toast.LENGTH_LONG).show();

        }else{
            if(userDAO.checkLogin(strUser, strPass) > 0){
                Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                finish();
            }
            if(strUser.equalsIgnoreCase(edt_Lg_user.toString()) && strPass.equalsIgnoreCase(edt_Lg_pass.toString())){
                rememberUser(strUser,strPass,chk_save.isChecked());
                    finish();

            }else{
                Toast.makeText(getApplicationContext(), "Tên đăng nhâp hoặc mật khẩu không đúng", Toast.LENGTH_LONG).show();
            }



        }


    }
    public void rememberUser(String u, String p, boolean status){
        SharedPreferences pref = getSharedPreferences("USER_FILE",MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        if(!status){
            edit.clear();

        }else{
            edit.putString("USERNAME", u);
            edit.putString("PASSWORD", p);
            edit.putBoolean("REMEMBER", status);
        }
        edit.commit();
    }
}