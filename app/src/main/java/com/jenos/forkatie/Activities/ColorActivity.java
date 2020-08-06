package com.jenos.forkatie.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;

import com.jenos.forkatie.Adapter.Adapter;
import com.jenos.forkatie.Data.Data;
import com.jenos.forkatie.R;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity implements Adapter.OnItemClickListener {
    private RecyclerView mRecyclerView;
    Adapter mAdapter;
    ArrayList<Data> dataList;

    /** Handles playback of all the sound files */
    private MediaPlayer mMediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        getSupportActionBar().setTitle("Colors");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        dataList = new ArrayList<>();
        dataList.add(new Data("Black","kahal",R.raw.khal));
        dataList.add(new Data("White","biyid",R.raw.biyid));
        dataList.add(new Data("Red","hamr",R.raw.hmar));
        dataList.add(new Data("Yellow","sfar",R.raw.sfar));
        dataList.add(new Data("Green","khdar",R.raw.khdar));
        dataList.add(new Data("Blue","zrak",R.raw.zrak));
        dataList.add(new Data("gray","gry",R.raw.gry));
        dataList.add(new Data("Brown","kahwi",R.raw.khwi));
        dataList.add(new Data("Pink","rozi",R.raw.rozi));
        dataList.add(new Data("Orange","bortokali",R.raw.bortokali));


        mRecyclerView = findViewById(R.id.recycle_view_color_id);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter= new Adapter(this,dataList);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(ColorActivity.this);

    }

    @Override
    public void onItemClick(int position) {
        if (mMediaPlayer!=null){
            releaseMediaPlayer();
        }

       // Toast.makeText(this, "item is clicked", Toast.LENGTH_SHORT).show();

        Data clickItem = dataList.get(position);
        if (mMediaPlayer == null){
            mMediaPlayer = MediaPlayer.create(this,clickItem.getAudioWord());
            mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    releaseMediaPlayer();
                }
            });
        }

        // Start the audio file
        mMediaPlayer.start();


    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer(){
        // If the media player is not null, then it may be currently playing a sound.
        if(mMediaPlayer != null){
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();
            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

        }
    }
}