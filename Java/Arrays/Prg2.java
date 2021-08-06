import java.io.BufferedReader;
import java.io.InputStreamReader;

//Program to Find the Maximum and Minimum of Array
public class Prg2
{
    int []a;
    private void read() throws Exception
    {
        int n;
        BufferedReader op=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nEnter the Size of the Array= ");
        n=Integer.parseInt(op.readLine());
        a=new int[n];
        System.out.println("Enter the Elements of Array- ");
        for(int i=0;i<a.length;i++)
            a[i]=Integer.parseInt(op.readLine());
    }
    private void minimax()
    {
        int min=a[0];
        int imx=0;
        int imn=0;
        int max=a[0];
        for(int i=1;i<a.length;i++)
        {
            if(a[i]>max)
            {
                max=a[i];
                imx=i;
            }
            if(a[i]<min)
            {
                min=i;
                imn=i;
            }
        }
        System.out.println("Maximum Element is "+max+" and Found at "+(imx+1)+abb((imx+1))+" Position");
        System.out.println("Minimum Element is "+min+" and Found at "+(imn+1)+abb((imn+1))+" Position");
    }
    private String abb(int n)
    {
        return switch (n % 10) {
            case 1 -> "st";
            case 2 -> "nd";
            case 3 -> "rd";
            default -> "th";
        };
    }
    private void run() throws Exception
    {
        read();
        minimax();
    }
    public static void main(String[] args) throws Exception
    {
        new Prg2().run();
    }
}
