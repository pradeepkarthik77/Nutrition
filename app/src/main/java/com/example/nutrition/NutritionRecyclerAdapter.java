package com.example.nutrition;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

public class NutritionRecyclerAdapter extends RecyclerView.Adapter<NutritionRecyclerAdapter.ViewHolder>
{
    public String[] nutrition_topics;
    public String[] nutrition_values;
    public Context context;

    public void setValues(String[] nutrition_topics,String[] nutrition_values,Context context)
    {
        this.nutrition_topics = Arrays.copyOfRange(nutrition_topics,1,nutrition_topics.length+1);
        this.nutrition_values = Arrays.copyOfRange(nutrition_values,1,nutrition_values.length+1);
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView item_topic;
        public TextView item_value;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            item_topic = itemView.findViewById(R.id.nutrition_topic);
            item_value = itemView.findViewById(R.id.nutrition_value);
        }
    }

    @NonNull
    @Override
    public NutritionRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View newview = inflater.inflate(R.layout.nutritionrow,parent,false);

        return new ViewHolder(newview);
    }

    @Override
    public void onBindViewHolder(@NonNull NutritionRecyclerAdapter.ViewHolder holder, int position)
    {
        holder.item_topic.setText(nutrition_topics[position]+": ");
        holder.item_value.setText(nutrition_values[position]);
    }

    @Override
    public int getItemCount()
    {
        return this.nutrition_topics.length-1;
    }


}
