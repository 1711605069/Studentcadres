package com.example.anywayany.studentcadres;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    Button btnSystem, btnStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnSystem = findViewById(R.id.tv_main_system);
        btnStudent = findViewById(R.id.tv_main_student);

        btnSystem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//处理单元
                //业务代码

                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse("http://image.so.com/i?src=360pic_normal&z=1&i=0&cmg=" +
                        "0fd098da971d4d3cebb1c23d689e8972&q=%E4%BC%98%E7%A7%80%E5%AD%A6%E7%94%9F%E5%B9%B2%E9%83%A8"));
                startActivity(intent);
            }
        });


    }
}