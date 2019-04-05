package com.example.myapplication.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;


public class BaseActivity extends Activity {

    private ImageView mPhoto;
    private TextView mTitle;
    private ImageView mAdd;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    protected void initNavBar (boolean isShowBack, String title, boolean isShowMe){

        mPhoto = findViewById(R.id.Photo);
        mTitle = findViewById(R.id.Title);
        mAdd = findViewById(R.id.add);

        mPhoto.setVisibility(isShowBack? View.VISIBLE:View.GONE);
        mAdd.setVisibility(isShowMe? View.VISIBLE:View.GONE);
        mTitle.setText(title);


    }


}
