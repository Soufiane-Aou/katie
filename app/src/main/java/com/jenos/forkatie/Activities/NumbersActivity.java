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

public class NumbersActivity extends AppCompatActivity implements Adapter.OnItemClickListener {
    private RecyclerView mRecyclerView;
    Adapter mAdapter;
    ArrayList<Data> dataList;

    /** Handles playback of all the sound files */
    private MediaPlayer mMediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        getSupportActionBar().setTitle("Numbers");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        dataList = new ArrayList<>();
        dataList.add(new Data("One","wahad",R.raw.oine));
        dataList.add(new Data("Two","jej",R.raw.two));
        dataList.add(new Data("Three","tlata",R.raw.three));
        dataList.add(new Data("Four","raba",R.raw.four));
        dataList.add(new Data("Five","khamsa",R.raw.five));
        dataList.add(new Data("Six","sata",R.raw.six));
        dataList.add(new Data("Seven","sabaa",R.raw.seven));
        dataList.add(new Data("Eight","tmaniya",R.raw.eight));
        dataList.add(new Data("Nine","tasaa",R.raw.nine));
        dataList.add(new Data("Teen ","achara",R.raw.teen));
        dataList.add(new Data("eleven","hadach",R.raw.eleven));
        dataList.add(new Data("twelve ","tanach",R.raw.twelve));
        dataList.add(new Data("thirteen","'tlatach",R.raw.threteen));
        dataList.add(new Data("fourteen","'rabatach",R.raw.fouteen));
        dataList.add(new Data("fifteen","'khamastach",R.raw.fifteen));
        dataList.add(new Data("sixteen","'satach",R.raw.sixteen));
        dataList.add(new Data("seventeen","'sbatach",R.raw.seventeen));
        dataList.add(new Data("eighteen","'tmantach",R.raw.eighteen));
        dataList.add(new Data("ninteen","'tsatach",R.raw.nineteen));
        dataList.add(new Data("twenty","'achrin",R.raw.tweny));
        dataList.add(new Data("thirty","'tlatin",R.raw.threety));
        dataList.add(new Data("fourty","'arbin",R.raw.fourty));
        dataList.add(new Data("fifty","'khamsin",R.raw.fiftey));
        dataList.add(new Data("sixty","'satin",R.raw.sixtey));
        dataList.add(new Data("seventy","'sabin",R.raw.seventey));
        dataList.add(new Data("eighty","'tmanin",R.raw.eighty));
        dataList.add(new Data("ninty","tasin",R.raw.ninety));
        dataList.add(new Data("hundred","mia",R.raw.handerd));
        dataList.add(new Data("thousand","alf",R.raw.thousn));
        dataList.add(new Data("million","'mlion",R.raw.milion));

        mRecyclerView = findViewById(R.id.recycle_view_number_id);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter= new Adapter(this,dataList);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(NumbersActivity.this);

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