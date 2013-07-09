package com.example.diamondsoftware.bible.aleppocodexreader;
/*
 * Code by M Robertson, UK 2013
 * maracx@gmail.com
 */

import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class AleppoBookSelectionActivity extends ListActivity {
	  private AleppoDataSource datasource;
	  ArrayAdapter<Verse> adapter;
	  
	  private String defaultdatabaseFileName = "BibleText.sqlite";
	  List<Verse> values;
	  
	  @Override
	  public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.id_translation_king_james_version:
	    	datasource.close();
		    datasource = new AleppoDataSource(this, "KJV.sqlite");
		    datasource.open();
		    values = datasource.getAllVerses();
		    adapter = new ArrayAdapter<Verse>(this, android.R.layout.simple_list_item_1, values);
		    setListAdapter(adapter); 		    	
	      break;
	      
	    case R.id.id_translation_aleppo_hebrew:
	    	datasource.close();
		    datasource = new AleppoDataSource(this, "BibleText.sqlite");
		    datasource.open();
		    values = datasource.getAllVerses();
		    adapter = new ArrayAdapter<Verse>(this, android.R.layout.simple_list_item_1, values);
		    setListAdapter(adapter); 		    	
	    	break;

	    case R.id.id_translation_elberfelder:
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
	  
	  public void onListItemClick(ListView parent, View view, int position, long id)
	    {
			LayoutInflater inflater = (LayoutInflater) this.getSystemService( Context.LAYOUT_INFLATER_SERVICE );			
			View aleppo_view = (View) inflater.inflate(R.layout.activity_aleppo_book_selection, null);				
			final ImageView imageV = (ImageView) aleppo_view.findViewById(R.id.viewer);		
			Log.d("ListView", String.valueOf(position));
		  
			
			  if (position == 0)
		        {
				  // pan the image to the given x,y
				  // ensure the image scale is retained
				  ((AleppoBookViewer) imageV).verseIndexPan(0, 1100, 0, 150); // y is the top not bottom to which we want to move the image
		        }
		        else
								
			if (position == 1)
	        {
				  ((AleppoBookViewer) imageV).verseIndexPan(0, 1100, 0, 270);
	        }
	        else
	        if (position == 2)
	        {
				 ((AleppoBookViewer) imageV).verseIndexPan(0, 1100, 0, 440);
	        }	        	
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
