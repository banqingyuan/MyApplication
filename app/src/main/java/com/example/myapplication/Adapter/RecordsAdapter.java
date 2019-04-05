package com.example.myapplication.Adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.Records;

public class RecordsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Records[] recordsList;

    public void InitAdapter(Records[] RecordsList){
        //声明一个数据集合
        this.recordsList = RecordsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@ NonNull ViewGroup viewGroup, int i) {
        //创建一个子布局
        return createRecordsViewHolder(viewGroup);
    }
    private RecordsViewHolder createRecordsViewHolder (ViewGroup viewGroup) {
        //实例化子布局
        View itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.body_item,viewGroup,false);
        //获得一个ViewHolder实例
        return new RecordsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        //为一条记录绑定一个视图
        bindViewForRecords(holder,position);
    }

    private Records getItem(int position){
        //获取每条记录的内容
        return recordsList[position];
    }

    private void bindViewForRecords(RecyclerView.ViewHolder holder, int position) {
        RecordsViewHolder RecordsViewHolder=(RecordsViewHolder) holder;
        final Records Records = getItem(position);

        //将数据填充进去
        if (Records.getRecorder().equals("明明"))
            RecordsViewHolder.icon.setBackgroundResource(R.mipmap.mm);
        else
            RecordsViewHolder.icon.setBackgroundResource(R.mipmap.yy);
        RecordsViewHolder.recorder.setText(Records.getRecorder());
        RecordsViewHolder.reason.setText(Records.getReason());
        RecordsViewHolder.value.setText(String.valueOf(Records.getValue()));//setText不能用int型！！！否则会被理解成资源id

    }

    static class RecordsViewHolder extends RecyclerView.ViewHolder {

        public ImageView icon;
        public TextView recorder;
        public TextView reason;
        public TextView value;
        private RecordsViewHolder(View itemView) {
            super(itemView);
            //获取子布局的控件实例
            icon = itemView.findViewById(R.id.icon);
            recorder = itemView.findViewById(R.id.recorder);
            reason = itemView.findViewById(R.id.reason);
            value =itemView.findViewById(R.id.value);
        }
    }

    @Override
    public int getItemCount() {
        return recordsList == null?1:recordsList.length;
    }
}
