package com.poly.testgit.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.poly.testgit.R;

public class RegisterActivity extends AppCompatActivity {
    EditText edt_Re_user,edt_Re_pass,edt_Re_repass;
    Button btn_Re_DangKy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edt_Re_pass = findViewById(R.id.edt_Re_pass);
        edt_Re_repass = findViewById(R.id.edt_Re_repass);
        edt_Re_user = findViewById(R.id.edt_Re_user);
        btn_Re_DangKy = findViewById(R.id.btn_Re_DangKy);


        btn_Re_DangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RegisterActivity.this, "Đăng ký thành công",Toast.LENGTH_LONG).show();
                new Handler().postDelayed(() -> {

                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    finish();
                },1500);
            }
        });




    }
}