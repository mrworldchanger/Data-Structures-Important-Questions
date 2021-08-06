import java.io.BufferedReader;
import java.io.InputStreamReader;

//Program to cyclically rotate an array by one.
public class Prg7
{
    int []a;
    int rot;
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
        System.out.print("\nEnter Rotation Factor of the Array= ");
        rot = Integer.parseInt(op.readLine());
    }
    private void reverse(int []arr,int l,int h)
    {
        while(l<h)
        {
            int temp=arr[l];
            arr[l]=arr[h];
            arr[h]=temp;
            l++;
            h--;
        }
    }
    private void run() throws Exception
    {
        read();
        int []cp=a.clone();
        reverse(cp,0,rot-1);
        reverse(cp,rot,cp.length-1);
        reverse(cp,0,cp.length-1);
        System.out.print("\nOriginal Array- ");
        display(a);
        System.out.print("\nRotation of Original Array By "+rot+abb(rot)+"- ");
        display(cp);
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
    private String abb(int n)
    {
        return switch (n % 10) {
            case 1 -> "st";
            case 2 -> "nd";
            case 3 -> "rd";
            default -> "th";
        };
    }
    public static void main(String[] args) throws Exception
    {
        new Prg7().run();
    }
}
