/**
 *  Name: Erick Cantos
 *  Student ID: N01068423
 *  Assignment: 2
 *  Due Date: 10/14/18
 */
package erick.cantos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ErickActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erick2);

        // Validate radio button to go to second Activity
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ErickActivity2.this, ErickActivity5.class);
                ErickActivity2.this.startActivity(myIntent);
            }
        });
    }
}
