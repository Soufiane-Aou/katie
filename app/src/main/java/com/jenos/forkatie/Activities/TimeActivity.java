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

public class TimeActivity extends AppCompatActivity implements Adapter.OnItemClickListener {
    private RecyclerView mRecyclerView;
    Adapter mAdapter;
    ArrayList<Data> dataList;

    /** Handles playback of all the sound files */
    private MediaPlayer mMediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_acitivity);
        getSupportActionBar().setTitle("Time");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        dataList = new ArrayList<>();
        dataList.add(new Data("In the morning","bsabah",R.raw.bsbah));
        dataList.add(new Data("In the evening","blil",R.raw.blil));
        dataList.add(new Data("Today","lyoma",R.raw.lyoma));
        dataList.add(new Data("In the past","flmadi",R.raw.flmadi));
        dataList.add(new Data("In the future","flmostakbal",R.raw.flmostakbal));
        dataList.add(new Data("A month","chhar",R.raw.chhar));
        dataList.add(new Data("A week","simana",R.raw.simana));
        dataList.add(new Data("A day","nhar",R.raw.nhar));
        dataList.add(new Data("An hour","saa",R.raw.saaa));
        dataList.add(new Data("A minute","dakika",R.raw.dkika));
        dataList.add(new Data("Yesterday","labarah",R.raw.lbar7));
        dataList.add(new Data("Last night","labrah blil",R.raw.lbar7bilil));
        dataList.add(new Data("On the previous day","labarh",R.raw.lbar7));
        dataList.add(new Data("Tomorrow","rada",R.raw.ghda));
        dataList.add(new Data("the next day","baad rada",R.raw.badghada));
        dataList.add(new Data("What time is it now?","chahal fsaa daba?",R.raw.ch7alfsa3adb));





        mRecyclerView = findViewById(R.id.recycle_view_time_id);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter= new Adapter(this,dataList);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(TimeActivity.this);

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