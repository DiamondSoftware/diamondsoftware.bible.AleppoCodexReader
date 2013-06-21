package com.example.diamondsoftware.bible.aleppocodexreader;
/*
 * Code by M Robertson, UK 2013
 * maracx@gmail.com
 */

public class Verse {
		
  private long id;
  private String verse;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getVerse() {
    return verse;
  }

  public void setVerse(String verse) {
    this.verse = verse;
  }

  // Will be used by the ArrayAdapter in the ListView
  @Override
  public String toString() {
    return verse;
  }
} 