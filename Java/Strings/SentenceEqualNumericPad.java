import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SentenceEqualNumericPad
{
    public static void main(String[] args) throws Exception
    {
        new SentenceEqualNumericPad().run();
    }
    private void run() throws Exception
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0)
        {
            String S = read.readLine();
            System.out.println(digits(S));
        }
    }
    private String digits(String str)
    {
        StringBuilder ret=new StringBuilder();
        String []alpha={"2","22","222","3","33","333","4","44","444","5","55","555","6","66","666","7","77","777","7777","8","88","888","9","99","999","9999"};
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)==' ')
            {
                ret.append("0");
            }
            else
            {
                int ch=str.charAt(i) - 'A';
                ret.append(alpha[ch]);
            }
        }
        return ret.toString();
    }
}
