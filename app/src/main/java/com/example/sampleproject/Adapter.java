package com.example.sampleproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private Context context;
    private LinkedList<String> list;
    private OnClicktener onClicktener;

    public Adapter(Context context, LinkedList<String> list, OnClicktener onClicktener) {
        this.context = context;
        this.list = list;
        this.onClicktener = onClicktener;
    }

    public interface OnClicktener {
        void onClick(int n);
    }

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(list.get(position));

        holder.itemView.setOnClickListener(view -> {
            if (list.get(list.size() - 1).equals(list.get(position))) {
                onClicktener.onClick(1);
                //Monika
                Log.d("position", "onBindViewHolder: " + position + "size" + list.size());
                list.addFirst("karthika");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            textView = itemView.findViewById(R.id.recyclerView);
        }
    }
}
