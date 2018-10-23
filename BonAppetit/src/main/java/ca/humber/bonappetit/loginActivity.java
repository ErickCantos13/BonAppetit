/**
 *  Application: Bon Appetit
 *  Team Name: Team Slavick
 */
package ca.humber.bonappetit;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // fix the orientation to portrait only
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    // Register button - onClick
    public void startRegistration(View view) {
        try {
            Intent myIntent = new Intent(loginActivity.this, registrationActivity.class);
            //myIntent.putExtra("key", value); //Optional parameters
            loginActivity.this.startActivity(myIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Login button - onClick
    public void startMenu(View view){
        try{
            Intent myIntent = new Intent(loginActivity.this, menuActivity.class);
            loginActivity.this.startActivity(myIntent);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
