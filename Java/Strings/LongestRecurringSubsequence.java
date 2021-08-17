import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LongestRecurringSubsequence
{
    private void run() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            int ans = LRS(str);
            System.out.println(ans);
        }
    }
    private int LRS(String str)
    {
        int n = str.length();
        int[][] dp = new int[n+1][n+1];
        for (int i=1; i<=n; i++)
        {
            for (int j=1; j<=n; j++)
            {
                if (str.charAt(i-1) == str.charAt(j-1) && i!=j)
                    dp[i][j] =  1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[n][n];
    }

    public static void main(String[] args) throws Exception
    {
        new LongestRecurringSubsequence().run();
    }
}
