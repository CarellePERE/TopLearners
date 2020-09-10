package com.example.toplearners.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.toplearners.R;
import com.example.toplearners.model.skilliq;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TopSkillRecyclerAdapter extends RecyclerView.Adapter<TopSkillRecyclerAdapter.viewHolder>  {
    private List<skilliq> skillList;
    private Context mContext;
    public TopSkillRecyclerAdapter()
    {

    }
    public  void setData(List<skilliq> IQList)
    {
        this.skillList = IQList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public TopSkillRecyclerAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        return new TopSkillRecyclerAdapter.viewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.list_skill_item, parent,  false ));
    }

    @Override
    public void onBindViewHolder(@NonNull TopSkillRecyclerAdapter.viewHolder holder, int position) {
        skilliq skilliq = skillList.get(position);
        String name = skilliq.getName();
        Integer hours = skilliq.getScore();
        String country = skilliq.getCountry();
        String badge = skilliq.getBadgeUrl();

        holder.Name.setText(name);
        holder.score.setText(hours+" Skill IQ score, ");
        holder.country.setText(country);
        //holder.badge.setImageURI(Uri.parse(badge));
        Picasso.get().load(badge).into(holder.badge);

    }

    @Override
    public int getItemCount() {
        return skillList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView Name;
        TextView score;
        TextView country;
        ImageView badge;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.S_Txt_nom);
            score = itemView.findViewById(R.id.Stxt_Score);
            country = itemView.findViewById(R.id.s_txt_country);
            badge = itemView.findViewById(R.id.Img_score);
        }
    }
}
