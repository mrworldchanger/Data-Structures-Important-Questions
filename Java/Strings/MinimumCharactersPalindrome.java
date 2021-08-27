import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MinimumCharactersPalindrome
{
    public static void main(String[] args) throws Exception
    {
        new MinimumCharactersPalindrome().run();
    }
    private void run() throws Exception
    {
        BufferedReader op=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(op.readLine());
        while(t-- > 0)
        {
            String input=op.readLine();
            System.out.println(changepalindrome(input));
        }
    }
    private int changepalindrome(String str)
    {
        StringBuilder op=new StringBuilder(str);
        String st=str+"%"+op.reverse();
        int []ret=lcs(st);
        return str.length() - ret[str.length() -1];
    }
    private int []lcs(String str)
    {
        int n = str.length();
        int []lps = new int[n];
        int i = 1, len = 0;
        lps[0] = 0;
        while (i < n)
        {
            if (str.charAt(i) == str.charAt(len))
            {
                len++;
                lps[i] = len;
                i++;
            }
            else
            {
                if (len != 0)
                {
                    len = lps[len - 1];
                }
                else
                {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
