package com.example.diamondsoftware.bible.aleppocodexreader;
/*
 * Code by M Robertson, UK 2013
 * maracx@gmail.com
 */

import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;

public class AleppoBookSelectionActivity extends ListActivity {
	  private AleppoDataSource datasource;
	  ArrayAdapter<Verse> adapter;
	  
	  private String defaultdatabaseFileName = "BibleText.sqlite";
	  List<Verse> values;
	  
	  @Override
	  public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.id_translation_king_james_version:
	      // change the db to the kjv;
	    	datasource.close();
		    datasource = new AleppoDataSource(this, "KJV.sqlite");
		    datasource.open();
		    values = datasource.getAllVerses();
		    adapter = new ArrayAdapter<Verse>(this, android.R.layout.simple_list_item_1, values);
		    setListAdapter(adapter); 		    	
	      break;
	      
	    case R.id.id_translation_aleppo_hebrew:
		      // change the db so the kv;
	    	datasource.close();
		    datasource = new AleppoDataSource(this, "BibleText.sqlite");
		    datasource.open();
		    values = datasource.getAllVerses();
		    adapter = new ArrayAdapter<Verse>(this, android.R.layout.simple_list_item_1, values);
		    setListAdapter(adapter); 		    	
	    	break;

	    case R.id.id_translation_elberfelder:
		      // change the db so the kv;
	    	datasource.close();
		    datasource = new AleppoDataSource(this, "Elberfelder_1905.sqlite");
		    datasource.open();
		    values = datasource.getAllVerses();
		    adapter = new ArrayAdapter<Verse>(this, android.R.layout.simple_list_item_1, values);
		    setListAdapter(adapter); 		    	
	    	break;	      
	    }
	    return super.onOptionsItemSelected(item);
	  }	  
	  
	  @Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.aleppo, menu);
			return true;
		}	  
	  
	  
	  @Override
	  public void onCreate(Bundle savedInstanceState) 
	  {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_aleppo_book_selection);
	    datasource = new AleppoDataSource(this, defaultdatabaseFileName);
	    datasource.open();
	    values = datasource.getAllVerses();
	    adapter = new ArrayAdapter<Verse>(this, android.R.layout.simple_list_item_1, values);
	    setListAdapter(adapter);
	  }

	  public void onClick(View view) 
	  {
		@SuppressWarnings("unchecked")
	    ArrayAdapter<Verse> adapter = (ArrayAdapter<Verse>) getListAdapter();
	     switch (view.getId()) 
	    {   
	     // grab the index and manipulate the image so that the appropriate verse is highlighted on the image

	    }
	    adapter.notifyDataSetChanged();
	  }

	  @Override
	  protected void onResume() {
	    datasource.open();
	    super.onResume();
	  }

	  @Override
	  protected void onPause() {
	    datasource.close();
	    super.onPause();
	  }
	}
