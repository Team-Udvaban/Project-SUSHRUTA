import java.util.*;
public class Sushruta_DoctorAppointment_AI
{
    void main(String symp)
    {
        Scanner sc=new Scanner(System.in);
        int i,j,l=symp.length(),c=0;
        String wd="";
        for(i=0;i<l;i++)
        {
            if(symp.charAt(i)==',')
                c++;
        }
        String str[]=new String[++c];
        symp=symp+",";
        System.out.println(symp);
        c=0;
        for(i=0;i<=l;i++)
        {
            if(symp.charAt(i)==',')
            {
                str[c]=wd;
                c++;
                wd="";
            }
            else
            {
                wd=wd+symp.charAt(i);
            }
        }
        int dis[]={0,0,0,0,0,0,0};//ent=0,eye=1,orth=2,gas=3,nerv=4,card=5,derm=6;
        String dc[]={"Ent Specialist","Ophthalmologist","Orthopedist","Gastroenterologist","Neurologist","Cardiologist","Dermatologist"};
        for(i=0;i<c;i++)
        {
            if(str[i].equalsIgnoreCase("fever"))
            {    
                dis[0]++;
            }
            if(str[i].equalsIgnoreCase("head ache"))
            {
                dis[0]++;
                dis[1]++;
            }
            if(str[i].equalsIgnoreCase("stomach pain"))
            {
                dis[3]++;
            }
            if(str[i].equalsIgnoreCase("cold"))
            {
                dis[0]++;
            }
            if(str[i].equalsIgnoreCase("knee pain"))
            {
                dis[2]++;
            }
            if(str[i].equalsIgnoreCase("memory loss"))
            {
                dis[4]++;
            }
            if(str[i].equalsIgnoreCase("blurred vision"))
            {
                dis[1]++;
            }
            if(str[i].equalsIgnoreCase("eye pain"))
            {
                dis[1]++;
            }
            if(str[i].equalsIgnoreCase("chest pain"))
            {
                dis[5]++;
            }
            if(str[i].equalsIgnoreCase("joint pain"))
            {
                dis[2]++;
            }
            if(str[i].equalsIgnoreCase("allergy"))
            {
                dis[6]++;
            }
            if(str[i].equalsIgnoreCase("rash"))
            {
                dis[6]++;
            }
        }
        int max;
        for(i=0;i<6;i++)
        {
            max=i;
            for(j=i+1;j<7;j++)
            {
                if(dis[max]<dis[j])
                    max=j;
                int temp=dis[i];
                dis[i]=dis[max];
                dis[max]=temp;
                String tempstr=dc[i];
                dc[i]=dc[max];
                dc[max]=tempstr;
            }
        }

        if((dis[0]!=0)&&(dis[1]!=0))
        {
            if(c>1)
            {
                System.out.println("Doctor recommended for your problem is - "+dc[0]);
                System.out.print("Also consult - ");
                for(i=1;i<7;i++)
                {
                    if(dis[i+1]==0)
                    {
                        System.out.print(dc[i]);
                        break;
                    }
                    else
                        System.out.print(dc[i]+", ");
                }
            }
            else
                System.out.println("Doctor recommended for your problem is - "+dc[0]);
        }
        else
            System.out.println("Doctor recommended for your problem is - "+dc[0]);
        System.out.println();
        System.out.println();
        Booking_Appointment_Schedule ba=new Booking_Appointment_Schedule();
        try
        {
            ba.main();
        }
        catch (Exception e) {
            e.printStackTrace();
        }   
    }
}
