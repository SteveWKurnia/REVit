package android.wk.com.revit.searchFiles;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.wk.com.revit.DataModels.Game;
import android.wk.com.revit.DataModels.Review;
import android.wk.com.revit.R;
import android.wk.com.revit.searchFiles.Adapter.searchAdapter;

import java.util.ArrayList;

import static android.wk.com.revit.MainActivity.searchViewPublic;

public class SearchFragment extends Fragment {
    ArrayList<Game> games = addGame();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);

//        SearchView searchView = view.findViewById(R.id.searchBar);
//        SearchView searchViewPublic = view.findViewById(R.id.action_bar_search);

        RecyclerView recyclerView = view.findViewById(R.id.searchRecycler);
        final searchAdapter searchAdapter = new searchAdapter(this.getContext(), games);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3, 1,false);
        recyclerView.setAdapter(searchAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);

        searchViewPublic.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<Game> gameFiltered = filter(games, s);
                searchAdapter.setFilter(gameFiltered);
                return false;
            }
        });

        return view;
    }

    private static ArrayList<Game> addGame(){
        ArrayList<Game> games = new ArrayList<>();
        games.add(new Game("Action",R.drawable.hollow_knight_icon,R.drawable.hollow_knight_wallpaper,"Hollow Knight",0,0,new ArrayList<Review>()));
        games.add(new Game("Simulator",R.drawable.stardew_icon,R.drawable.stardew_wallpaper,"Stardew Valley",0,0,new ArrayList<Review>()));
        games.add(new Game("Strategy",R.drawable.shadow_tactics_icon,R.drawable.shadow_tactics_wallpaper,"Shadow Tactics",0,0,new ArrayList<Review>()));
        games.add(new Game("Simulator",R.drawable.rf_icon,R.drawable.rf_wallpaper,"Rune Factory 4",0,0,new ArrayList<Review>()));
        games.add(new Game("Strategy",R.drawable.atlas_icon,R.drawable.atlas_wallpaper,"Atlas Reactor",0,0,new ArrayList<Review>()));
        games.add(new Game("Action",R.drawable.hyper_light_icon,R.drawable.hyper_light_wallpaper,"Hyper Light",0,0,new ArrayList<Review>()));
        games.add(new Game("Action",R.drawable.borderlands2_icon,R.drawable.borderlands2_wallpaper,"Borderlands 2",0,0,new ArrayList<Review>()));
        games.add(new Game("Strategy",R.drawable.civ_icon,R.drawable.civ_wallpaper,"Civilization VI",0,0,new ArrayList<Review>()));
        games.add(new Game("Simulator",R.drawable.ark_icon,R.drawable.ark_wallpaper,"Ark:Survival",0,0,new ArrayList<Review>()));

        return games;
    }

    private ArrayList<Game> filter(ArrayList<Game> gameArrayList, String query){
        query = query.toLowerCase();
        ArrayList<Game> games = new ArrayList<>();
        for (Game item : gameArrayList){
            String text = item.getTitle().toLowerCase();
            if(text.startsWith(query)){
                games.add(item);
            }
        }
        return games;
    }

}
