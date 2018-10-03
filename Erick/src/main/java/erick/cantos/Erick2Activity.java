/**
 *  Name: Erick Cantos
 *  Student ID: n01068423
 *  Assignment: 1
 *  Due Date: 09/23/18
 */
package erick.cantos;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DateFormat;
import java.util.Date;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

public class Erick2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_erick2);

            TextView dateTimeDisplay = (TextView)findViewById(R.id.textView4);
            String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
            dateTimeDisplay.setText(currentDateTimeString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Take over up arrow
    @Override
    public	boolean onSupportNavigateUp(){
        try {
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return	true;
    }
    // Portrait - Display custom toast message
    public void makeToast(View view){
        try {
            Toast.makeText(Erick2Activity.this,"Bread is toasted",	Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Change to alternate landscape XML layout
    @Override
    public void onConfigurationChanged(Configuration newConfig){
        try {
            super.onConfigurationChanged(newConfig);
            setContentView(R.layout.activity_erick2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Landscape - Display toast message
    public void displayMessage(View view){
        try {
            Toast.makeText(Erick2Activity.this,"This is a message",	Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Landscape - Dial Phone button
    public void dialPhone(View view){
        try {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:0123456789")); // pre-set phone #
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Landscape - Home screen button
    public void homeScreen(View view){
        try {
            Intent intent = new Intent(Erick2Activity.this, ErickActivity.class);
            // Reset to th beginning of the activity sequence
            intent.setFlags(FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
