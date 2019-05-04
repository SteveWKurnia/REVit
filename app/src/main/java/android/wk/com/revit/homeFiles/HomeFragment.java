package android.wk.com.revit.homeFiles;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import android.wk.com.revit.DataModels.Game;
import android.wk.com.revit.DataModels.Review;
import android.wk.com.revit.R;
import android.wk.com.revit.gameActivity;
import android.wk.com.revit.homeFiles.Adapter.childRVAdapter;
import android.wk.com.revit.homeFiles.Adapter.parentRVAdapter;

import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private ArrayList<Game> games = addGame();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        //Carousel
        CarouselView carouselView = view.findViewById(R.id.carousel);

        carouselView.setPageCount(3);
        carouselView.setImageListener(imageListener);
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getContext(), gameActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("gameArray",games.get(position));
                intent.putExtra("gameBundle", bundle);
//                intent.putExtra("gamePageTitle", games.get(position).getTitle());
//                intent.putExtra("gamePageImage", games.get(position).getGamePoster());
                Log.d("MyTag", "Putting extra!");
                getContext().startActivity(intent);
                Log.d("MyTag", "Starting intent!");
            }
        });

        //Recycler
        RecyclerView recyclerView = view.findViewById(R.id.recyclerParent);
        parentRVAdapter parentRVAdapter = new parentRVAdapter(games,this.getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL,false);

        recyclerView.setAdapter(parentRVAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);

        return view;
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            Picasso.with(imageView.getContext()).load(games.get(position).getGamePoster()).resize(1500,800).into(imageView);
        }
    };

    private ArrayList<Game> addGame(){
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

}
