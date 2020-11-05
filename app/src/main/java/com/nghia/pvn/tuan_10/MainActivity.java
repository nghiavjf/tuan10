package com.nghia.pvn.tuan_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLite db= new SQLite(this, "QuanLy.sqlite",null,1);
        //tao bang
        db.QueryData("CREATE TABLE IF NOT EXISTS ChiTieu(Id INTEGER PRIMARY KEY AUTOINCREMENT, Ten VARCHAR, ChiPhi INTEGER, GhiChu VARCHAR)");
        //them du lieu
        //db.QueryData("INSERT INTO ChiTieu VALUES(null, 'Mua dien thoai','5000000','samsung')");

        Cursor cursorCT=db.GetData("SELECT * FROM ChiTieu");
        while (cursorCT.moveToNext()){
            Toast.makeText(this, cursorCT.getString(1), Toast.LENGTH_SHORT).show();
        }


        Button button1=findViewById(R.id.btnc);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open(v);
            }
        });
    }

    void open(View view){
        Intent myIntent=new Intent( this, Activity_2.class);
        startActivity(myIntent);
    }
}