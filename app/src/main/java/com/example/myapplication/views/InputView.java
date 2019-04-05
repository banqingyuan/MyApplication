package com.example.myapplication.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.myapplication.R;

import static android.view.LayoutInflater.from;

//自定义view应具有可定制的功能
//1、input_icon:输入框钱前面的图标
//2、input_hint：输入框的提示内容
//3、is_password：输入框的内容是否需要以密文的形式展示
//暂时废弃
public class InputView  extends FrameLayout {

    private int inputIcon;
    private String inputHint;
    private Boolean isPassWord;

    private View mView;
    private ImageView mIvIcon;
    private EditText mEtInput;


    public InputView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    private void init(Context context,AttributeSet attrs){
        if(attrs == null){
            //获取自定义属性
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.inputView);
            inputIcon = typedArray.getResourceId(R.styleable.inputView_input_icon,R.drawable.logo);
            inputHint = typedArray.getString(R.styleable.inputView_input_hint);
            isPassWord = typedArray.getBoolean(R.styleable.inputView_is_password,false);
            typedArray.recycle();

            //绑定layout布局
            mView = from(context).inflate(R.layout.view_input,this,false);
            mIvIcon = mView.findViewById(R.id.iv_icon);
            mEtInput = mView.findViewById(R.id.et_input);

            //布局关联属性
            mIvIcon.setImageResource(inputIcon);
            mEtInput.setHint(inputHint);
            mEtInput.setInputType(isPassWord? InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD : InputType.TYPE_CLASS_PHONE);

            addView(mView);
        }


    }

    public String getInputStr(){
        return mEtInput.getText().toString().trim();
    }
}
