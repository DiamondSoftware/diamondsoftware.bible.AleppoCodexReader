package com.example.diamondsoftware.bible.aleppocodexreader;
/*
 * Code by M Robertson, UK 2013
 * maracx@gmail.com
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

public class AleppoBookSelectionActivity extends AleppoActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aleppo_book_selection);
		Intent intent = getIntent();
		String value = intent.getStringExtra("book"); //if it's a string you stored.
		Toast t = Toast.makeText(getBaseContext(), value, 10);
		t.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.aleppo, menu);
		return true;
	}

}
