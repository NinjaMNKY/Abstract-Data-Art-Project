import org.code.theater.*;
import org.code.media.*;

/**
 * Represents a Scene to be played in the Theater using data from
 * a chosen dataset
 */
public class DataScene extends Scene {

    private Album[] albums; // 1D array of Album objects

    /** Constructor */
    public DataScene() {
        albums = createAlbums();
    }

    /**
     * Returns a 1D array of Album objects using the txt files in this project
     */
    public Album[] createAlbums() {
        String[] titleArray = FileReader.toStringArray("title.txt");
        String[] artistArray = FileReader.toStringArray("artist.txt");
        String[] genreArray = FileReader.toStringArray("genre.txt");
        int[] yearArray = FileReader.toIntArray("year.txt");

        Album[] tempArray = new Album[titleArray.length];
        for (int i = 0; i < tempArray.length; i++) {
            tempArray[i] = new Album(titleArray[i], artistArray[i], genreArray[i], yearArray[i]);
        }

        return tempArray;
    }

    /**
     * Counts how many albums were released in each year
     */
    public int findAlbumReleased() {
        int[] uniqueYears = new int[albums.length]; // Array to store unique years
        int[] counts = new int[albums.length]; // Array to store counts for each year
        int uniqueCount = 0; // Counter for the number of unique years

        // Traverse the albums array
        for (Album a : albums) {
            int foundYear = a.getYear();
            boolean isNewYear = true;

            // Check if the year is already in the uniqueYears array
            int index = 0;
        while (index < uniqueCount && uniqueYears[index] != foundYear) {
           index++; 
          }

      if (index < uniqueCount && uniqueYears[index] == foundYear) {
      counts[index]++; 
        isNewYear = false; 
          }

            // If it's a new year, add it to the uniqueYears array
            if (isNewYear) {
                uniqueYears[uniqueCount] = foundYear;
                counts[uniqueCount] = 1; // Initialize the count for this new year
                uniqueCount++;
            }
        }

       // Print the occurrences of each year
        for (int i = 0; i < uniqueCount; i++) {
            if (counts[i] == 1) {
                System.out.println(uniqueYears[i] + " occurs " + counts[i] + " time");
            } else {
                System.out.println(uniqueYears[i] + " occurs " + counts[i] + " times");
            }
        }

        return uniqueCount; // Return the total number of unique years found
    }
       /**
     * Counts how many albums were released in each decade
     */
    public int findDecades() {
       //variables that count each time an ablum appears in that decade
      int fifties = 0;
        int sixties= 0;
        int seventies= 0;
        int eighties= 0;
        int nineties= 0;
        int twoThousands= 0;
        int twentyTens= 0;
 
        // Traverse the albums array
       for (Album a : albums) {
        int year = a.getYear(); // Get the year of the album

        if (year >= 1950 && year < 1960) {
            fifties++;
        } else if (year >= 1960 && year < 1970) {
            sixties++;
        } else if (year >= 1970 && year < 1980) {
            seventies++;
        } else if (year >= 1980 && year < 1990) {
            eighties++;
        } else if (year >= 1990 && year < 2000) {
            nineties++;
        } else if (year >= 2000 && year < 2010) {
            twoThousands++;
        } else if (year >= 2010) {
            twentyTens++;
        }
    }

            return fifties + sixties +seventies + eighties + nineties+ twoThousands +twentyTens;
    }

/*
*Gets a random album and gets all of its data
*/
  public int randomAlbum(){
int randomIndex = (int) (Math.random() * albums.length);

    // Get the random Album object and return its toString representation
    return randomIndex;
      
    }
  
  /*
*Drew the Scene 
*/
  public void drawScene() { 
    //Call findAlbumReleased to count the unique years and print results
    
    // System.out.println("Total unique years: " + uniqueYears+ "\n");
    
    //Call findDecades  and print results
    int albumDecades= findDecades(); 
    // System.out.println("Albums Realeased in each decade: \n" + albumDecades);
   
    //call the randomAlbum and print
    int randomAlbum = randomAlbum();
    // System.out.println("Random album: \n" + randomAlbum);
   
for (int i = 5; i >= 0; i--) {
    clear("white"); // Clear the screen with a white background
    drawText("-----Random Album----- ", 90, 45);
    drawText("Title: "+albums[randomAlbum].getTitle(), 30, 100);
    drawText("Artist: "+ albums[randomAlbum].getArtist(), 30, 150);
    drawText("Genre: "+albums[randomAlbum].getGenre(), 30, 200);
    drawText("Year: "+albums[randomAlbum].getYear()+"", 30, 250);
    setTextColor(Color.BLACK); // Set text color to black for visibility
    drawText(String.valueOf(i), 200, 300); // Draw the current countdown number
    pause(1); // Pause for 1 second
}

    clear("white"); // Clear the screen with a white background
     setTextHeight(20);
  drawText("-----Decades with the Best Albums----- ", 35, 45);
  setTextHeight(15);
  drawText("1950s    1960s    1970s   1980s    1990s    2000s    2010s", 12, 350);
  /*
  * The height of the rectangle is how many albums were in that decade
  */ 
  setFillColor(Color.PINK);
  drawRectangle(15, 325, 30, 10);
  drawText("10", 18, 305);
  
  setFillColor(Color.GREEN);
  drawRectangle(73, 230, 30, 105);
  drawText("105", 73, 210);
  
  setFillColor(Color.BLUE);
  drawRectangle(130, 150, 30, 186);
  drawText("186", 130, 130);
  
  setFillColor(Color.RED);
  drawRectangle(180, 250, 30, 85);
  drawText("85", 185, 230);
  
  setFillColor(Color.YELLOW);
  drawRectangle(235, 263, 30, 72);
  drawText("72", 245, 243);
  
  setFillColor(Color.PURPLE);
  drawRectangle(290, 293, 30, 40);
  drawText("40", 295, 280);
  
  setFillColor(Color.ORANGE);
  drawRectangle(350, 330, 30, 2);
  drawText("2", 360, 310);
  
  setTextHeight(20);
int uniqueYears = findAlbumReleased(); 
  }
}
