package com.namewu.androidlearningnotes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/26.
 */

public class RecycleviewAdapter extends RecyclerView.Adapter<RecycleviewAdapter.MyViewHolder>{
    private final int NORMAL_TYPE = 1;
    private final int HEAD_TYPE = 0;
    private final int FOOT_TYPE = 2;
    private LayoutInflater inflater;
    private ArrayList<Note> list_data;
    public RecycleviewAdapter (Context mcontext, ArrayList<Note> list_data){
        inflater = LayoutInflater.from(mcontext);
        this.list_data = list_data;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case NORMAL_TYPE: View view = inflater.inflate(R.layout.listitem_note,null);
                return new MyViewHolder(view,viewType);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.text_title.setText(list_data.get(position).getTitle());
        holder.text_context.setText(list_data.get(position).getContext());
    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return NORMAL_TYPE;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView text_title;
        private TextView text_context;
        public MyViewHolder(View itemView,int type) {
            super(itemView);
            text_title = (TextView) itemView.findViewById(R.id.listitem_note_title);
            text_context = (TextView) itemView.findViewById(R.id.listitem_note_context);
        }
    }
}
