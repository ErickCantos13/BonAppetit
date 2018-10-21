/**
 *  Name: Erick Cantos
 *  Student ID: N01068423
 *  Assignment: 2
 *  Due Date: 10/14/18
 */
package erick.cantos;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ErickActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erick1);

        // fix the orientation to portrait only
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Validate radio button to go to second Activity
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioGroup group = (RadioGroup) findViewById(R.id.RadioGroup01);
                if (group.getCheckedRadioButtonId() == -1)
                {
                    // no radio buttons are checked
                    Toast.makeText(ErickActivity1.this, "No option selected",	Toast.LENGTH_SHORT).show();
                }
                else
                {
                    // one of the radio buttons is checked
                    // Radio button detection
                    group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId){
                            if (checkedId != -1) {
                                RadioButton rb = (RadioButton)
                                        findViewById(checkedId);
                                // Redirection to the selected pizza shop
                                //if (rb != null) {
                                    if(rb.getText().toString().equalsIgnoreCase("Dominos Pizza")) {
                                        Intent myIntent = new Intent(ErickActivity1.this, ErickActivity2.class);
                                        ErickActivity1.this.startActivity(myIntent);
                                    }
                                    else if(rb.getText().toString().equalsIgnoreCase("Pizza Hut")) {
                                        Intent myIntent = new Intent(ErickActivity1.this, ErickActivity3.class);
                                        ErickActivity1.this.startActivity(myIntent);
                                    }
                                    else if(rb.getText().toString().equalsIgnoreCase("Pizza Pizza")) {
                                        Intent myIntent = new Intent(ErickActivity1.this, ErickActivity4.class);
                                        ErickActivity1.this.startActivity(myIntent);
                                    }

                                //}
                            }
                        }
                    });
                }
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
                    // go to website
                    Intent intent = null;
                    intent	=	new	Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.dominos.ca/pages/order/menu.jsp?#/menu/category/all/"));
                    startActivity(intent);
                    break;

                case	R.id.pizza:
                    // go to website
                    Intent intent2 = null;
                    intent2	=	new	Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.dominos.ca"));
                    startActivity(intent2);
                    break;

                case	R.id.name:
                    Toast.makeText(ErickActivity1.this,"ow",	Toast.LENGTH_SHORT).show();
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
