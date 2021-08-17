import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPalindrome
{
    private void run() throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            System.out.println(longestPalin(S));
        }
    }
    private String longestPalin(String str)
    {
        int maxLength = 1;
        int start = 0;
        int len = str.length();
        int low, high;
        for (int i = 1; i < len; ++i)
        {
            low = i - 1;
            high = i;
            while (low >= 0 && high < len && str.charAt(low) == str.charAt(high))
            {
                --low;
                ++high;
            }
            ++low;
            --high;
            if (str.charAt(low) == str.charAt(high) && high - low + 1 > maxLength)
            {
                start = low;
                maxLength = high - low + 1;
            }
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len && str.charAt(low) == str.charAt(high))
            {
                --low;
                ++high;
            }
            ++low;
            --high;
            if (str.charAt(low) == str.charAt(high) && high - low + 1 > maxLength)
            {
                start = low;
                maxLength = high - low + 1;
            }
        }
        return str.substring(start, start+maxLength);
    }
    public static void main(String[] args) throws IOException
    {
        new LongestPalindrome().run();
    }
}
