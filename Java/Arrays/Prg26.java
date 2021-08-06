//Given an array of size n and a number k, find all elements that appear more than n/k times
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prg26
{
    private int maxProfit(int []price)
    {
        int profit[] = new int[price.length];
        for (int i = 0; i < price.length; i++)
            profit[i] = 0;
        int max_price = price[price.length - 1];
        for (int i = price.length - 2; i >= 0; i--)
        {
            if (price[i] > max_price)
                max_price = price[i];
            profit[i] = Math.max(profit[i + 1], max_price - price[i]);
        }
        System.out.println();
        for(int i=0;i<profit.length;i++)
        {
            System.out.print(profit[i]+" ");
        }
        System.out.println();
        int min_price = price[0];
        for (int i = 1; i < price.length; i++) {
            if (price[i] < min_price)
                min_price = price[i];
            profit[i] = Math.max( profit[i - 1], profit[i] + (price[i] - min_price));
        }
        System.out.println();
        for(int i=0;i<profit.length;i++)
        {
            System.out.print(profit[i]+" ");
        }
        System.out.println();
        int result = profit[price.length - 1];
        return result;
    }
    private void run() throws Exception
    {
        BufferedReader op=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(op.readLine());
        while(n-- > 0)
        {
            int size=Integer.parseInt(op.readLine());
            String line=op.readLine();
            String []val=line.trim().split("\\s+");
            int[] arr =new int[size];
            for(int i=0;i<size;i++)
                arr[i]=Integer.parseInt(val[i]);
            System.out.println(maxProfit(arr));
        }
    }
    public static void main(String [] args) throws Exception
    {
        new Prg26().run();
    }
}
