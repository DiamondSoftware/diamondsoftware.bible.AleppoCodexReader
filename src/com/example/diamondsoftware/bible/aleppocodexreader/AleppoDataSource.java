package com.example.diamondsoftware.bible.aleppocodexreader;
/*
 * Code by M Robertson, UK 2013
 * maracx@gmail.com
 */


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class AleppoDataSource {

	
  // Database fields
  private SQLiteDatabase database;
  private MySQLiteHelper dbHelper;
  private String[] allColumns = { 
		  MySQLiteHelper.COLUMN_ID,
		  MySQLiteHelper.COLUMN_VERSE };

  String databaseFileName;
  
  public AleppoDataSource(Context context, String dbFileName) 
  {
	  this.databaseFileName = dbFileName;
	  dbHelper = new MySQLiteHelper(context, databaseFileName);
  
  //new
    try {	 
    		dbHelper.createDataBase();
    	 
    	} 
    	catch (IOException ioe) 
    	{    	 
    		throw new Error("Unable to create database");    	 
    	}    	 
  }

  public void open() throws SQLException 
  {	  
  	try 
  	{    	 
  		database = dbHelper.openDataBase(databaseFileName);	 
  	}
  	catch(SQLException sqle)
  	{    	 
  		throw sqle;    	 
  	}
  }

  public void close() {
    dbHelper.close();
  }


    public List<Verse> getAllVerses() {
    List<Verse> verses = new ArrayList<Verse>();

    String book_id = new String("6");
    Cursor cursor = database.rawQuery("SELECT " + MySQLiteHelper.COLUMN_ID  + "," +   MySQLiteHelper.COLUMN_VERSE
    + " FROM " + MySQLiteHelper.TABLE_VERSES + " WHERE book_id = ?", new String[] {book_id});
           
    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
      Verse verse = cursorToVerse(cursor);
      verses.add(verse);
      cursor.moveToNext();
    }
    // Make sure to close the cursor
    cursor.close();
    return verses;
  }

  private Verse cursorToVerse(Cursor cursor) {
    Verse verse = new Verse();
    verse.setId(cursor.getLong(0));
    verse.setVerse(cursor.getString(1));
    return verse;
  }
} 