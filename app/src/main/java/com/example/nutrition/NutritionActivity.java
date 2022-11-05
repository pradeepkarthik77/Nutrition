package com.example.nutrition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import java.io.InputStreamReader;

public class NutritionActivity extends AppCompatActivity
{

    public String item_id;
    Intent intent;

    public String[] nutrition_topics;
    public String[] nutrition_values;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nutrition_activity);

        intent = getIntent();
        item_id = intent.getStringExtra("item_id");

        ReadNutritioncsv readNutritioncsv = new ReadNutritioncsv();

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(getResources().openRawResource(R.raw.nutrition_table));
            readNutritioncsv.setValues(inputStreamReader);
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(),"Cannot find the Apt food",Toast.LENGTH_SHORT).show();
            nutrition_topics = new String[]{};
            //TODO Write code to return to the Mainactivity here
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
            //TODO Write code to return to MainActivity
        }

    }
}