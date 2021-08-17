import java.util.Scanner;

public class CountAllPalindromeSubsequence
{
    public static void main(String[] args)
    {
        new CountAllPalindromeSubsequence().read();
    }
    private void read()
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t>0)
        {
            String str = sc.nextLine();
            System.out.println(countPS(str));
            t--;
        }
    }
    long countPS(String str)
    {
        long mod=1000000007;
        int N = str.length();
        int [][]dp=new int[N][N];
        for(int g=0;g<N;g++)
        {
            for(int i=0,j=g;j<N;i++,j++)
            {
                if(g==0)
                    dp[i][j]=1;
                else {
                    boolean b = str.charAt(i) == str.charAt(j);
                    if(g==1)
                    {
                        dp[i][j]= b ? 3 : 2;
                    }
                    else
                    {
                        if(b)
                            dp[i][j] = dp[i][j-1] + dp[i+1][j] +1 ;
                        else
                            dp[i][j]=dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
                        if (dp[i][j] < 0)
                            dp[i][j] += mod;
                        dp[i][j] %= mod;
                    }
                }
            }
        }
        return dp[0][N-1];
    }
}
