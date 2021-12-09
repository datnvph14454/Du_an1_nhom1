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



        btn_Lg_DangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = edt_Lg_user.getText().toString();
                String passWord = edt_Lg_pass.getText().toString();
                if (userName.isEmpty()) {
                    edt_Lg_user.setError("Bạn hãy nhập tài khoản");
                    edt_Lg_user.requestFocus();
                } else if (passWord.isEmpty()) {
                    edt_Lg_pass.setError("Bạn hãy nhập mật khẩu");
                    edt_Lg_pass.requestFocus();
                }
                if (userDAO.checkLogin(userName, passWord) == true) {
                    Toast.makeText(getApplicationContext(), "Đăng nhập thành công ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, NavigationDrawerActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Tài khoản hoặc mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_Lg_DangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }


}