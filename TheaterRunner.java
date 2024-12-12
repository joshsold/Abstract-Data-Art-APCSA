import org.code.theater.*;

public class TheaterRunner {
  public static void main(String[] args) {

    /*
     MY PARTNER IS ARMAN H P2
    */

    // Create the 1D arrays to sort through data
    String[] Major = FileReader.toStringArray("Major.txt");
    String[] MajorCategory = FileReader.toStringArray("MajorCategory.txt");
    double[] UnemploymentRate = FileReader.toDoubleArray("UnemploymentRate.txt");
    int[] Median = FileReader.toIntArray("Median.txt");


    // Create the dataScene object to sort through and execute code for the data
    DataScene jobs = new DataScene(Major, MajorCategory, UnemploymentRate, Median);


    // Draw and show the data representation
    jobs.drawResults();
    Theater.playScenes(jobs);
  }
}