/**
 *  Name: Erick Cantos
 *  Student ID: n01068423
 *  Assignment: 1
 *  Due Date: 09/23/18
 */
package erick.cantos;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class ErickActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erick);
        // Set Actionbar title
        this.setTitle(R.string.title_ErickActivity);
        // REQUEST PERMISSION
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            if (ContextCompat.checkSelfPermission(ErickActivity.this, Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},
                        1);
            }

        }
        // Set camera to this button
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
            }
        });
    }
    /**
     * @param menu - retrieve menu
     * @return - return when menu retrieved
     */
    @Override
    public	boolean onCreateOptionsMenu(Menu menu)	{
        try {
            getMenuInflater().inflate(R.menu.menu,	menu);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return	true;
    }
    /**
     * @param item - is the chosen button that was tapped on
     * @return - return true if a button was tapped on
     */
    public boolean onOptionsItemSelected(MenuItem item)
    {
        try {
            switch	(item.getItemId())
            {
                case	R.id.help:
                    //displayTextView.setText("You selected help!"); - functionality checking
                    //Toast.makeText(ErickActivity.this,"You selected help!",	Toast.LENGTH_SHORT).show();

                    // go to website
                    Intent intent = null;
                    intent	=	new	Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://support.microsoft.com/en-ca"));
                    startActivity(intent);
                            break;

                case	R.id.info:
                    //displayTextView.setText("You selected info!");
                    ///Toast.makeText(ErickActivity.this,"Erick Cantos - ver 1.0",	Toast.LENGTH_SHORT).show();
                    android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(ErickActivity.this).create();
                    alertDialog.setTitle("INFO");
                    alertDialog.setMessage("Erick Cantos - ver 1.0");
                    alertDialog.setButton(android.app.AlertDialog.BUTTON_NEUTRAL, "close",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                    break;

                case	R.id.name:
                    Toast.makeText(ErickActivity.this,"ow",	Toast.LENGTH_SHORT).show();
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    public void goToActivity(View view){
        try {
            Intent myIntent = new Intent(ErickActivity.this, Erick2Activity.class);
            //myIntent.putExtra("key", value); //Optional parameters
            ErickActivity.this.startActivity(myIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
