import java.util.Scanner;

public class WildcardMatching
{
    public static void main(String[] args) throws Exception
    {
        new WildcardMatching().run();
    }
    private void run()
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t>0)
        {
            String pat = sc.nextLine();
            String text = sc.nextLine();
            System.out.println(wildCard(pat,text));
            System.out.println(solve(pat,text));
            t--;
        }
    }
    private int wildCard(String str , String pattern)
    {
        if (str.length() == 0)
            return 0;
        int i = 0, j = 0, index_txt = -1,
                index_pat = -1;

        while (i < str.length())
        {
            if (j < pattern.length() && str.charAt(i) == pattern.charAt(j))
            {
                i++;
                j++;
            }
            else if (j < pattern.length() && pattern.charAt(j) == '?')
            {
                i++;
                j++;
            }
            else if (j < pattern.length() && pattern.charAt(j) == '*')
            {
                index_txt = i;
                index_pat = j;
                j++;
            }
            else if (index_pat != -1)
            {
                j = index_pat + 1;
                i = index_txt + 1;
                index_txt++;
            }
            else
            {
                return 0;
            }
        }
        while (j < pattern.length() && pattern.charAt(j) == '*')
        {
            j++;
        }
        if (j == pattern.length())
        {
            return 1;
        }
        return 0;
    }
    private boolean solve(String str , String pattern)
    {
        boolean [][]dp=new boolean[pattern.length()+1][str.length()+1];
        //if(str.charAt(0))
        for(int i=dp.length-1;i>=0;i--)
        {
            for(int j=dp[0].length-1;j>=0;j--)
            {
                if(i==dp.length-1 && j==dp[0].length -1)
                    dp[i][j]=true;
                else if(i==dp.length -1)
                    dp[i][j]=false;
                else if(j==dp[0].length-1)
                {
                    if(pattern.charAt(i) == '*')
                        dp[i][j]=dp[i+1][j];
                    else
                        dp[i][j] =false;
                }
                else
                {
                    if(pattern.charAt(i)=='?')
                        dp[i][j]=dp[i+1][j+1];
                    else if (pattern.charAt(i)=='*')
                        dp[i][j] = dp[i+1][j] || dp[i][j+1];
                    else if (pattern.charAt(i)==str.charAt(i))
                        dp[i][j]=dp[i+1][j+1];
                    else
                        dp[i][j]=false;
                }
            }
        }
        return dp[0][0];
    }
}
