package com.example.nutrition;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>
{
    public String[] item_names;
    public String[] item_id;
    public int[] image_names;
    public Context context;

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView item_name;
        public ImageView item_pic;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            item_name = itemView.findViewById(R.id.recycle_item_name);
            item_pic = itemView.findViewById(R.id.foodimage);
            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    int pos = getAdapterPosition();
                    //Toast.makeText(context.getApplicationContext(),"You Clicked:"+item_id[pos],Toast.LENGTH_SHORT).show();
                    Intent switchActivity = new Intent(context,NutritionActivity.class);
                    switchActivity.putExtra("item_id",item_id[pos]);
                    context.startActivity(switchActivity);
                }
            });
        }

    }

    public MainRecyclerAdapter(Context context,String[] item_names,String[] item_id,int[] image_names)
    {
        this.context = context;
        this.item_names = item_names;
        this.item_id = item_id;
        this.image_names = image_names;
    }

    @NonNull
    @Override
    public MainRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View newview = inflater.inflate(R.layout.recyclerrow,parent,false);

        float height = parent.getMeasuredHeight() / item_id.length;
        float weight = parent.getMeasuredWidth();

        newview.setLayoutParams(new RecyclerView.LayoutParams((int) weight, (int) height));

        ViewHolder viewHolder = new ViewHolder(newview);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainRecyclerAdapter.ViewHolder holder, int position)
    {
        holder.item_name.setText(item_names[position]);
        holder.item_pic.setImageResource(image_names[position]);
    }

    @Override
    public int getItemCount() {
        return item_id.length;
    }
}
