package com.example.myapplication.Database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


    public class DatabaseOH extends SQLiteOpenHelper {


        public static final String TABLE_NAME = "Records";
        private static final int DATABASE_VERSION = 1;
        private static final String SWORD = "SWORD";


        //三个不同参数的构造函数(后两个暂时省掉了）
        //带全部参数的构造函数，此构造函数必不可少
        public DatabaseOH(Context context, String name) {
            this(context, name, null, DATABASE_VERSION);
        }

        public DatabaseOH(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            this(context, name, factory, version, null);
        }

        public DatabaseOH(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
            super(context, name, factory, version, errorHandler);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {

            Log.i(SWORD, "++++++++++++++++++++++++++create a Database++++++++++++++++++++++++++++++++");

            //记录者的表
            db.execSQL(
                    "CREATE TABLE IF NOT EXISTS Recorders(Recorderid INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "Recorder VARCHAR(20))"
            );
            //支出表
            db.execSQL(
                    "CREATE TABLE IF NOT EXISTS Records(Record_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "Recorder VARCHAR(20), " +
                            "Reason VARCHAR(80), " +
                            "Value REAL(20), " +
                            "TagName VARCHAR(20), " +
                            "[CreatedTime] TimeStamp NOT NULL DEFAULT (datetime('now','localtime')), " +
                            "FOREIGN KEY(Recorder) REFERENCES Recorders(recorder), " +
                            "FOREIGN KEY(TagName) REFERENCES Tags(TagName))"
            );


            //标签表
            db.execSQL(
                    "CREATE TABLE IF NOT EXISTS Tags(tagid INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "TagName VARCHAR(20)," +
                            "Type VARCHAR(10))"
            );
//初始化标签
            db.execSQL("INSERT INTO Tags(TagName,Type) VALUES ('吃饭', 'Records')");
            db.execSQL("INSERT INTO Tags(TagName,Type) VALUES ('出行', 'Records')");
            db.execSQL("INSERT INTO Tags(TagName,Type) VALUES ('购物', 'Records')");
            db.execSQL("INSERT INTO Tags(TagName,Type) VALUES ('周边', 'Records')");
            db.execSQL("INSERT INTO Tags(TagName,Type) VALUES ('生活用品', 'Records')");
            db.execSQL("INSERT INTO Tags(TagName,Type) VALUES ('学习', 'Records')");
            db.execSQL("INSERT INTO Tags(TagName,Type) VALUES ('医疗', 'Records')");
            db.execSQL("INSERT INTO Tags(TagName,Type) VALUES ('通讯', 'Records')");
            db.execSQL("INSERT INTO Tags(TagName,Type) VALUES ('日常', 'Records')");
            db.execSQL("INSERT INTO Tags(TagName,Type) VALUES ('房租', 'Records')");
            db.execSQL("INSERT INTO Tags(TagName,Type) VALUES ('娱乐', 'Records')");

//初始化记录
            db.execSQL("INSERT INTO Recorders(recorder) VALUES ('明明')");
            db.execSQL("INSERT INTO Recorders(recorder) VALUES ('圆圆')");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //创建成功，日志输出提示
            Log.i(SWORD, "update a Database");
        }

    }

