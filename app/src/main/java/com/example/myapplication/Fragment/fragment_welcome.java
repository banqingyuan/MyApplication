package com.example.myapplication.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.example.myapplication.R;
import java.util.Timer;
import java.util.TimerTask;

public class fragment_welcome extends BaseFragment {

    private ImageView IM_text;
    private ImageView IM_text2;
    private View view;
    private BottomNavigationView Btn_Nav;
    private FrameLayout tool_bar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_welcome,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Btn_Nav = getActivity().findViewById(R.id.navigation);
        Btn_Nav.setVisibility(View.GONE);
        tool_bar = getActivity().findViewById(R.id.tool_bar);
        tool_bar.setVisibility(View.GONE);
    }

    @Override
    public void onResume() {
        super.onResume();
        IM_text2 = view.findViewById(R.id.IM_text2);
        IM_text2.setAlpha(0);
        init();
    }

    private void init(){
        //延时操作样例
        Timer mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                IM_text = view.findViewById(R.id.IM_text);
                IM_text.setAlpha(0);
            }
        },2000);
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                IM_text2.setAlpha(1000);
            }
        },2100);
        mTimer.schedule(new TimerTask() {
            @Override
        public void run() {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_layout, new fragment_home()).commit();
        }
    },3000);
    }
}
