import java.io.BufferedReader;
import java.io.InputStreamReader;

//Program to Find Reverse of the Given Arrays
public class Prg1
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
    private void reverse()
    {
        int []cp=a.clone();
        int l=0,h=cp.length-1;
        while(l<h)
        {
            int temp=cp[l];
            cp[l]=cp[h];
            cp[h]=temp;
            l++;
            h--;
        }
        System.out.print("\nOriginal Array- ");
        display(a);
        System.out.print("\nReverse of Original Array- ");
        display(cp);
    }
    private void run() throws Exception
    {
        read();
        reverse();
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
        new Prg1().run();
    }
}
