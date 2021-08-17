import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LongestPrefixSuffix
{
    public static void main(String[] args) throws Exception
    {
        new LongestPrefixSuffix().run();
    }
    private void run() throws Exception
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            System.out.println(lps(s));
        }
    }
    private int lps(String str)
    {
        int n=str.length();
        int []lps = new int[n];
        lps[0] = 0;
        int len = 0;
        int i = 1;
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
                    len = lps[len-1];
                }
                else
                {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        int res = lps[n-1];
        return (res > n/2)? n/2 : res;
    }
}
