package studio19.th2018;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NavUtils;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class clue1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clue1);
        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("TH 2018| CLUE");
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);
        //change menu home button with back icon
        ActionBar actionbar = getSupportActionBar() ;
        if(actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        }
        //get intent and read clue number passed
        int number = getIntent().getIntExtra("int" , 1) ;
        //settext of layout according to clue number
        TextView textView ;
        textView = findViewById(R.id.clue_activity_title) ;

        switch(number){
            case 1 :
                textView.setText(R.string.title_clue1_label);
                textView = findViewById(R.id.clue_activity_description);
                textView.setText(R.string.description_clue1);
                break ;
            case 2 :
                textView.setText(R.string.title_clue2_label);
                textView = findViewById(R.id.clue_activity_description);
                textView.setText(R.string.description_clue2);
                break ;
            case 3 :
                textView.setText(R.string.title_clue3_label);
                textView = findViewById(R.id.clue_activity_description);
                textView.setText(R.string.description_clue3);
                break ;
            case 4:
                textView.setText(R.string.title_clue4_label);
                textView = findViewById(R.id.clue_activity_description);
                textView.setText(R.string.description_clue4);
                break ;
            case 5:
                textView.setText(R.string.title_clue5_label);
                textView = findViewById(R.id.clue_activity_description);
                textView.setText(R.string.description_clue5);
                break ;
            case 6:
                textView.setText(R.string.title_clue6_label);
                textView = findViewById(R.id.clue_activity_description);
                textView.setText(R.string.description_clue6);
                break ;
            case 7:
                textView.setText(R.string.title_clue7_label);
                textView = findViewById(R.id.clue_activity_description);
                textView.setText(R.string.description_clue7);
                break ;
            case 8:
                textView.setText(R.string.title_clue8_label);
                textView = findViewById(R.id.clue_activity_description);
                textView.setText(R.string.description_clue8);
                break ;
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish() ;
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

