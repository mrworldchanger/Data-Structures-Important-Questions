import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RearrangeCharacters
{
    private void run() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            System.out.println(change(str));
        }
    }
    private char getMaxCountChar(int []count)
    {
        int max = 0;
        char ch='\u0000';
        for (int i = 0; i < 26; i++)
        {
            if (count[i] > max)
            {
                max = count[i];
                ch = (char)('a' + i);
            }
        }
        return ch;
    }
    private String change(String str)
    {
        int n = str.length();
        if (n == 0)
            return "";
        int [] count=new int [26];
        Arrays.fill(count, 0);
        for (int i=0;i<n;i++)
            count[str.charAt(i) - 'a']++;
        char ch_max = getMaxCountChar(count);
        int maxCount = count[ch_max - 'a'];
        if (maxCount > (n + 1) / 2)
            return "";
        char []res=new char[n];
        Arrays.fill(res,' ');
        int ind = 0;
        while (maxCount > 0)
        {
            res[ind] = ch_max;
            ind = ind + 2;
            maxCount--;
        }
        count[ch_max - 'a'] = 0;
        for (int i = 0; i < 26; i++)
        {
            while (count[i] > 0) {
                ind = (ind >= n) ? 1 : ind;
                res[ind] = (char)('a' + i);
                ind += 2;
                count[i]--;
            }
        }
        return Arrays.toString(res);
    }
    public static void main(String[] args) throws Exception
    {
        new RearrangeCharacters().run();
    }
}
