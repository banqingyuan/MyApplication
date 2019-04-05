package com.example.myapplication.Activity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import com.example.myapplication.Database.DatabaseOH;
import com.example.myapplication.R;


public class AddActivity extends BaseActivity implements View.OnClickListener {

    public static final String DATABASE_NAME = "Records.db";
    Button Submit;
    EditText Reason;
    EditText Value;
    Spinner Tag;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Reason = findViewById(R.id.add_reason);
        Value = findViewById(R.id.add_value);



        //根据控件ID得到控件
        Submit = this.findViewById(R.id.submit);
        //添加监听器

        Submit.setOnClickListener(this);

        //实例化数据库
        Log.i("info","Add页面实例化数据库");
        DatabaseOH sqLiteOpenHelper = new DatabaseOH(this,DATABASE_NAME);
        SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("info","Activity已销毁");
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.submit:
                Log.i("info","111111111111111111111111111111111111111111");
                //实例化数据库
                DatabaseOH sqLiteOpenHelper = new DatabaseOH(this,DATABASE_NAME);
                SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
                //实例化数据并插入

                String reason = Reason.getText().toString();
                String value = Value.getText().toString();


                ContentValues record = new ContentValues();
                record.put("Recorder","明明");
                record.put("Reason",reason);
                record.put("Value",value);
                db.insert("Records",null,record);
                record.clear();
                db.close();

                finish();
                break;

        }
    }

}
