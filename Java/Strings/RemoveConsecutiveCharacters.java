import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RemoveConsecutiveCharacters
{
    private void run() throws Exception
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0)
        {
            String S = read.readLine().trim();
            String ans = removeConsecutiveCharacter(S);
            System.out.println(ans);
        }
    }
    private String removeConsecutiveCharacter(String str)
    {
        StringBuilder ret=new StringBuilder();
        ret.append(str.charAt(0));
        for(int i=1;i<str.length();i++)
        {
            if(str.charAt(i) !=str.charAt(i-1))
                ret.append(str.charAt(i));
        }
        return ret.toString();
    }
    public static void main(String[] args) throws Exception
    {
        new RemoveConsecutiveCharacters().run();
    }
}
