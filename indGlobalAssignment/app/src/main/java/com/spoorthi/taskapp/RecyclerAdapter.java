package com.spoorthi.taskapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

/**
 * Created by Spoorthi on 1/11/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>
{

    private List<CardDataModel> listItems;
    private Context context;

    public RecyclerAdapter(List<CardDataModel> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    //To improve UI, adding some random images to the list
    private final int place_holders[] = {
            R.drawable.place_holderr,
            R.drawable.place_holder2,
            R.drawable.place_holder3,
            R.drawable.place_holder4,
            R.drawable.place_holder5,
            R.drawable.place_holder6,
            R.drawable.place_holder7,
            R.drawable.place_holder8,
    };

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater
                .inflate(R.layout.card_item,null);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position)
    {
        CardDataModel itemDataModel = listItems.get(position);

        //To select random image from the list of images
        Random r = new Random();

        int Result = r.nextInt(7)+1 ;

        Picasso.with(context).load(place_holders[Result]).placeholder(R.drawable.loading_place_holder)
                .into(holder.projectImg);
        holder.descTV.setText(itemDataModel.getDesc());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }



    public class ItemViewHolder extends RecyclerView.ViewHolder{

        public TextView descTV;
        public ImageView projectImg;

        public ItemViewHolder(View itemView) {
            super(itemView);

            projectImg = (ImageView)itemView.findViewById(R.id.projectImg);
            descTV = (TextView)itemView.findViewById(R.id.textViewDesc);

        }
    }

}
