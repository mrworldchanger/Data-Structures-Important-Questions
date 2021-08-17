import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinarySubString
{
    private void run() throws Exception
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            System.out.println(check(s));
        }
    }
    private int check(String str)
    {
        int ret=0,cnt0=0,cnt1=0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='0')
                cnt0++;
            else
                cnt1++;
            if(cnt1==cnt0)
                ret++;
        }
        if(ret==0)
            return -1;
        return ret;
    }

    public static void main(String[] args) throws Exception
    {
        new BinarySubString().run();
    }
}
