 package com.example.imagesqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import RecyclerPkg.DBAdapter;
import RecyclerPkg.DBModelClass;
import SQLitePkg.MyDBClass;

 public class MainActivity extends AppCompatActivity {
MyDBClass objMyDbClass;
ArrayList<DBModelClass> objDbModelclasArrayList;
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        objMyDbClass=new MyDBClass(this);
        objDbModelclasArrayList=new ArrayList<>();
        recyclerView=findViewById(R.id.RV_Id);
    }
    public void showData(View view)
    {
        try {
            objDbModelclasArrayList=objMyDbClass.getAllData();
            DBAdapter objDbAdapter=new DBAdapter(objDbModelclasArrayList);
         recyclerView.hasFixedSize();
         recyclerView.setLayoutManager(new LinearLayoutManager(this));
         recyclerView.setAdapter(objDbAdapter);
        }catch (Exception e)
        {
            Toast.makeText(this, "showData"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
