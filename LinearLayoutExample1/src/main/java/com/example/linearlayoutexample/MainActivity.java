package com.example.linearlayoutexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

	EditText et1 = (EditText) findViewById(R.id.et1);
	EditText et2 = (EditText) findViewById(R.id.et2);
	EditText et3 = (EditText) findViewById(R.id.et3);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button button = (Button) findViewById(R.id.bSend);
		button.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {

				String content = et1.getText().toString();
				String content2 = et2.getText().toString();
				String content3 = et3.getText().toString();

				Toast.makeText(MainActivity.this, content + content2 + content3,	Toast.LENGTH_SHORT).show();
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;

	}
}
