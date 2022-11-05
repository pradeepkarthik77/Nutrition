package com.example.nutrition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{


    public String[] item_names = {"Idli","Dosa","Pongal","Masal Dosa","Sambhar Vada","Vada","Panner Roast","Veg Noodles","Parotta","Fried Rice"};

    public String[] item_id = {"101","102","103","104","105","106","107","108","109","110"};

    public int[] image_names = {R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6,R.drawable.image7,R.drawable.image8,R.drawable.image9,R.drawable.image10};

    public RecyclerView mainactivity_recycler;
    public RecyclerView.Adapter mainrecycleradapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainactivity_recycler = (RecyclerView) findViewById(R.id.mainactivity_recycler);
        mainrecycleradapter = new MainRecyclerAdapter(this,item_names,item_id,image_names);
        mainactivity_recycler.setAdapter(mainrecycleradapter);
        mainactivity_recycler.setLayoutManager(new LinearLayoutManager(this));
    }
}