package android.wk.com.revit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;
import android.wk.com.revit.DataModels.Game;

import com.squareup.picasso.Picasso;

public class gameActivity extends AppCompatActivity {

    Game game;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
        Log.d("MyTag", "Getting incoming intent!");

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbarGame);
        setSupportActionBar(toolbar);

        getIncomingIntent();

        ImageView thumbsUp = findViewById(R.id.thumbsUp);
        ImageView thumbsDown = findViewById(R.id.thumbsDown);
        FloatingActionButton floatingActionButton = findViewById(R.id.fab);

        thumbsUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Liked",Toast.LENGTH_SHORT).show();
                Integer currentLike = game.getLikeCount() + 1;
                game.setLikeCount(currentLike);
            }
        });
        thumbsDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Disliked",Toast.LENGTH_SHORT).show();
                Integer currentLike = game.getDislikeCount() + 1;
                game.setDislikeCount(currentLike);
            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(gameActivity.this, postReviewActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("gameArray",game);
                intent.putExtra("gameBundle",bundle);
                gameActivity.this.startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_action_bar_game,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Integer id = item.getItemId();

        if (id == R.id.action_bar_back){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void getIncomingIntent(){
        if (getIntent().hasExtra("gameBundle")){
            game = (Game) getIntent().getBundleExtra("gameBundle").getSerializable("gameArray");
            Log.d("MyTag", "Setting data!");
            setData();
        }
    }

    public void setData(){
        TextView gamePageTitle = findViewById(R.id.gamePageTitle);
        ImageView gamePageImage = findViewById(R.id.gamePageImage);
        FloatingActionButton floatingActionButton = findViewById(R.id.fab);

        Bundle bundle = new Bundle();
        bundle.putSerializable("gameArray", game);

        floatingActionButton.show();
        gamePageTitle.setText(game.getTitle());
        Picasso.with(this).load(game.getGamePoster()).resize(1920,400).into(gamePageImage);
    }
}
