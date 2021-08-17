import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinaryFlipCount
{
    private void run() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            System.out.println(minFlips(S));

        }
    }
    private int minFlips(String str)
    {
        return Math.min(count(str,'0'),count(str,'1'));
    }
    private char flip(char ch)
    {
        return ch=='0' ? '1' : '0';
    }
    private int count(String str,char exp)
    {
        int flipcount=0;
        for(int i=0;i<str.length();i++)
        {
            if (str.charAt(i) != exp)
                flipcount++;
            exp = flip(exp);
        }
        return flipcount;
    }
    public static void main(String[] args) throws Exception
    {
        new BinaryFlipCount().run();
    }
}
