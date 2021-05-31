package com.hackslash.collosaltitan;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ImageHolder> {
    ArrayList<String> list=new ArrayList<>();
    Context context;
    RecyclerAdapter(ArrayList<String> list, Context context)
    {
        this.list=list;
        this.context=context;
    }
    @NonNull

    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ImageHolder holder=new ImageHolder(myView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ImageHolder holder, int position) {
        String url=list.get(position);
        Glide.with(context).load(url).placeholder(R.drawable.hacker).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ImageHolder extends RecyclerView.ViewHolder {
        ImageView image;
        public ImageHolder(@NonNull View itemView) {
            super(itemView);
            image=(ImageView) itemView.findViewById(R.id.image);
        }
    }
}
