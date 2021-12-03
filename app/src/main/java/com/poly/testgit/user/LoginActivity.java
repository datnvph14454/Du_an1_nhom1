package com.poly.testgit.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.poly.testgit.NavigationDrawerActivity;
import com.poly.testgit.R;

public class LoginActivity extends AppCompatActivity {
    EditText edt_Lg_user, edt_Lg_pass;
    Button btn_Lg_DangKy, btn_Lg_DangNhap;
    CheckBox chk_save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        edt_Lg_pass = findViewById(R.id.edt_Lg_pass);
        edt_Lg_user = findViewById(R.id.edt_Lg_user);
        btn_Lg_DangKy = findViewById(R.id.btn_Lg_DangKy);
        btn_Lg_DangNhap = findViewById(R.id.btn_Lg_DangNhap);
        chk_save = findViewById(R.id.chk_save);


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
}