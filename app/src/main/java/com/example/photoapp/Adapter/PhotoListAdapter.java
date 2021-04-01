package com.example.photoapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photoapp.Activity.ViewPhotoActivity;
import com.example.photoapp.Modal.PhotoList;
import com.example.photoapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotoListAdapter extends RecyclerView.Adapter<PhotoListAdapter.ViewHolder>  {
    List<PhotoList> list;
    Context ctx;
    public PhotoListAdapter(List<PhotoList> list, Context ctx) {
        this.list = list;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public PhotoListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_photo_list,parent,false);
        return new PhotoListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoListAdapter.ViewHolder holder, int position) {
        PhotoList l = list.get(position);
        holder.id.setText(l.getAlbumId()); // setting albumId
        Picasso.get().load(l.getThumbnailUrl()).into(holder.image); //setting thumbnail
        holder.title.setText(l.getTitle()); //setting title

        //setting on click listener to a list to show a full screen image
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent i = new Intent(ctx, ViewPhotoActivity.class);
              i.putExtra("url",l.getUrl()); //passing url to ViewPhotoActivity
              ctx.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView id,title;
        ImageView image;
        View mView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.photoId);
            image = itemView.findViewById(R.id.photo_thumbnail);
            title = itemView.findViewById(R.id.photoTitle);
            mView = itemView;
        }
    }
}
