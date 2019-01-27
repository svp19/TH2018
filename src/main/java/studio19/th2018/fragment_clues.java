package studio19.th2018;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class fragment_clues extends Fragment {


    public int mlevel ;
    SharedPreferences sharedPreferences ;
    public static final String mypreference = "thpreferences";
    public static final String LevelKey = "LevelUnlockedKey";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.fragment_clues, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("TH 2018 | CLUES");

        //mlevel get
        sharedPreferences = this.getActivity().getSharedPreferences(mypreference , Context.MODE_PRIVATE ) ;
        if (sharedPreferences.contains(LevelKey)) {
            mlevel = sharedPreferences.getInt(LevelKey, 1);
        }
        else
            mlevel = 1 ;
        //public void UpdateClueButtonState( int mlevel ) -> Setting Clue buttons as enabled
            Button ClueButton = view.findViewById(R.id.button_clue_1) ;
            ClueButton.setEnabled(true);
            if(mlevel >= 2){
                ClueButton = view.findViewById(R.id.button_clue_2) ;
                ClueButton.setEnabled(true);
            }if(mlevel >= 3){
                ClueButton = view.findViewById(R.id.button_clue_3) ;
                ClueButton.setEnabled(true);
            }if(mlevel >= 4){
                ClueButton = view.findViewById(R.id.button_clue_4) ;
                ClueButton.setEnabled(true);
            }if(mlevel >= 5){
                ClueButton = view.findViewById(R.id.button_clue_5) ;
                ClueButton.setEnabled(true);
            }if(mlevel >= 6){
                ClueButton = view.findViewById(R.id.button_clue_6) ;
                ClueButton.setEnabled(true);
            }if(mlevel >= 7){
                ClueButton = view.findViewById(R.id.button_clue_7) ;
                ClueButton.setEnabled(true);
            }if(mlevel >= 8){
                ClueButton = view.findViewById(R.id.button_clue_8) ;
                ClueButton.setEnabled(true);
            }
    }

}