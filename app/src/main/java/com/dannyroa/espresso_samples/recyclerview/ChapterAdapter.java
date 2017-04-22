package com.dannyroa.espresso_samples.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dannyroa on 5/8/15.
 */
public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ViewHolder>  {

    private List<Team> items;
    public static List<Sub_Team> sub_teams;
    private Context context;
    private RecyclerView rvTeamsHor;

    public ChapterAdapter(Context context, List<Team> items) {
        this.items = items;
        this.context = context;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                               .inflate(R.layout.list_item_team, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        Team team = items.get(position);
        holder.setTeam(team);

        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        JourneyAdapter adapter2 = new JourneyAdapter(context, sub_teams);

        rvTeamsHor.setLayoutManager(layoutManager2);
        rvTeamsHor.setAdapter(adapter2);
    }

    @Override public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvChapterName);
            rvTeamsHor = (RecyclerView) itemView.findViewById(R.id.rvSubteam);

            sub_teams = new ArrayList<>();
            sub_teams.add(new Sub_Team("California"));
            sub_teams.add(new Sub_Team("Berlin"));
            sub_teams.add(new Sub_Team("Dakota"));
            sub_teams.add(new Sub_Team("Ireland"));
            sub_teams.add(new Sub_Team("Korea"));
            sub_teams.add(new Sub_Team("Quebec"));
            sub_teams.add(new Sub_Team("Sana"));
            sub_teams.add(new Sub_Team("India"));
            sub_teams.add(new Sub_Team("Seatle"));
            sub_teams.add(new Sub_Team("Minnesota"));
            sub_teams.add(new Sub_Team("London"));
            sub_teams.add(new Sub_Team("Maldives"));
        }


        public void setTeam(final Team team) {

            tvName.setText(team.getName());

       /*     itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View view) {

                    ViewTeamActivity.launch((Activity) context, team);
                }
            });*/

        }

        public List<Sub_Team> getTeams2(){
            return sub_teams;
        }
    }
}
