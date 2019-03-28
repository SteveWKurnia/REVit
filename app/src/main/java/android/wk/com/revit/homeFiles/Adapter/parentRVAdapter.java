package android.wk.com.revit.homeFiles.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.wk.com.revit.DataModels.Game;
import android.wk.com.revit.R;

import java.util.ArrayList;

public class parentRVAdapter extends RecyclerView.Adapter<parentRVAdapter.viewHolder> {

    ArrayList<Game> gameDataModel;
    Context context;
    RecyclerView.RecycledViewPool viewPool;

    public parentRVAdapter(ArrayList<Game> gameDataModel, Context context) {
        this.gameDataModel = gameDataModel;
        this.context = context;
        viewPool = new RecyclerView.RecycledViewPool();
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_home_parent_content,viewGroup,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int i) {
        viewHolder.categoryTitle.setText(gameDataModel.get(i).getCategory());
        ArrayList<Game> actionDataModel = new ArrayList<>();
        ArrayList<Game> strategyDataModel = new ArrayList<>();
        ArrayList<Game> simulatorDataModel = new ArrayList<>();

        Log.d("MyLog", i + " loop " + gameDataModel.get(i).getTitle());

        ////TRY////
        for (int j = i; j < gameDataModel.size(); j++){
            if (this.gameDataModel.get(i).getCategory() == this.gameDataModel.get(j).getCategory()){

                Log.d("MyLog", "     Action: " + j + " loop" + gameDataModel.get(j).getTitle());

                actionDataModel.add(this.gameDataModel.get(j));

                viewHolder.childRecycler.setRecycledViewPool(viewPool);
                viewHolder.childRecycler.setLayoutManager(new LinearLayoutManager(viewHolder.childRecycler.getContext(), 0,false));
                viewHolder.childRecycler.setAdapter(new childRVAdapter(actionDataModel,context));
            }
            else if(this.gameDataModel.get(i).getCategory() == this.gameDataModel.get(j).getCategory()){

                Log.d("MyLog", "     Simulator: " + j + " loop " + gameDataModel.get(j).getTitle());

                simulatorDataModel.add(this.gameDataModel.get(j));

                viewHolder.childRecycler.setRecycledViewPool(viewPool);
                viewHolder.childRecycler.setLayoutManager(new LinearLayoutManager(viewHolder.childRecycler.getContext(), 0,false));
                viewHolder.childRecycler.setAdapter(new childRVAdapter(simulatorDataModel,context));
            }
            else if(this.gameDataModel.get(i).getCategory() == this.gameDataModel.get(j).getCategory()){

                Log.d("MyLog", "     Strategy: " + j + " loop " + gameDataModel.get(j).getTitle());

                strategyDataModel.add(this.gameDataModel.get(j));

                viewHolder.childRecycler.setRecycledViewPool(viewPool);
                viewHolder.childRecycler.setLayoutManager(new LinearLayoutManager(viewHolder.childRecycler.getContext(), 0,false));
                viewHolder.childRecycler.setAdapter(new childRVAdapter(strategyDataModel,context));
            }
        }
        ////TRY////
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        TextView categoryTitle;
        RecyclerView childRecycler;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            this.categoryTitle = itemView.findViewById(R.id.categoryTitle);
            this.childRecycler = itemView.findViewById(R.id.childRecycler);
        }
    }

}
