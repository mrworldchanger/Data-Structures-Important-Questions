import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class ShuffleLength
{
    public static void main(String[] args) throws Exception
    {
        new ShuffleLength().run();
    }
    private void run() throws Exception
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0)
        {
            String S = read.readLine();
            String []val=S.trim().split(" ");
            String first = val[0];
            String second = val[1];
            S = read.readLine();
            val=S.trim().split(" ");
            for(String str: val)
            {
                if (checkLength(first, second,str)  && shuffleCheck(first, second, str))
                {
                    System.out.println(str + " is a valid shuffle of " + first + " and " + second);
                }
                else {
                    System.out.println(str + " is not a valid shuffle of " + first + " and " + second);
                }
            }
        }
        /*
        String first = "XY";
        String second = "12";
        String[] results = {"1XY2", "Y1X2", "Y21XX","HOPE"};
        for(String str: results)
        {
            if (checkLength(first, second,str)  && shuffleCheck(first, second, str))
            {
                System.out.println(str + " is a valid shuffle of " + first + " and " + second);
            }
            else {
                System.out.println(str + " is not a valid shuffle of " + first + " and " + second);
            }
        }*/
    }
    private boolean checkLength(String str1 , String str2 ,String str3)
    {
        return ( (str1+str2).length() == str3.length());
    }
    private boolean shuffleCheck(String str1 , String str2 ,String str3)
    {
        HashSet<Character> op=new HashSet<>();
        for(int i=0;i<str1.length();i++)
            op.add(str1.charAt(i));
        for(int i=0;i<str2.length();i++)
            op.add(str2.charAt(i));
        for(int i=0;i<str3.length();i++)
        {
            if(!op.contains(str3.charAt(i)))
                return false;
        }
        return true;
    }
}
