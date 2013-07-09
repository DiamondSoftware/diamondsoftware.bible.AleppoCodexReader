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

  public AleppoDataSource(Context context) 
  {
    dbHelper = new MySQLiteHelper(context);
  
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
    //database = dbHelper.getWritableDatabase();
	  
	 //new
  	try 
  	{    	 
  		database = dbHelper.openDataBase();
  	 
  	}
  	catch(SQLException sqle)
  	{    	 
  		throw sqle;    	 
  	}

	  
  
  }

  public void close() {
    dbHelper.close();
  }

  public Verse createVerse(String verse) {
	  
    ContentValues values = new ContentValues();
    values.put(MySQLiteHelper.COLUMN_VERSE, verse);
    long insertId = database.insert(MySQLiteHelper.TABLE_VERSES, null,
        values);
    Cursor cursor = database.query(MySQLiteHelper.TABLE_VERSES,
        allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
        null, null, null);
    cursor.moveToFirst();
    Verse newVerse= cursorToVerse(cursor);
    cursor.close();
    return newVerse;
  }

    public List<Verse> getAllVerses() {
    List<Verse> verses = new ArrayList<Verse>();

    //Cursor cursor = database.query(MySQLiteHelper.TABLE_VERSES,
    	//	allColumns, null, null, null, null, null);
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