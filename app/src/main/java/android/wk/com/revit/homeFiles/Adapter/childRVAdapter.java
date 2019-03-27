package android.wk.com.revit.homeFiles.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.wk.com.revit.DataModels.Game;
import android.wk.com.revit.R;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class childRVAdapter extends RecyclerView.Adapter<childRVAdapter.ViewHolder>{

    private ArrayList<Game> gameDataModel;
    Context context;

    public childRVAdapter(ArrayList<Game> gameDataModel, Context context) {
        this.gameDataModel = gameDataModel;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_home_child_content,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Picasso.with(this.context).load(gameDataModel.get(i).getGameIcon()).resize(400,400).into(viewHolder.gameIcon);
        viewHolder.gameTitle.setText(gameDataModel.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return gameDataModel.size();
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
