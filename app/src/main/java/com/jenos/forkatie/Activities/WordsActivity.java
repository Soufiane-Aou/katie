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

public class WordsActivity  extends AppCompatActivity implements Adapter.OnItemClickListener {
    private RecyclerView mRecyclerView;
    Adapter mAdapter;
    ArrayList<Data> dataList;

    /** Handles playback of all the sound files */
    private MediaPlayer mMediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);
        getSupportActionBar().setTitle("Greetings");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        dataList = new ArrayList<>();
        dataList.add(new Data("Welcome","marhaba",R.raw.marhba));
        dataList.add(new Data("beautiful","zwin",R.raw.zwin));
        dataList.add(new Data("No problem","machi mochkil",R.raw.machimochkil));
        dataList.add(new Data("Nice","mzyan",R.raw.mzyan));
        dataList.add(new Data("Sleep","naas",R.raw.naas));
        dataList.add(new Data("People","nas",R.raw.nas));
        dataList.add(new Data("Thing","chi haja",R.raw.chihaja));
        dataList.add(new Data("Man","rajl",R.raw.rajl));
        dataList.add(new Data("Women","mra",R.raw.mra));
        dataList.add(new Data("Child","wld , bnt",R.raw.wldbnt));
        dataList.add(new Data("Have","andi",R.raw.andi));
        dataList.add(new Data("Do","dir",R.raw.dir));
        dataList.add(new Data("Say","gol",R.raw.gol));
        dataList.add(new Data("Go","sir",R.raw.sir));
        dataList.add(new Data("Get","khod",R.raw.khod));
        dataList.add(new Data("Make","dir,snaa",R.raw.dirsnaa));
        dataList.add(new Data("Know","araf",R.raw.araf));
        dataList.add(new Data("See","chof",R.raw.chof));
        dataList.add(new Data("Come","aji",R.raw.aji));
        dataList.add(new Data("Look","chof",R.raw.choof));
        dataList.add(new Data("Want","bit",R.raw.bit));
        dataList.add(new Data("Use","stamal",R.raw.staamal));
        dataList.add(new Data("And","wa",R.raw.wa));
        dataList.add(new Data("But","walakin",R.raw.walakin));
        dataList.add(new Data("Before","kabal",R.raw.kbal));
        dataList.add(new Data("After","baad",R.raw.baad));
        dataList.add(new Data("When","mnin",R.raw.mnin));
        dataList.add(new Data("With","maa",R.raw.maa));
        dataList.add(new Data("From","man",R.raw.man));
        dataList.add(new Data("Like","bhal,ajabni",R.raw.like));
        dataList.add(new Data("Now","daba",R.raw.daba));
        dataList.add(new Data("Please","afak",R.raw.aafak));
        dataList.add(new Data("What","achno",R.raw.achno));
        dataList.add(new Data("Yes","ah ",R.raw.ah));
        dataList.add(new Data("No","la",R.raw.la));
        dataList.add(new Data("call","itisal",R.raw.itisal));



        mRecyclerView = findViewById(R.id.recycle_view_words_id);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter= new Adapter(this,dataList);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(WordsActivity.this);

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