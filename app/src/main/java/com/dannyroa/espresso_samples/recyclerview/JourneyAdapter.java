package com.dannyroa.espresso_samples.recyclerview;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AnjaliUnnikrishnan on 29/03/17.
 */

public class JourneyAdapter extends RecyclerView.Adapter<JourneyAdapter.ViewHolder>  {

    List<Sub_Team> items;
    Context context;

    public JourneyAdapter(Context context, List<Sub_Team> items) {
        this.items = items;
        this.context = context;
    }

    @Override public JourneyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.learn_tv_subtopic, parent, false);

        JourneyAdapter.ViewHolder vh = new JourneyAdapter.ViewHolder(v);

        return vh;
    }

    @Override public void onBindViewHolder(JourneyAdapter.ViewHolder holder, int position) {
        Sub_Team sub_team = items.get(position);
        holder.setTeam(sub_team);
    }

    @Override public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        TextView tvName;
        Button btnFollow;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvSubtopicName);
        }


        public void setTeam(final Sub_Team team) {

            tvName.setText(team.getName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View view) {

                    ViewTeamActivity.launch2((Activity)context, team);
                }
            });

        }
    }
}
