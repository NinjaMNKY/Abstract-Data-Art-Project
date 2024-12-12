import org.code.theater.*;
import org.code.media.*;
/**
 * Represents a Person with a name and age
 */
public class Album {

  private String title;     // title of the album
  private String artist; //artist who made it 
  private String genre; // genre of the album 
  private int year;         // year it was released

  /** Constructor */
  public Album( String title, String artist, String genre, int year) {
    this.title = title;
    this.artist = artist;
    this.genre = genre;
    this.year = year;
  }

  /**
  *Accessor Method for title
  */
  public String getTitle() {
    return title;
  }
  /**
  *Accessor Method for artist
  */
  public String getArtist() {
    return artist;
  }
  /**
  *Accessor Method for Genre
  */
  public String getGenre() {
    return genre;
  }
  /**
  Accessor Method for Year 
  */
  public int getYear() {
    return year;
  }
  
 /*
 *To String Method 
 */
  public String toString() {
    return "Album: "+ title + "\nArtist: "+ artist + "\nGenre: "+ genre + "\nYear: "+ year;
  }
  
}