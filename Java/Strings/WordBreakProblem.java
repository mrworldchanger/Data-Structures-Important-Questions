import java.util.ArrayList;
import java.util.Scanner;

public class WordBreakProblem
{
    public static void main(String[] args)
    {
        new WordBreakProblem().run();
    }
    private void run()
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n;
            n = sc.nextInt();
            ArrayList<String> arr = new ArrayList<>();
            for(int i = 0;i<n;i++)
            {
                String p = sc.next();
                arr.add(p);
            }
            String line = sc.next();
            System.out.println(wordBreak(line,arr));

        }
    }
    private int wordBreak(String s, ArrayList<String> wordSet)
    {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (dp[j] && wordSet.contains(s.substring(j, i)))
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        if(dp[s.length()])
            return 1;
        else
            return 0;
    }
}
