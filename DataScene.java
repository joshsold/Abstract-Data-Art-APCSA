import org.code.theater.*;

public class DataScene extends Scene {


  // Instance Variables
  private String[] Major;
  private String[] MajorCategory;
  private double[] UnemploymentRate;
  private int[] Median;


  // Parameterized Constructor
  public DataScene(String[] Major, String[] MajorCategory, double[] UnemploymentRate, int[] Median) {
    this.Major = Major;
    this.MajorCategory = MajorCategory;
    this.UnemploymentRate = UnemploymentRate;
    this.Median = Median;
  }

  // Round rates to the nearest hundreths place, uses a two way selection sequence to round up or down using floor or ceil functions
  public double[] convertRates(double[] Rate) {
    double[] newRates = new double[Rate.length];

    for (int i = 0; i < newRates.length; i++) {
      double j = Rate[i];
      j *= 10000;
      int nj = (int) j;

      if((j - nj) >= 0.5) {
        j = Math.ceil(j);
      } else {
        j = Math.floor(j);
      }

      j /= 100;
      newRates[i] = j;
      
    }

    return newRates;
  }


  // Find the highest pay in the Median text file/array
  public int findHighestPay() {
    int pay = 0;
    for(int i = 0; i < Median.length; i++) {
      pay = Math.max(pay, Median[i]);
    }
    return pay;
  }

  // Find the major that has the highest median pay
  public String findHighestPayJob() {
    int pay = findHighestPay();
    for (int i = 0; i < Major.length; i++) {
      if(Median[i] == pay) {
        return Major[i];
      }
    }
    return null;
  }


  // Find the lowest umeployment rate in the Unemployment Rate text file/array
  public double findLowestUnemploy() {
    double[] newRates = convertRates(UnemploymentRate);
    double lowestRate = Integer.MAX_VALUE;
    for (int i = 0; i < newRates.length; i++) {
      lowestRate = Math.min(lowestRate, newRates[i]);
    }

    return lowestRate;
  }

  
  // Find the job with the lowest umeployment rate
  public String findLowestUnemployJob() {
    double lowestRate = findLowestUnemploy();

    for (int i = 0; i < Major.length; i++) {
      if(UnemploymentRate[i] == lowestRate) {
        return Major[i];
      }
    }
    return null;
  }


  // Find the major category a specific major belongs to
  public String findJobCat(String major) {
    for (int i = 0; i < Major.length; i++) {
      if (Major[i] == major) {
        return MajorCategory[i];
      }
    }
    return null;
  }


  // Display data using text, images, and sounds, shows jobs with the most pay and the least unemployment
  public void drawResults() {
    setTextHeight(18);
    int size = (int) (Math.random() * 230) + 20;
    drawText("The major with highest median pay is " + "$" + findHighestPay(), 15, 40);
    drawText("This major is " + findHighestPayJob(), 40, 80);
    drawText("This major is in the " + findJobCat(findHighestPayJob()) + " category", 20, 120);
    drawImage("money.jpg", 100, 200, size);
    playSound("kaching.wav");
    pause(5);
    clear("white");
    setTextHeight(15);
    size = (int) (Math.random() * 240) + 30;
    drawText("The major with the lowest unemployment is " + findLowestUnemploy(), 15, 40);
    drawText("This major is " + findLowestUnemployJob(), 40, 80);
    drawText("This major is in the " + findJobCat(findLowestUnemployJob()) + " category", 20, 120);
    drawImage("unemployment.png", 100, 200, size);
    playSound("yay.wav");
  }
}