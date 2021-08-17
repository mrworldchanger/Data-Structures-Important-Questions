import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class KMPAlgorithm
{
    private HashMap <Integer,Integer> kmp(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();
        int []lps = new int[M];
        int j = 0;
        HashMap<Integer ,Integer> op=new HashMap<>();
        lpsArray(pat, lps);
        int i = 0;
        while (i < N)
        {
            if (pat.charAt(j) == txt.charAt(i))
            {
                j++;
                i++;
            }
            if (j == M)
            {
                op.put((i - j),(i-j+M));
                j = lps[j - 1];
            }
            else if (i < N && pat.charAt(j) != txt.charAt(i))
            {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        return op;
    }
    private void lpsArray(String str,int []lps)
    {
        int n = str.length();
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
                    len = lps[len - 1];
                }
                else
                {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
    private void run() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            System.out.println(kmp(S[0], S[1]));
        }
    }
    public static void main(String[] args) throws Exception
    {
        new KMPAlgorithm().run();
    }
}
