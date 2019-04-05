package com.example.myapplication.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

public class BaseFragment extends Fragment {

    private ImageView mPhoto;
    private TextView mTitle;
    private ImageView mAdd;


    public void initNvBar(boolean isShowBack, String title, boolean isShowMe){

        mPhoto = getActivity().findViewById(R.id.Photo);
        mTitle = getActivity().findViewById(R.id.Title);
        mAdd = getActivity().findViewById(R.id.add);

        mPhoto.setVisibility(isShowBack? View.VISIBLE:View.GONE);
        mAdd.setVisibility(isShowMe? View.VISIBLE:View.GONE);
        mTitle.setText(title);

    }
}
