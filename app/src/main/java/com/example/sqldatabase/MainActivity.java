package com.example.sqldatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataBaseHelper database=new DataBaseHelper(this,"studentDatabase.db",null,1);
        SQLiteDatabase db=database.getWritableDatabase();
        ContentValues cv1=new ContentValues();
        cv1.put("rollno", 100);
        cv1.put("name", "Ranjith");
        cv1.put("age", 10);
        ContentValues cv2=new ContentValues();
        cv2.put("rollno", 200);
        cv2.put("name", "Sanjith");
        cv2.put("age", 40);
        ContentValues cv3=new ContentValues();
        cv3.put("rollno", 500);
        cv3.put("name", "Panjith");
        cv3.put("age", 50);
        db.insert("STUDENT",null,cv1);
        db.insert("STUDENT",null,cv2);
        db.insert("STUDENT",null,cv3);

        SQLiteDatabase db1=database.getReadableDatabase();
        String [] projection={"name","age"};
        Cursor cr=db1.query("STUDENT",projection,null,null,null,null,null);
        while(cr.moveToNext())
        {
            String name = cr.getString(cr.getColumnIndex("name"));
            String age = cr.getString(cr.getColumnIndex("age"));
            Toast.makeText(this, "Nmae of the Student is "+name +"And age of the  Student is "+age, Toast.LENGTH_SHORT).show();
        }

    }
}
