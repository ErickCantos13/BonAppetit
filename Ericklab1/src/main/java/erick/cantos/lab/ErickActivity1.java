/**
 *  Name: Erick Cantos
 *  Student ID: n01068423
 *  Lab: 1
 *  Due Date: 09/25/18 @9PM
 */
package erick.cantos.lab;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
//import android.content.pm.ActivityInfo;

public class ErickActivity1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erick1);

        // Lock to portrait mode
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

         final TextView text = (TextView) findViewById(R.id.textView2);
         text.setText("STATUS");

        // Set camera to this button
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkPermission()) {
                    text.setText("ALLOW + ERICK");
                    // toast permission already granted
                    Toast.makeText(ErickActivity1.this,"Permission already granted",	Toast.LENGTH_SHORT).show();
                }
                else{
                    text.setText("DENY + ERICK");
                    // Request permission
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        if (ContextCompat.checkSelfPermission(ErickActivity1.this, Manifest.permission.ACCESS_FINE_LOCATION)
                                != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(ErickActivity1.this,
                                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                    1);

                        }
                    }
                }

            }

        });
        // I attempted to change the STATUS when button clicked but it ony changes
        // once checked again, not right away.
        if(checkPermission()){text.setText("ALLOW + ERICK");}

    }

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), ACCESS_FINE_LOCATION);
        return result == PackageManager.PERMISSION_GRANTED;
    }

}
