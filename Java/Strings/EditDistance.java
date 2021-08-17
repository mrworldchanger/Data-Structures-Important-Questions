import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EditDistance
{
	private void run() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            System.out.println(solve(S[0], S[1]));
        }
    }
	private int solve(String str,String target)
	{
		int m=str.length();
        int n=target.length();
        int [][]dp = new int[m + 1][n + 1];
		for(int i=0;i<=m;i++)
		{
			for(int j=0;j<=m;j++)
			{
				if (i == 0)
                    dp[i][j] = j; 
				else if (j == 0)
                    dp[i][j] = i;
				else if (str.charAt(i - 1) == target.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j],dp[i - 1][j - 1])); 
			}
		}
		return dp[m][n];
	}
    public static void main(String[] args) throws Exception
    {
        new EditDistance().run();
    }
}