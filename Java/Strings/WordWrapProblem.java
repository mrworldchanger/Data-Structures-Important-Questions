import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WordWrapProblem
{
    private void run() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                nums[i]  =Integer.parseInt(S[i]);
            int k = Integer.parseInt(br.readLine().trim());
            System.out.println(solveWordWrap(nums, k));
        }
    }
    private int solveWordWrap(int []arr,int k)
    {
        int n = arr.length, curlen, cost;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0;

        for(int i = n - 2; i >= 0; i--)
        {
            curlen = -1;
            for(int j = i; j < n; j++)
            {
                curlen += (arr[j] + 1);
                if(curlen > k)
                    break;

                if(j == n-1)
                    cost = 0;
                else
                    cost = (k - curlen) * (k - curlen) + dp[j + 1];
                if(cost < dp[i])
                    dp[i] = cost;
            }
        }
        for(int i=0;i<n;i++)
            System.out.println(dp[i]);
        return dp[0];
    }

    public static void main(String[] args) throws Exception
    {
        new WordWrapProblem().run();
    }
}
