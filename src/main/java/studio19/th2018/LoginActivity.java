package studio19.th2018;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences ;
    public static final String mypreference = "thpreferences";
    public static final String login_valid = "loginvalid";
    public int loginval ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        if (sharedPreferences.contains(login_valid)) {
            loginval = sharedPreferences.getInt(login_valid, 1);
        }
        else
            loginval = 1 ;
        if( loginval == getApplicationContext().getResources().getInteger(R.integer.loginkey) ){
            Intent intent = new Intent(this, MainActivity.class) ;
            startActivity(intent);
            finish() ;
        }

    }

    public void onClicklogin(View view){

        EditText editText = findViewById(R.id.editTextPassword);
        String cryp = editText.getText().toString() ;
        if(!validate(cryp)){
            Toast.makeText(this, "Lets Play!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class) ;
            startActivity(intent);
            finish() ;
        }
        else
            Toast.makeText(this, "Invalid Password!", Toast.LENGTH_LONG).show();
    }

    public boolean validate(String str){

        if(str.isEmpty())
            return true ;
        if(str.toLowerCase().equals("pass1234"))
            return true ;
        int x = 943 ;
        try {
            x = Integer.parseInt(str);
        }catch (NumberFormatException nfe){
            return true ;
        }
        if(x>9999) return true ;
        int t = x , p=8 , i ;
        int[] d=new int[] {0,0,0,0,0,0,0,0,0} ; int[] h=new int[]{1,2,4,6};
        for(i=1;i<=4;i++){
            t = h[i-1]*x ;
            while(t!=0){
                d[(t%10)-1]++ ;
                t /= 10 ;
            }
        }
        while(p!=0){
            if(d[p]!=2)
                return true ;
            p--;

        }
        sharedPreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(login_valid, getApplicationContext().getResources().getInteger(R.integer.loginkey));
        editor.commit();
        return false ;
    }
}
