package android.wk.com.revit;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.wk.com.revit.DataModels.Game;
import android.wk.com.revit.DataModels.Review;
import android.wk.com.revit.DataModels.User;
import android.wk.com.revit.accountFiles.AccountFragment;
import android.wk.com.revit.homeFiles.HomeFragment;
import android.wk.com.revit.searchFiles.Adapter.searchAdapter;
import android.wk.com.revit.searchFiles.SearchFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static SearchView searchViewPublic;
    public static User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = new User("SWK","Stephen WK",R.drawable.stardew_icon,"steve@some.com", new ArrayList<Review>());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loadFragment(new HomeFragment());
    }

    private boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment,fragment)
                    .commit();
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Integer id = item.getItemId();
        Fragment fragment = null;

        if(id == R.id.action_bar_home){
            fragment = new HomeFragment();
            if (searchViewPublic != null) {
                searchViewPublic.setIconified(true);
                searchViewPublic.setLayoutParams(new Toolbar.LayoutParams(Gravity.END));
            }
        }
        else if(id == R.id.action_bar_search){
            fragment = new SearchFragment();
            searchViewPublic = (SearchView) item.getActionView();
        }
        else if(id == R.id.action_bar_account){
            fragment = new AccountFragment();
            if (searchViewPublic != null) {
                searchViewPublic.setIconified(true);
            }
        }
        loadFragment(fragment);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_action_bar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    break;
                case R.id.navigation_search:
                    fragment = new SearchFragment();
                    break;
                case R.id.navigation_account:
                    fragment = new AccountFragment();
                    break;
            }
            return loadFragment(fragment);
        }
    };
}
