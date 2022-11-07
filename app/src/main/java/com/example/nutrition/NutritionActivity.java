package com.example.nutrition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URI;

public class NutritionActivity extends AppCompatActivity
{

    public String item_id;
    Intent intent;

    public String[] nutrition_topics;
    public String[] nutrition_values;

    public RecyclerView nutrition_recycler;
    public NutritionRecyclerAdapter nutrition_recyclerAdapter;

    public MaterialButton back_btn;

    public MaterialButton save_data;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nutrition_activity);

        intent = getIntent();
        item_id = intent.getStringExtra("item_id");

        back_btn = findViewById(R.id.backbutton);
        save_data = findViewById(R.id.savebutton);

        ReadNutritioncsv readNutritioncsv = new ReadNutritioncsv();

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(getResources().openRawResource(R.raw.nutrition_table));
            readNutritioncsv.setValues(inputStreamReader);
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(),"Cannot find the Apt food",Toast.LENGTH_SHORT).show();
            nutrition_topics = new String[]{};
            finish();
        }
        try {
            nutrition_topics = readNutritioncsv.read_topics();
            nutrition_values = readNutritioncsv.read_values(item_id);
            if(nutrition_values.length == 0)
            {
                throw new Exception("not found error");
            }
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(),"Cannot find data",Toast.LENGTH_SHORT).show();
            finish();
        }

        back_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });

        nutrition_recycler = (RecyclerView) findViewById(R.id.nutrition_recycler);
        nutrition_recyclerAdapter = new NutritionRecyclerAdapter();
        nutrition_recyclerAdapter.setValues(nutrition_topics,nutrition_values,this);
        nutrition_recycler.setAdapter(nutrition_recyclerAdapter);
        nutrition_recycler.setLayoutManager(new LinearLayoutManager(this));

        save_data.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                try
                {
                    String uristring = "file:///android_asset/user_nutrition.csv";
                    URI uri = URI.create(uristring);
                    File csvfile = new File(new URI("file:///android_asset/user_nutrition"));
                    FileWriter fileWriter = new FileWriter(csvfile);
                    CSVWriter csvWriter = new CSVWriter(fileWriter);
                    String[] Writeit = nutrition_values;
                    csvWriter.writeNext(new String[]{"101","10","11","12","13","14","15","11","12"});
                    Toast.makeText(getApplicationContext(),"Data Saved",Toast.LENGTH_LONG);
                    finish();
                }
                catch(Exception e)
                {
                    System.out.println("999999999999999999999999999999999999999999999999999999999999999999999999999999999");
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"hi",Toast.LENGTH_LONG);
                    //finish();
                }
            }
        });

    }
}