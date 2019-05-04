package android.wk.com.revit.searchFiles.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.wk.com.revit.DataModels.Game;
import android.wk.com.revit.R;
import android.wk.com.revit.gameActivity;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class searchAdapter extends RecyclerView.Adapter<searchAdapter.ViewHolder> {

    ArrayList<Game> games;
    Context context;

    public searchAdapter(Context context, ArrayList<Game> gameDataModel) {
        this.context = context;
        this.games = gameDataModel;
    }

    @NonNull
    @Override
    public searchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.recycler_home_child_content,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull searchAdapter.ViewHolder viewHolder,final int i) {
        viewHolder.gameTitle.setText(games.get(i).getTitle());
        Picasso.with(this.context).load(games.get(i).getGameIcon()).resize(400,400).into(viewHolder.gameIcon);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,gameActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("gameArray",games.get(i));
                intent.putExtra("gameBundle",bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public void setFilter(ArrayList<Game> gameArrayList){
        games = new ArrayList<>();
        games.addAll(gameArrayList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView gameIcon;
        TextView gameTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.gameIcon = itemView.findViewById(R.id.gameIcon);
            this.gameTitle = itemView.findViewById(R.id.gameTitle);
        }
    }

}
