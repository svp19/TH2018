package studio19.th2018;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.logging.Level;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout ;
    public ActionBarDrawerToggle drawertoggle ;

    SharedPreferences sharedPreferences ;
    public static final String mypreference = "thpreferences";
    public static final String LevelKey = "LevelUnlockedKey";

    public int LevelUnlocked ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displaySelectedScreen(R.id.nav_clues);

        // Find the toolbar view inside the activity layout
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("TH 2018| IIT DHARWAD");
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);

        //change menu home button with icon
        ActionBar actionbar = getSupportActionBar() ;
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        //Get app data stored in previous session -> LevelUnlocked
        sharedPreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        if (sharedPreferences.contains(LevelKey)) {
            LevelUnlocked = sharedPreferences.getInt(LevelKey, 1);
        }
        else
            LevelUnlocked = 1 ;



        //set up the Navigation Drawer and handle on click
        mDrawerLayout = findViewById(R.id.drawerLayout) ;
        drawertoggle = new ActionBarDrawerToggle(this ,mDrawerLayout ,toolbar ,R.string.navigation_drawer_open , R.string.navigation_drawer_close) ;
        mDrawerLayout.addDrawerListener(drawertoggle) ;
        drawertoggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener(){
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem){
                        //set item as selected
                        menuItem.setChecked(true) ;
                        //close drawer when item tapped
                        mDrawerLayout.closeDrawers();
                        //update UI here
                        displaySelectedScreen(menuItem.getItemId());
                        switch(menuItem.getItemId()){
                            case R.id.nav_clues :
                                toolbar.setTitle("TH 2018 | CLUES");

                                break ;
                            case R.id.nav_map:
                                toolbar.setTitle("TH 2018 | MAP"); ;
                                break ;
                            case R.id.nav_scan:
                                toolbar.setTitle("TH 2018 | SCAN");
                                break ;
                        }
                        return true ;
                    }
                }) ;

    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {

        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawertoggle.syncState();

    }



    @Override
    public void onConfigurationChanged(Configuration newConfig) {

        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawertoggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home :
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true ;
        }
        return super.onOptionsItemSelected(item) ;
    }

    // Menu icons are inflated just as they were with actionbar
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }*/

    //onclick button clue1 open clue1 activity
    public void onClickbuttonclue1(View view){
        Intent intent  = new Intent( this , clue1.class) ;
        intent.putExtra("int" , 1) ;
        startActivity(intent);
    }
    //onclick button clue2 open clue2 activity
    public void onClickbuttonclue2(View view){
        Intent intent  = new Intent( this , clue1.class) ;
        intent.putExtra("int" , 2) ;
        startActivity(intent);
    }
    //onclick button clue3 open clue3 activity
    public void onClickbuttonclue3(View view){
        Intent intent  = new Intent( this , clue1.class) ;
        intent.putExtra("int" , 3) ;
        startActivity(intent);
    }
    public void onClickbuttonclue4(View view){
        Intent intent  = new Intent( this , clue1.class) ;
        intent.putExtra("int" , 4) ;
        startActivity(intent);
    }
    public void onClickbuttonclue5(View view){
        Intent intent  = new Intent( this , clue1.class) ;
        intent.putExtra("int" , 5) ;
        startActivity(intent);
    }
    public void onClickbuttonclue6(View view){
        Intent intent  = new Intent( this , clue1.class) ;
        intent.putExtra("int" , 6) ;
        startActivity(intent);
    }
    public void onClickbuttonclue7(View view){
        Intent intent  = new Intent( this , clue1.class) ;
        intent.putExtra("int" , 7) ;
        startActivity(intent);
    }
    public void onClickbuttonclue8(View view){
        Intent intent  = new Intent( this , clue1.class) ;
        intent.putExtra("int" , 8) ;
        startActivity(intent);
    }
    public void onClickbuttonscan(View view){
        Intent intent  = new Intent( this , QRScanActivity  .class) ;
        startActivity(intent);
    }

    private void displaySelectedScreen(int itemId){

        Fragment fragment = null ;

        switch (itemId){
            case R.id.nav_clues :
                fragment = new fragment_clues();
                break ;
            case R.id.nav_map:
                fragment = new fragment_map() ;
                break ;
            case R.id.nav_scan:
                fragment = new fragment_scan() ;
                break ;
        }

        if(fragment != null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction() ;
            ft.replace(R.id.content_frame, fragment) ;
            ft.commit() ;

        }



    }

    //Save and Load int LevelUnlocked Variable in memory


    public void SaveInt(String key, int value){
        sharedPreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }
    public int LoadInt(String skey , int defval){
        sharedPreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(skey, defval);
    }


}

