package com.example.progressbar;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
	private ProgressBar progress;
	private TextView text;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
  
	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		progress = (ProgressBar) findViewById(R.id.progressBar1);
		text = (TextView) findViewById(R.id.textView1);
	}

	public void startProgress(View view) {
		// Do something long
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i <= 10; i++) {
					final int value = i;
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					progress.post(new Runnable() {
						@Override
						public void run() {
							text.setText("Updating");
							progress.setProgress(value);
						}
					});
				}
			}
		};
		new Thread(runnable).start();
	}
} 