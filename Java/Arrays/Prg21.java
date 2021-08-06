//Given an array of positive and negative numbers. Find if there is a subarray (of size at-least one) with 0 sum.
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Prg21
{
    private void run() {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0)
        {
            int n = scan.nextInt() ;
            int[] arr = new int[n];
            for(int i = 0; i<n;i++)
            {
                arr[i] = scan.nextInt();
            }
            t--;
            System.out.println(subarray(arr) ?"Yes":"No");
        }
    }
    public static void main(String[] args) throws Exception
    {
        new Prg21().run();
    }
    public boolean subarray(int[] a)
    {
        Set<Integer> add= new HashSet<>();
        int sum=0;
        for (int j : a)
        {
            sum += j;
            if (j == 0 || sum == 0 || add.contains(sum))
                return true;
            add.add(sum);
        }
        return false;
    }
}
