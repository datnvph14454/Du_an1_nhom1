package com.poly.testgit.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.poly.testgit.DAO.UserDAO;
import com.poly.testgit.R;

public class RegisterActivity extends AppCompatActivity {
    EditText edt_Re_user,edt_Re_pass,edt_Re_repass;
    Button btn_Re_DangKy;
    UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userDAO = new UserDAO(RegisterActivity.this);
        edt_Re_user =findViewById(R.id.edt_Re_user);
        edt_Re_pass =findViewById(R.id.edt_Re_pass);
        edt_Re_repass =findViewById(R.id.edt_Re_repass);

        btn_Re_DangKy =findViewById(R.id.btn_Re_DangKy);
        btn_Re_DangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String us = edt_Re_user.getText().toString();
                String pass = edt_Re_pass.getText().toString();
                String repass = edt_Re_repass.getText().toString();
                if(us.isEmpty() && pass.isEmpty() && repass.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Phải điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean checkus = userDAO.checkUsername(us);
                    if(checkus == true){
                        Boolean insert = userDAO.insert(us, pass,repass);
                        if(insert == true) {
                            Toast.makeText(getApplicationContext(), "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Tài đã được sử dụng", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



    }
}