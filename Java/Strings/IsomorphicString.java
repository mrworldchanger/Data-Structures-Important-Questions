import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsomorphicString
{
    private void run() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            if(areIsomorphic(s1,s2))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
    private boolean areIsomorphic(String str1,String str2)
    {
        if(str1.length() != str2.length())
            return false;
        int []c1=new int [26];
        int []c2=new int [26];
        for(int i=0;i<str1.length();i++)
        {
            int i1=str1.charAt(i) - 'a';
            int i2=str2.charAt(i) - 'a';
            c1[i1]++;
            c2[i2]++;

            if(c1[i1] != c2[i2])
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception
    {
        new IsomorphicString().run();
    }
}
