package com.jenos.forkatie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.jenos.forkatie.Activities.ColorActivity;
import com.jenos.forkatie.Activities.DaysActivity;
import com.jenos.forkatie.Activities.DrinksActivity;
import com.jenos.forkatie.Activities.FamilyActivity;
import com.jenos.forkatie.Activities.FruitActivity;
import com.jenos.forkatie.Activities.GreetingActivity;
import com.jenos.forkatie.Activities.MealsActivity;
import com.jenos.forkatie.Activities.NumbersActivity;
import com.jenos.forkatie.Activities.TimeActivity;
import com.jenos.forkatie.Activities.Travelling;
import com.jenos.forkatie.Activities.WordsActivity;

public class MainActivity extends AppCompatActivity {

    private CardView greeting,number,days,time,words,meals,fruits,drinks,family,travelling,color,bonus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initCardView();

    }

    public void initCardView(){
        greeting=findViewById(R.id.greeting_btn_id);
        number  = findViewById(R.id.number_btn_id);
        days=findViewById(R.id.days_btn_id);
        time=findViewById(R.id.time_btn_id);
        words=findViewById(R.id.word_btn_id);
        meals=findViewById(R.id.meals_btn_id);
        fruits=findViewById(R.id.fruit_btn_id);
        drinks=findViewById(R.id.drink_btn_id);
        family=findViewById(R.id.family_btn_id);
        travelling=findViewById(R.id.travel_btn_id);
        color=findViewById(R.id.color_btn_id);
        bonus=findViewById(R.id.bonus_btn_id);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.greeting_btn_id:
              //  Toast.makeText(MainActivity.this, "greeting clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, GreetingActivity.class));
                break;
            case R.id.number_btn_id:
               // Toast.makeText(MainActivity.this, "number clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, NumbersActivity.class));
                break;
            case R.id.days_btn_id:
              //  Toast.makeText(MainActivity.this, "day clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, DaysActivity.class));
                break;
            case R.id.time_btn_id:
               // Toast.makeText(MainActivity.this, "time clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, TimeActivity.class));
                break;
            case R.id.word_btn_id:
               // Toast.makeText(MainActivity.this, "words clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, WordsActivity.class));
                break;
            case R.id.meals_btn_id:
               // Toast.makeText(MainActivity.this, "meals clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, MealsActivity.class));
                break;
            case R.id.fruit_btn_id:
                //Toast.makeText(MainActivity.this, "fruit clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, FruitActivity.class));
                break;
            case R.id.drink_btn_id:
               // Toast.makeText(MainActivity.this, "drink clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, DrinksActivity.class));
                break;
            case R.id.family_btn_id:
               // Toast.makeText(MainActivity.this, "family clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, FamilyActivity.class));
                break;
            case R.id.travel_btn_id:
               // Toast.makeText(MainActivity.this, "travel clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, Travelling.class));
                break;
            case R.id.color_btn_id:
                //Toast.makeText(MainActivity.this, "color clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, ColorActivity.class));
                break;
            case R.id.bonus_btn_id:
                Toast.makeText(MainActivity.this, "Coming soon!", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}