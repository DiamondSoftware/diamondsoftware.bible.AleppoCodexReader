package com.example.diamondsoftware.bible.aleppocodexreader;
/*
 * Code by M Robertson, UK 2013
 * maracx@gmail.com
 */

import android.os.Bundle;
import android.view.Menu;

public class AleppoHelpActivity extends AleppoActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aleppo_help);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.aleppo, menu);
		return true;
	}

}
