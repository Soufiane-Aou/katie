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

public class Travelling  extends AppCompatActivity implements Adapter.OnItemClickListener {
    private RecyclerView mRecyclerView;
    Adapter mAdapter;
    ArrayList<Data> dataList;

    /** Handles playback of all the sound files */
    private MediaPlayer mMediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travelling);
        getSupportActionBar().setTitle("Travelling");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        dataList = new ArrayList<>();
        dataList.add(new Data("Passport","pasport",R.raw.pasport));
        dataList.add(new Data("Direction","itijah",R.raw.itijah));
        dataList.add(new Data("Plan","tiyira",R.raw.tiyira));
        dataList.add(new Data("Express train","kitar sarie",R.raw.kitarsaria));
        dataList.add(new Data("Train","kitar",R.raw.kitar));
        dataList.add(new Data("Residence","ikama",R.raw.ikama));
        dataList.add(new Data("Ticket","ticket",R.raw.tikit));
        dataList.add(new Data("Passenger","mosafir",R.raw.mosafir));
        dataList.add(new Data("Station","mahata",R.raw.mahta));
        dataList.add(new Data("Controller","moftich",R.raw.moftich));
        dataList.add(new Data("Engaged","mahjoz",R.raw.mhjoz));
        dataList.add(new Data("Visa","visa",R.raw.visa));
        dataList.add(new Data("Bag","hakiba",R.raw.hakiba));




        mRecyclerView = findViewById(R.id.recycle_view_travel_id);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter= new Adapter(this,dataList);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(Travelling.this);

    }

    @Override
    public void onItemClick(int position) {
        if (mMediaPlayer!=null){
            releaseMediaPlayer();
        }

        //Toast.makeText(this, "item is clicked", Toast.LENGTH_SHORT).show();

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