import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileWrite {
   public static void main(int arr[]) throws Exception {
      FileWriter writer = new FileWriter("booking.txt");
      int len = arr.length;
      for (int i = 0; i < len; i++) {
         writer.write(arr[i] + "\n");
      }
      writer.close();
      System.out.println("YOUR SLOT HAS BEEN SUCCESSFULLY BOOKED");
   }
}