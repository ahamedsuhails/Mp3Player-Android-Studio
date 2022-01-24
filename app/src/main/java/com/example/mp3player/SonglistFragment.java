package com.example.mp3player;

import static com.example.mp3player.MainActivity.musicFiles;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class SonglistFragment extends Fragment {

    RecyclerView recyclerView;
    MusicAdapter musicAdapter;
    ArrayList<MusicFiles> mFiles;
    int songPosition = 0;




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_songlist, container, false);
        initRecyclerView(view);



        return view;
    }

    private void initRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        if (!(musicFiles.size() < 1)) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);
            musicAdapter = new MusicAdapter(getContext(), musicFiles, new MusicAdapter.MyClickListener() {
                @Override
                public void onItemClicked(int position) {
                    songPosition = position;
                    Log.e("Frag Pos: ", String.valueOf(songPosition));
                    getActivity().getIntent().putExtra("thePosition", songPosition);
                }


            });
            recyclerView.setAdapter(musicAdapter);
        }

    }


}





