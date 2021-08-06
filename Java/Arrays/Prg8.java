import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Program to find Largest sum contiguous Sub-Array.
public class Prg8
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0)
        {
            //size of array
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            String cl=br.readLine();
            String []val=cl.trim().split("\\s+");

            //adding elements
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(val[i]);
            }
            //calling maxSubarraySum() function
            System.out.println(new Prg8().maxSubarraySum(arr, n));
        }
    }
    private int maxSubarraySum(int[] a, int n)
    {

        int max=Integer.MIN_VALUE;
        int curr=0;
        int s=0;
        int start ,end;
        for(int i=0;i<n;i++)
        {
            curr=curr+a[i];
            if(max<curr)
            {
                max=curr;
                start=s;
                end=i;
            }
            if(curr<0)
            {
                curr=0;
                s=i+1;
            }
        }
        return max;
    }
}