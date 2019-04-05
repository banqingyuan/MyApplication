package com.example.myapplication.Fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;


import com.example.myapplication.Activity.AddActivity;
import com.example.myapplication.Activity.CaptureActivity;
import com.example.myapplication.Adapter.RecordsAdapter;
import com.example.myapplication.Database.DatabaseOH;
import com.example.myapplication.R;
import com.example.myapplication.Records;

public class fragment_home extends BaseFragment implements View.OnClickListener {

    private View view;
    ImageView add;
    ImageView Qrcode;
    public static final String DATABASE_NAME = "Records.db";
    RecyclerView mRecyclerView;
    private BottomNavigationView Btn_Nav;
    private FrameLayout tool_bar;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        findView();

        //把welcome.java中隐藏的控件都恢复过来
        Btn_Nav = getActivity().findViewById(R.id.navigation);
        Btn_Nav.setVisibility(View.VISIBLE);
        tool_bar = getActivity().findViewById(R.id.tool_bar);
        tool_bar.setVisibility(View.VISIBLE);

        initNvBar(true,"明明和圆圆的小账本",true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,null);
        return view;

    }

    @Override
    public void onResume() {
        super.onResume();

        //获取控件
        mRecyclerView = view.findViewById(R.id.recycler_view);
        //2.设置布局方式
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));  //线性布局
        mRecyclerView.setHasFixedSize(true);

        //实例化数据库
        DatabaseOH sqLiteOpenHelper = new DatabaseOH(getActivity(), DATABASE_NAME);
        SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
        @SuppressLint("Recycle") Cursor Query = db.rawQuery("select * from Records", null);


        //检查是否有记录
        if (Query.getCount() == 0) {
            return;
        } else {

            //初始化记录的对象数组
            int C = Query.getCount();
            Records[] recordslist = new Records[C];
            int i = 0;
            while (Query.moveToNext()) {
                recordslist[i] = new Records();
                Log.i("info", String.valueOf(C));
                Log.i("info", "查询语句来过了！！！！！！！！！！！！");
                recordslist[i].setRecorder(Query.getString(Query.getColumnIndex("Recorder")));
                recordslist[i].setValue(Query.getInt(Query.getColumnIndex("Value")));

                recordslist[i].setReason(Query.getString(Query.getColumnIndex("Reason")));
                i++;
            }


            Query.close();
            db.close();

            //4.设置设置适配器
            RecordsAdapter recordsAdapter = new RecordsAdapter();
            recordsAdapter.InitAdapter(recordslist);
            mRecyclerView.setAdapter(recordsAdapter);
        }
    }

    private void findView() {
        //根据控件ID得到控件
        add = getActivity().findViewById(R.id.add);
        //添加监听器
        add.setOnClickListener(this);

        //根据控件ID得到控件
        Qrcode = getActivity().findViewById(R.id.Photo);
        //添加监听器
        Qrcode.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:

                Intent Add_Intent = new Intent(getActivity(), AddActivity.class);
                startActivity(Add_Intent);

//                启动系统相册样例
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                intent.setType("image/*");
//                startActivity(intent);
                break;

            case R.id.Photo:
                Intent QR_Intent = new Intent(getActivity(), CaptureActivity.class);
                startActivity(QR_Intent);
                break;
            default:
                Log.i("SWORD", "error");
                break;
        }
    }
}
