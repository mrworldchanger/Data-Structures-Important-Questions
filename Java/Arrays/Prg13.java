import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prg13
{
    private void run() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0)
        {
            //size of array
            int n = Integer.parseInt(br.readLine().trim());
            int []arr = new int[n];
            String []inputLine = br.readLine().trim().split(" ");

            //adding elements
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            //calling Max-Sub-ArraySum() function
            System.out.println(new Prg13().calculate(arr));
        }
    }
    private int calculate(int []arr)
    {
        int max=Integer.MIN_VALUE;
        int curr=0;
        for (int j : arr)
        {
            curr = curr + j;
            if (max < curr)
            {
                max = curr;
            }
            if (curr < 0)
            {
                curr = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) throws Exception
    {
        new Prg13().run();
    }
}
