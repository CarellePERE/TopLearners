package com.example.toplearners.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.toplearners.R;
import com.example.toplearners.model.learners;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TopLearnersRecyclerAdapter extends RecyclerView.Adapter<TopLearnersRecyclerAdapter.viewHolder>  {
private List<learners> learnersList;
private Context mContext;

    public TopLearnersRecyclerAdapter()
    {

    }


    public  void setData(List<learners> LearnersList)
    {
        this.learnersList = LearnersList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TopLearnersRecyclerAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       mContext = parent.getContext();
        return new TopLearnersRecyclerAdapter.viewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.list_learners_item, parent,  false ));
    }

    @Override
    public void onBindViewHolder(@NonNull TopLearnersRecyclerAdapter.viewHolder holder, int position) {

        learners learner = learnersList.get(position);
        String name = learner.getName();
        Integer hours = learner.getHours();
        String country = learner.getCountry();
        String badge = learner.getBadgeUrl();

        holder.Name.setText(name);
        holder.hours.setText(hours+" learning hours, ");
        holder.country.setText(country);
        //holder.badge.setImageURI(Uri.parse(badge));
        Picasso.get().load(badge).into(holder.badge);
          }

    @Override
    public int getItemCount() {
        return learnersList.size();
    }

    public class viewHolder extends ViewHolder {
        TextView Name;
        TextView hours;
        TextView country;
        ImageView badge;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.Txt_nom);
            hours = itemView.findViewById(R.id.txt_hours);
            country = itemView.findViewById(R.id.s_txt_country);
            badge = itemView.findViewById(R.id.Img_learners);
        }
    }
}