import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaximumBinarySubstring
{
    private void run() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            int ans = maxstring(S);
            System.out.println(ans);
        }
    }
    private int maxstring(String str)
    {
        int cnt1=0,cnt0=0;
        int num=0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='0')
                cnt0++;
            else
                cnt1++;
            if(cnt0==cnt1)
                num++;
        }
        if(num==0)
            return -1;
        return num;
    }

    public static void main(String[] args) throws Exception
    {
        new MaximumBinarySubstring().run();
    }
}
