import java.io.*;
import java.util.Arrays;
public class ReadFile
{
    public static int[][] main()throws IOException
    {
        File fil = new File("booking.txt");
        FileReader inputFil = new FileReader(fil);
        BufferedReader in = new BufferedReader(inputFil);
        String s = in.readLine();
        int i = 0,j,c=0,tall[]=new int[300];
        int dt[][]=new int[30][10];
        while (s != null) {
            // Skip empty lines.
            s = s.trim();
            if (s.length() == 0) {
                continue;
            }
            tall[i] = Integer.parseInt(s); // This is line 19.
            s = in.readLine();
            i++;
        }
        for(i=0;i<30;i++)
        {
            for(j=0;j<10;j++)
            {
                dt[i][j]=tall[c];
                c++;
            }
        }
        return dt;
    }
}
