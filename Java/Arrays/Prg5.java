import java.io.BufferedReader;
import java.io.InputStreamReader;

//Program to Move All Negative at One Side.
public class Prg5
{
    int []a;
    private void read() throws Exception
    {
        int n;
        BufferedReader op = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nEnter Size of the Array= ");
        n = Integer.parseInt(op.readLine());
        a = new int[n];
        System.out.println("Enter Values of the Array-");
        for(int i=0;i<a.length;i++)
            a[i]=Integer.parseInt(op.readLine());
    }
    private void arrange()
    {
        int []cp=a.clone();
        int h = 0;
        for(int i=0;i<cp.length;i++)
        {
            if(cp[i]<0)
            {
               if(i!=h)
               {
                   int temp=cp[i];
                   cp[i]=cp[h];
                   cp[h]=temp;
               }
               h++;
            }
        }
        System.out.print("\nOriginal Array- ");
        display(a);
        System.out.print("\nReverse of Original Array- ");
        display(cp);
    }
    private void run() throws Exception
    {
        read();
        arrange();
    }
    private void display(int []arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]);
            if(i<arr.length -1)
                System.out.print(",");
        }
    }
    public static void main(String[] args) throws Exception
    {
        new Prg5().run();
    }
}
