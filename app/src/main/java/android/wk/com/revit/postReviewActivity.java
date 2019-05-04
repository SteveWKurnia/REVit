package android.wk.com.revit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.wk.com.revit.DataModels.Game;
import android.wk.com.revit.DataModels.Review;
import android.wk.com.revit.DataModels.User;

import java.util.ArrayList;

import static android.wk.com.revit.MainActivity.user;

public class postReviewActivity extends AppCompatActivity {

    Game game;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.post_review_layout);
        getIncomingIntent();

        Toolbar toolbar = findViewById(R.id.postReviewToolbar);
        setSupportActionBar(toolbar);

        final EditText editText = findViewById(R.id.userReview);
        Button button = findViewById(R.id.postButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!TextUtils.isEmpty(editText.getText())) {
                    Review review = new Review(new ArrayList<User>(), new ArrayList<User>(), user, editText.getText().toString());

                    ArrayList<Review> userReviewTemp = user.getRecentReview();
                    Log.d("NewLog","Does this work?");
                    userReviewTemp.add(review);
                    Log.d("NewLog","Will this work?");
                    user.setRecentReview(userReviewTemp);

                    ArrayList<Review> reviews = game.getReviews();
                    Log.d("NewLog","Does this work?");
                    reviews.add(review);
                    Log.d("NewLog","Will this work?");
                    game.setReviews(reviews);

                    finish();
                }
                else{
                    Toast.makeText(postReviewActivity.this,"Please fill in your comments first.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    void getIncomingIntent(){
        Intent intent = getIntent();

        if (intent.hasExtra("gameBundle")) {
            Bundle bundle = intent.getBundleExtra("gameBundle");
            game = (Game)bundle.getSerializable("gameArray");
            Log.d("NewLog","Game exists!");
        }
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



}
