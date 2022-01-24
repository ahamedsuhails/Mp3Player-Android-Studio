package com.example.mp3player;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.HashMap;
import java.util.Map;

public class PagerAdapter extends FragmentStateAdapter {


    public PagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);


    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1) {
            return new NowplayingFragment();
        } else {
            return new SonglistFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }


}
