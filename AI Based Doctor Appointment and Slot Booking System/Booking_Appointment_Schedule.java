import java.util.*;
import java.io.*;
public class Booking_Appointment_Schedule
{
    public static void main()throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int i,j,c=0;
        System.out.println("ENTER APPOINTMENT DATE: ");
        String date=sc.next();
        String str="";
        for(i=0;i<date.length();i++)
        {
            char ch=date.charAt(i);
            if(ch=='/')
                break;
            else
                str=str+ch;
        }
        int mt=Integer.parseInt(str);
        int dt[][]=new int[30][10];
        int strdt[]=new int[300];
        for(i=0;i<30;i++)
        {
            for(j=0;j<10;j++)
            {
                dt[i][j]=0;
            }
        }
        ReadFile rf=new ReadFile();
        dt=rf.main();
        System.out.println("SLOT AVAILABLE ON "+date+" : ");
        for(i=0;i<10;i++)
        {
            if(dt[mt-1][i]!=1)
                System.out.println("Slot - "+(i+1));
            else
                System.out.println("Slot - "+(i+1)+" HAS BEEN BOOKED");
        }
        int n=1;
        int slot;
        do
        {
            System.out.println("ENTER SLOT NO. THAT NEEDS TO BE BOOKED");
            slot = sc.nextInt();
            if(dt[mt-1][slot-1]==1)
            {
                System.out.println("THE CURRENT SLOT HAS ALREADY BEEN BOOKED, PLEASE BOOK DIFFERENT SLOT");
                n=0;
            }
            else
                n=1;
        }while(n==0);
        dt[mt-1][slot-1]=1;
        for(i=0;i<30;i++)
        {
            for(j=0;j<10;j++)
            {
                strdt[c]=dt[i][j];
                c++;
            }
        }
        FileWrite fr=new FileWrite();
        try {
            fr.main(strdt);;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }
}   
