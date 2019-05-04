package android.wk.com.revit.homeFiles.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.wk.com.revit.DataModels.Game;
import android.wk.com.revit.R;
import android.wk.com.revit.gameActivity;

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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_home_child_content,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Picasso.with(this.context).load(gameDataModel.get(i).getGameIcon()).resize(400,400).into(viewHolder.gameIcon);
        viewHolder.gameTitle.setText(gameDataModel.get(i).getTitle());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),gameActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("gameArray", gameDataModel.get(i));
                intent.putExtra("gameBundle", bundle);
                Log.d("MyTag", "Putting extra!");
                v.getContext().startActivity(intent);
                Log.d("MyTag", "Starting intent!");
            }
        });
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
