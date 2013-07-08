package com.example.diamondsoftware.bible.aleppocodexreader;
/*
 * Code by M Robertson, UK 2013
 * maracx@gmail.com
 */

import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

public class AleppoBookSelectionActivity extends ListActivity {
	  private AleppoDataSource datasource;
	  ArrayAdapter<Verse> adapter;
	  
	  @Override
	  public void onCreate(Bundle savedInstanceState) 
	  {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_aleppo_book_selection);
	    datasource = new AleppoDataSource(this);
	    datasource.open();
	    List<Verse> values = datasource.getAllVerses();
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
