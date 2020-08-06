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

public class FamilyActivity  extends AppCompatActivity implements Adapter.OnItemClickListener {
    private RecyclerView mRecyclerView;
    Adapter mAdapter;
    ArrayList<Data> dataList;

    /** Handles playback of all the sound files */
    private MediaPlayer mMediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        getSupportActionBar().setTitle("Family");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        dataList = new ArrayList<>();
        dataList.add(new Data("Mother","mama,omi,mi,lwalida",R.raw.mama));
        dataList.add(new Data("Father","baba,ba,lwalid",R.raw.baba));
        dataList.add(new Data("Brother","khoya",R.raw.khoya));
        dataList.add(new Data("Sister","khti",R.raw.khti));
        dataList.add(new Data("Wife","mrati",R.raw.mratai));
        dataList.add(new Data("Husband","rajli",R.raw.rajli));
        dataList.add(new Data("Daughter","bnti",R.raw.bnti));
        dataList.add(new Data("Son","wldi",R.raw.wldi));
        dataList.add(new Data("Grandmother","jda",R.raw.jda));
        dataList.add(new Data("Grandfather","jdi",R.raw.jdi));
        dataList.add(new Data("Uncle (brother of my father)","ami",R.raw.ami));
        dataList.add(new Data("Uncle (brother of my mother)","khli",R.raw.khali));
        dataList.add(new Data("Aunt (sister of my father)","amti",R.raw.amti));
        dataList.add(new Data("Cousin (sister of my mother)","khalti",R.raw.khalti));
        dataList.add(new Data("Nephew :the male child of your bro/sis","wld khti/khoya",R.raw.wldkhoyakhti));
        dataList.add(new Data("Niece :the female child of your bro/sis","bnt khti/khoya",R.raw.bntkhotykhti));


        mRecyclerView = findViewById(R.id.recycle_view_family_id);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter= new Adapter(this,dataList);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(FamilyActivity.this);

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