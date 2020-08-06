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

public class GreetingActivity extends AppCompatActivity implements Adapter.OnItemClickListener {
    private RecyclerView mRecyclerView;
    Adapter mAdapter;
    ArrayList<Data> dataList;

    /** Handles playback of all the sound files */
    private MediaPlayer mMediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);
        getSupportActionBar().setTitle("Greetings");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        dataList = new ArrayList<>();
        dataList.add(new Data("Hello","salam",R.raw.salam));
        dataList.add(new Data("Good morning","sabah alkhyr",R.raw.sba7_lkhir));
        dataList.add(new Data("Good evening","masa\' alkhayr",R.raw.ms_lkhir));
        dataList.add(new Data("Good night","tusbih ealaa khayr",R.raw.tsbah3lakhir));
        dataList.add(new Data("Good bye","bslama",R.raw.bslama));
        dataList.add(new Data("See you again","nchofk mra khra",R.raw.nchofk_mra_khra));
        dataList.add(new Data("Glad to see you","masaror birawayatik",R.raw.marorbiro));
        dataList.add(new Data("See you tomorrow","nchofk rada",R.raw.nchofk_ghda));
        dataList.add(new Data("How are you?","labs alik",R.raw.labasalik));
        dataList.add(new Data("Fine ,thank you,How are you? ","bikhir chokran onta labas alik",R.raw.bikhirchokranonta));
        dataList.add(new Data("I missed you  ","twahachtak",R.raw.twa7chtk));
        dataList.add(new Data("Good luck ","hazun saeid",R.raw.hdansaid));
        dataList.add(new Data("See you later ","'nchofk mn bad",R.raw.nchofkmnba3d));

        mRecyclerView = findViewById(R.id.recycle_view_greeting_id);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter= new Adapter(this,dataList);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(GreetingActivity.this);

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