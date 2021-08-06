//Best Time to Buy and Sell Stock
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prg17
{
    private int maxProfit(int[] arr) {
        int mince = Integer.MAX_VALUE;
        int profit = 0;
        for (int j : arr) {
            if (j < mince)
                mince = j;
            else if (j - mince > profit)
                profit = j - mince;
        }
        return profit;
    }
    private void run() throws Exception
    {
        BufferedReader op=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(op.readLine());
        while(n-- > 0)
        {
            String line=op.readLine();
            String []val=line.trim().split("\\s+");
            int size=Integer.parseInt(val[0]);
            line=op.readLine();
            val=line.trim().split("\\s+");
            int[] arr =new int[size];
            for(int i=0;i<size;i++)
                arr[i]=Integer.parseInt(val[i]);
            System.out.println(maxProfit(arr));
        }
    }
    public static void main(String [] args) throws Exception
    {
        new Prg17().run();
    }
}
