package com.example.test1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    Context context;
    ArrayList<HashMap<String, Object>> list;

    public RecyclerViewAdapter(Context context, ArrayList<HashMap<String, Object>> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_node, parent, false);
        mViewHolder viewHolder = new mViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((mViewHolder)holder).imageView.setImageResource((Integer)list.get(position).get("img"));
        ((mViewHolder)holder).title.setText((String)list.get(position).get("title"));
        ((mViewHolder)holder).info.setText((String)list.get(position).get("info"));
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    private class mViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title, info;

        public mViewHolder(View view) {
            super(view);
            imageView =  view.findViewById(R.id.img);
            title=view.findViewById(R.id.title);
            info=view.findViewById(R.id.info);
        }
    }
}