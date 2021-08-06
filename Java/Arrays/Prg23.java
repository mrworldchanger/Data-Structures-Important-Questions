//Given an array Arr that contains N integers (may be positive, negative or zero). Find the product of the maximum product subarray.
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prg23
{
    public static void main(String[] args) throws Exception
    {
        new Prg23().run();
    }
    private void run() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0)
        {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++)
            {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(maxProduct(arr));
        }
    }
    long maxProduct(int[] arr)
    {
        long min,max,temp,prod;
        min=max=prod=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]<0)
            {
                temp=min;
                min=max;
                max=temp;
            }
            max=Math.max(arr[i],max*arr[i]);
            min=Math.min(arr[i],min*arr[i]);
            if(max>prod)
                prod=max;
        }
        return prod;
    }
}
