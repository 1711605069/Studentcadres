package com.example.anywayany.studentcadres;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //声明控件变量
        TextView tvTitle,tvAccount,tvPassword;
        final EditText editTextAccount,editTextPassword;
        Button btnLogin,btnReset;
        RadioGroup radGruSex;
        RadioButton radBtnMale,radBtnFemale;
        //映射界面上对应的控件findViewByID()
        tvTitle = findViewById(R.id.tv_main_title);
        tvAccount = findViewById(R.id.tv_main_account);
        tvPassword = findViewById(R.id.tv_main_password);

        editTextAccount = findViewById(R.id.editText_main_account);
        editTextPassword = findViewById(R.id.editText_main_password);

        btnLogin = findViewById(R.id.btn_main_login);
        btnReset = findViewById(R.id.btn_main_reset);


        radGruSex = findViewById(R.id.radGru_main_sex);
        radBtnMale = findViewById(R.id.radBtn_main_male);
        radBtnFemale = findViewById(R.id.radBtn_main_female);


        radGruSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radBtn_main_male:
                        Toast.makeText( LoginActivity.this,"选择性别：男",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radBtn_main_female:
                        Toast.makeText( LoginActivity.this,"选择性别：女",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextAccount.setText(null);
                editTextPassword.setText(null);
            }
        });




        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//处理单元
                //业务代码
                String account = editTextAccount.getText().toString();
                String password = editTextPassword.getText().toString();

                Intent intent=new Intent( LoginActivity.this,SecondActivity.class);
                startActivity(intent);

            }
        });

    }



}
