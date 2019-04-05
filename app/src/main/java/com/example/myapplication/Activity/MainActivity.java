package com.example.myapplication.Activity;

import android.annotation.SuppressLint;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.myapplication.Fragment.fragment_home;

import com.example.myapplication.Fragment.fragment_login;
import com.example.myapplication.Fragment.fragment_statistics;
import com.example.myapplication.Fragment.fragment_welcome;
import com.example.myapplication.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//将XML与Activity绑定
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        FragmentManager manager = getFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        System.out.println("hello");

        fragmentTransaction.add(R.id.content_layout,new fragment_welcome());//TODO
        fragmentTransaction.commit();
    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getFragmentManager().beginTransaction().replace(R.id.content_layout,new fragment_home()).commit();

                    return true;
                case R.id.navigation_statistics:
                    getFragmentManager().beginTransaction().replace(R.id.content_layout,new fragment_statistics()).commit();

                    return true;
                case R.id.navigation_personal:
                    getFragmentManager().beginTransaction().replace(R.id.content_layout,new fragment_login()).commit();

                    return true;
            }
            return false;
        }
    };

    //从另一个Activity返回到该Activity时，此方法自动调用
    @SuppressLint("SetTextI18n")



    @Override
    public void onClick(View v) {

    }


}
/*  哈哈哈哈哈哈哈哈哈，博客因为没备案关掉了，就先及在这里吧。断断续续弄了好几天，总算是把数据库弄好了。讲一下重点。
    首先，要有一个public class DatabaseOH extends SQLiteOpenHelper，单独作为一个java class文件，然后在这个文件里重写OnCreate和OnUpdata.//贴代码并注释
    然后，在MainActivity.java里
        DatabaseOH sqLiteOpenHelper = new DatabaseOH(this,DATABASE_NAME);//实例化刚才的类
        SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();//创建数据库，并从刚刚的类中取出可以读写的数据库
    再然后，Cursor Query=db.rawQuery("select * from Records",null);
    建立游标，将一个查询语句赋值给游标，然后
    while (Query.moveToNext()){
    Query.getString(Query.getColumnIndex("Recorder"))
    }
    这样遍历游标可以将数据库里对应的记录值全部取出。
    Query.getCount()这个可以取出行数
    Query.close();
    db.close();别忘了关闭。
 */