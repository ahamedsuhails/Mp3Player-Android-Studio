package com.example.mp3player;

import android.annotation.SuppressLint;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.NoCopySpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<MusicFiles> mFiles;
    String song_position;
    MyClickListener myClickListener;


    public MusicAdapter(Context mContext, ArrayList<MusicFiles> mFiles, MyClickListener myClickListener) {
        this.mContext = mContext;
        this.mFiles = mFiles;
        this.myClickListener = myClickListener;


    }


    @NonNull
    @Override
    public MusicAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.music_items, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.fileName.setText(mFiles.get(position).getTitle());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment();
                song_position = String.valueOf(holder.getAdapterPosition());
                myClickListener.onItemClicked(holder.getAdapterPosition());
            }

        });
    }

    private void changeFragment() {
        MainActivity.viewPager2.setCurrentItem(1);
    }

    @Override
    public int getItemCount() {
        return mFiles.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView fileName;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            fileName = itemView.findViewById(R.id.musicFileName);


        }

    }

    public interface MyClickListener {
        public void onItemClicked(int position);
    }


}
