package android.wk.com.revit.homeFiles;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.wk.com.revit.DataModels.Game;
import android.wk.com.revit.R;
import android.wk.com.revit.homeFiles.Adapter.childRVAdapter;
import android.wk.com.revit.homeFiles.Adapter.parentRVAdapter;

import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private ArrayList<Integer> carouselImage = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        //Carousel
        CarouselView carouselView = view.findViewById(R.id.carousel);
        carouselImage.add(R.drawable.hyper_light_wallpaper);
        carouselImage.add(R.drawable.hollow_knight_wallpaper);
        carouselImage.add(R.drawable.rf_wallpaper);

        carouselView.setPageCount(carouselImage.size());
        carouselView.setImageListener(imageListener);

        //Recycler
        RecyclerView recyclerView = view.findViewById(R.id.recyclerParent);
        parentRVAdapter parentRVAdapter = new parentRVAdapter(addGame(),this.getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL,false);

        recyclerView.setAdapter(parentRVAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);

        return view;
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            Picasso.with(imageView.getContext()).load(carouselImage.get(position)).resize(1500,800).into(imageView);
        }
    };

    private ArrayList<Game> addGame(){
        ArrayList<Game> games = new ArrayList<>();
        games.add(new Game("Action",R.drawable.hollow_knight_icon,R.drawable.hollow_knight_wallpaper,"Hollow Knight",0,0));
        games.add(new Game("Simulator",R.drawable.stardew_icon,R.drawable.stardew_wallpaper,"Stardew Valley",0,0));
        games.add(new Game("Strategy",R.drawable.shadow_tactics_icon,R.drawable.shadow_tactics_wallpaper,"Shadow Tactics",0,0));
        games.add(new Game("Simulator",R.drawable.rf_icon,R.drawable.rf_wallpaper,"Rune Factory 4",0,0));
        games.add(new Game("Strategy",R.drawable.atlas_icon,R.drawable.atlas_wallpaper,"Atlas Reactor",0,0));
        games.add(new Game("Action",R.drawable.hyper_light_icon,R.drawable.hyper_light_wallpaper,"Hyper Light",0,0));

        return games;
    }

}