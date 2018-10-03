package com.example.radiobuttonexercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CheckBox check_button = (CheckBox) findViewById(R.id.checkbox);
        check_button.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                TextView tv = (TextView)findViewById(R.id.checkbox);
                tv.setText(check_button.isChecked()? "This option is checked ": "This option is not checked");
            }
        });

        // Radio button detection
        RadioGroup group = (RadioGroup) findViewById(R.id.RadioGroup01);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                if (checkedId != -1) {
                    RadioButton rb = (RadioButton)
                            findViewById(checkedId);
                    if (rb != null) {
                        Toast.makeText(MainActivity.this,"You chose: " + rb.getText(),	Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "No option selected",	Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
