package com.jenos.forkatie.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jenos.forkatie.Data.Data;
import com.jenos.forkatie.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {



    private ArrayList<Data> dataList;
    public Context mContext;
    private OnItemClickListener mListener;


    public Adapter(Context mContext,ArrayList<Data> dataList) {
        this.dataList = dataList;
        this.mContext = mContext;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        Data currentItem = dataList.get(position);
        String english_word = currentItem.getEnglishWord();
        String arabic_word  = currentItem.getArabicWord();




        holder.arabicWord.setText(arabic_word);
        holder.englishword.setText(english_word);




    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        public TextView englishword,arabicWord;
        public ImageView playBtn;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            englishword=itemView.findViewById(R.id.english_word_id);
            arabicWord=itemView.findViewById(R.id.arabic_word_id);
            playBtn=itemView.findViewById(R.id.play_id);
            playBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener!=null){
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });


        }
    }




}
