package com.example.diamondsoftware.bible.aleppocodexreader;
/*
 * Code by M Robertson, UK 2013
 * maracx@gmail.com
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteException;
import android.util.Log;

@SuppressLint("SdCardPath")
public class MySQLiteHelper extends SQLiteOpenHelper {

  public static final String TABLE_VERSES = "verse";
  public static final String COLUMN_ID = "_id";
  public static final String COLUMN_VERSE = "text";

  //private static String DATABASE_NAME = "BibleText.sqlite";
  
  //private static String DATABASE_NAME = "KJV.sqlite";
  
  private static final int DATABASE_VERSION = 1;
  private static String DATABASE_PATH = "/data/data/com.example.diamondsoftware.bible.aleppocodexreader/databases/";
  private SQLiteDatabase myDataBase; 
  private final Context myContext;
  
  private String databaseFileName;
  
  
  /**
   * Constructor
   * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
   * @param context
   */
  public MySQLiteHelper(Context context, String dbFileName) 
 {
   super(context, dbFileName, null, DATABASE_VERSION);
   this.databaseFileName = dbFileName;
   this.myContext = context;
 }
  
  
 /**
  * Creates a empty database on the system and rewrites it with your own database.
  * */
public void createDataBase() throws IOException
{		
	//By calling this method and empty database will be created into the default system path
	//of your application so we will be able to overwrite that database with our database.
		this.getReadableDatabase();
		try 
		{
			copyDataBase();
		} 
		catch (IOException e) 
		{
			throw new Error("Error copying database");
		}
 	}
 
/**
 * Copies your database from your local assets-folder to the just created empty database in the
 * system folder, from where it can be accessed and handled.
 * This is done by transfering bytestream.
 * */
private void copyDataBase() throws IOException{

	//Open your local db as the input stream
	InputStream myInput = myContext.getAssets().open(databaseFileName);

	//Path to the just created empty db
	String outFileName = DATABASE_PATH + databaseFileName;

	//Open the empty db as the output stream
	OutputStream myOutput = new FileOutputStream(outFileName);

	//transfer bytes from the inputfile to the outputfile
	byte[] buffer = new byte[1024];
	int length;
	while ((length = myInput.read(buffer))>0)
	{
		myOutput.write(buffer, 0, length);
	}

	//Close the streams
	myOutput.flush();
	myOutput.close();
	myInput.close();

}
 

public SQLiteDatabase openDataBase(String databaseFileName) throws SQLException
{
 	//Open the database
	String myPath = DATABASE_PATH + databaseFileName;
	myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
	return myDataBase;
}

	 
@Override
public synchronized void close() 
{
	if(myDataBase != null)
	myDataBase.close();	 
	super.close();
}
	 


  
  @Override
  public void onCreate(SQLiteDatabase database) {
    //database.execSQL(DATABASE_CREATE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    Log.w(MySQLiteHelper.class.getName(),
        "Upgrading database from version " + oldVersion + " to "
            + newVersion + ", which will destroy all old data");
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_VERSES);
    onCreate(db);
  }

} 