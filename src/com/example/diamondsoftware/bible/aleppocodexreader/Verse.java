package com.example.diamondsoftware.bible.aleppocodexreader;
/*
 * Code by M Robertson, UK 2013
 * maracx@gmail.com
 */

public class Verse {
		
  private long id;
  private String text;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getVerse() {
    return text;
  }

  public void setVerse(String verse) {
    this.text = verse;
  }

  // Will be used by the ArrayAdapter in the ListView
  @Override
  public String toString() {
    return text;
  }
} 