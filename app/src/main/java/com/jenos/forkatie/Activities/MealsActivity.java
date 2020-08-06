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

public class MealsActivity  extends AppCompatActivity implements Adapter.OnItemClickListener {
    private RecyclerView mRecyclerView;
    Adapter mAdapter;
    ArrayList<Data> dataList;

    /** Handles playback of all the sound files */
    private MediaPlayer mMediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);
        getSupportActionBar().setTitle("Greetings");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        dataList = new ArrayList<>();
        dataList.add(new Data("Breakfast","fotor",R.raw.ftor));
        dataList.add(new Data("Lunch","rada",R.raw.lrda));
        dataList.add(new Data("Dinner","acha",R.raw.lacha));
        dataList.add(new Data("Bread","khabz",R.raw.khbz));
        dataList.add(new Data("Meat","laham",R.raw.lahm));
        dataList.add(new Data("Fish","samak",R.raw.hot));
        dataList.add(new Data("Sugar","sokar",R.raw.skar));
        dataList.add(new Data("Salt","milh",R.raw.milh));
        dataList.add(new Data("Eggs","bayd",R.raw.lbid));
        dataList.add(new Data("Soup","chorba , soba , harira",R.raw.soba));
        dataList.add(new Data("Potatoes","batata",R.raw.btata));
        dataList.add(new Data("Tomatoes","maticha",R.raw.maticha));
        dataList.add(new Data("Onions","basal",R.raw.basal));
        dataList.add(new Data("Salad","chalada",R.raw.chlada));
        dataList.add(new Data("Olive","ziton",R.raw.ziton));
        dataList.add(new Data("Carrots","khizo",R.raw.khizo));



        mRecyclerView = findViewById(R.id.recycle_view_meals_id);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter= new Adapter(this,dataList);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(MealsActivity.this);

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