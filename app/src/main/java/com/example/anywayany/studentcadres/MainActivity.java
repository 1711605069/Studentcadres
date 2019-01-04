package com.example.anywayany.studentcadres;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    MyHelper myHelper = new MyHelper(this);
    private EditText editTextname, editTextphone, editTextposition,editTextdepartment,editTexttelephone;
    private TextView tv_main_display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }
    private  void init () {
        editTextname=findViewById(R.id.tv_main_name);
        editTextphone=findViewById(R.id.tv_main_phone);
        editTextposition=findViewById(R.id.tv_main_position);
        editTextdepartment=findViewById(R.id.tv_main_department);
        editTexttelephone=findViewById(R.id.tv_main_telephone);
        tv_main_display = (TextView)findViewById(R.id.tv_main_display);
        Button btn_main_insert = (Button) findViewById(R.id.btn_main_insert);
        Button btn_main_query = (Button)findViewById(R.id.btn_main_query);
        Button btn_main_alter = (Button)findViewById(R.id.btn_main_alter);
        Button btn_main_delete = (Button)findViewById(R.id.btn_main_delete);
        btn_main_insert.setOnClickListener(this);
        btn_main_query.setOnClickListener(this);
        btn_main_alter.setOnClickListener(this);
        btn_main_delete.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        String name;
        String phone;
        String position;
        String department;
        String telephone;
        SQLiteDatabase db;
        ContentValues values;
        switch (v.getId()){
            case R.id.btn_main_insert://添加
                name = editTextname.getText().toString();
                phone =editTextphone.getText().toString();
                position=editTextposition.getText().toString();
                department=editTextdepartment.getText().toString();
                telephone =editTexttelephone.getText().toString();
                db=myHelper.getWritableDatabase();
                values=new ContentValues();
                values.put("name",name);
                values.put("phone",phone);
                values.put("position",position);
                values.put("department",department);
                values.put("telephone",telephone);
                db.insert("information",null,values);
                Toast.makeText(this,"信息已添加",Toast.LENGTH_SHORT).show();
                db.close();
                break;

            case R.id.btn_main_query:                                                              //查询
                db=myHelper.getReadableDatabase();
                Cursor cursor;
                cursor = db.query("information",null,null,null,null,null,null);
                if (cursor.getCount()==0) {
                    tv_main_display.setText("");
                    Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
                }else{
                    cursor.moveToFirst();
                    tv_main_display.setText("姓名："+cursor.getString(1)+"  "+
                            "学号："+cursor.getString(2)+"  "+
                            "职位："+cursor.getString(3)+"  "+
                            "所属部门:"+cursor.getString(4)+" "+
                            "联系电话"+cursor.getString(5));
                }
                while (cursor.moveToNext()) {
                    tv_main_display.append("\n"+"姓名：" + cursor.getString(1) +"  "+
                            "学号：" + cursor.getString(2) +"  "+
                            "职位：" + cursor.getString(3)+"  "+
                            "所属部门:"+cursor.getString(4)+" "+
                            "联系电话"+cursor.getString(5));
                }
                cursor.close();
                db.close();
                break;
            case R.id.btn_main_alter:                                                              //修改
                db=myHelper.getWritableDatabase();
                values=new ContentValues();
                values.put("name",name =editTextname.getText().toString());
                db.update("information",values,"name=?",
                        new String[]{editTextname.getText().toString()});
                values.put("phone",phone =editTextphone.getText().toString());
                db.update("information",values,"phone=?",
                        new String[]{editTextphone.getText().toString()});
                values.put("position",position =editTextposition.getText().toString());
                db.update("information",values,"position=?",
                        new String[]{editTextposition.getText().toString()});
                values.put("department",department =editTextdepartment.getText().toString());
                db.update("information",values,"department=?",
                        new String[]{editTextdepartment.getText().toString()});
                values.put("telephone",telephone =editTexttelephone.getText().toString());
                db.update("information",values,"telephone=?",
                        new String[]{editTexttelephone.getText().toString()});
                Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
                db.close();
                break;

            case R.id.btn_main_delete:                                                             //删除
                db=myHelper.getWritableDatabase();
                db.delete("information",null,null);
                Toast.makeText(this,"删除成功",Toast.LENGTH_SHORT).show();
                tv_main_display.setText("");
                db.close();
                break;

        }
    }

}