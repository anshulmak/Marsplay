package com.example.marsplay.Adapters;


import android.animation.ObjectAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marsplay.R;

import java.util.ArrayList;

public class RecyclerView_Adapter extends RecyclerView.Adapter<RecyclerView_Adapter.ViewHolder> {

    private ArrayList<String> listdata;

    public RecyclerView_Adapter(ArrayList<String> listdata) {
        this.listdata = listdata;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        String text = listdata.get(position);

        holder.textview_tv.setText(text);

        holder.item_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.readmore_tv.getVisibility() == View.GONE){
                    if (holder.textview_tv.getMaxLines()<7){
                        holder.readmore_tv.setVisibility(View.VISIBLE);
                        expandTextView(holder.textview_tv,7);
                    }else{
                        collapseTextView(holder.textview_tv,5);
                    }
                }
            }
        });

        holder.readmore_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandTextView(holder.textview_tv,holder.textview_tv.getLineCount());
                holder.readmore_tv.setVisibility(View.GONE);
            }
        });

    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textview_tv , readmore_tv;
        CardView item_cv;


        ViewHolder(View itemView) {
            super(itemView);
            textview_tv = itemView.findViewById(R.id.textview_tv);
            readmore_tv = itemView.findViewById(R.id.readmore_tv);
            item_cv = itemView.findViewById(R.id.item_cv);

        }
    }

    private void expandTextView(TextView tv , int numLines){
        ObjectAnimator animation = ObjectAnimator.ofInt(tv, "maxLines", numLines);
        animation.setDuration(100).start();
    }

    private void collapseTextView(TextView tv, int numLines){
        ObjectAnimator animation = ObjectAnimator.ofInt(tv, "maxLines", numLines);
        animation.setDuration(100).start();
    }
}

