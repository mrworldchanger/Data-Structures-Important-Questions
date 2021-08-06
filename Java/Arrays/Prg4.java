import java.io.BufferedReader;
import java.io.InputStreamReader;

//Program to Sorting Array Containing 0,1,2 only.
public class Prg4
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
        int lo = 0;
        int hi = cp.length - 1;
        int mid = 0, temp;
        while (mid <= hi)
        {
            switch (cp[mid]) {
                case 0 -> {
                    temp = cp[lo];
                    cp[lo] = cp[mid];
                    cp[mid] = temp;
                    lo++;
                    mid++;
                }
                case 1 -> mid++;
                case 2 -> {
                    temp = cp[mid];
                    cp[mid] = cp[hi];
                    cp[hi] = temp;
                    hi--;
                }
            }
        }
        System.out.print("\nOriginal Array- ");
        display(a);
        System.out.print("\nSorted of Original Array- ");
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
        new Prg4().run();
    }
}
