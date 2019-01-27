package studio19.th2018;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import org.json.JSONException;
import org.json.JSONObject;
/*QR CODE FORMAT
    Contents int text format/JSON file :
    {
        "number" : "1/2..8"
    }
 */

public class QRScanActivity extends AppCompatActivity  {

    //View Objects
    private int LevelReached ; // Same val as levelUnlocked in MainActivity

    //qr code scanner object
    private IntentIntegrator qrScan;

    //Accesing SharedPreferences
    SharedPreferences sharedPreferences ;
    public static final String mypreference = "thpreferences";
    public static final String LevelKey = "LevelUnlockedKey" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrscan);

        //intializing scan object
        qrScan = new IntentIntegrator(this);
        //initiating the qr code scan
        qrScan.initiateScan();
    }

    //Getting the scan results
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        //Get LevelReached / Unlocked
        sharedPreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        if (sharedPreferences.contains(LevelKey)) {
            LevelReached = sharedPreferences.getInt(LevelKey, 1);
        }
        else
            LevelReached = 1 ;

        if (result != null) {
            //if qrcode has nothing in it
            if (result.getContents() == null) {
                Toast.makeText(this, "Invalid Code", Toast.LENGTH_LONG).show();
            } else {
                //if qr contains data
                try {
                    //converting the data to json
                    JSONObject obj = new JSONObject(result.getContents());
                    //open corresponding clue activity
                    int resultNum = 1 ;
                    try{
                        //read num from qrdata
                        resultNum = Integer.parseInt(obj.getString("number")) ;
                        Intent mintent ;

                        //Get integer from QR CODE and open clue activity


                        //if code for clue greater then next level scanned
                        if(resultNum > LevelReached + 1){

                            //toast to unlock (levelReached + 1) Level first
                            String string = "First Unlock Level " + Integer.toString(LevelReached+1) +" !";
                            Toast.makeText(this, string, Toast.LENGTH_LONG).show();
                        }
                        else { //NEXT LEVEL UNLOCKED!!
                            //toast saying resultNum level Unlocked!
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            //CHANGE 8/08/18
                            if(LevelReached <= resultNum) {
                                editor.putInt(LevelKey, resultNum);
                                editor.commit();
                            }
                            String string = "Unlocked Level " + obj.getString("number") +" !";
                            Toast.makeText(this, string, Toast.LENGTH_LONG).show();
                            mintent  = new Intent( this , clue1.class) ;
                            mintent.putExtra("int" , resultNum) ;
                            startActivity(mintent);
                        }

                    }
                    catch(NumberFormatException nfe){
                        Intent fintent  = new Intent( this , clue1.class) ;
                        fintent.putExtra("int" , 1) ;
                        startActivity(fintent);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    //if control comes here
                    //that means the encoded format not matches
                    //in this case you can display whatever data is available on the qrcode
                    //to a toast
                    Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
        this.finish();
    }

}