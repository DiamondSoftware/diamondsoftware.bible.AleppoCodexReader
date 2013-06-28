package com.example.diamondsoftware.bible.aleppocodexreader;
/*
 * Code by M Robertson, UK 2013
 * maracx@gmail.com
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class AleppoMainMenuActivity extends AleppoActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aleppo_main_menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.aleppo, menu);
		return true;
	}

	public void callBookSelection(View view) {		
		Intent myIntent = new Intent(AleppoMainMenuActivity.this, AleppoBookSelectionActivity.class);
		myIntent.putExtra("book","joshua"); 
		AleppoMainMenuActivity.this.startActivity(myIntent);		
	 }

}
