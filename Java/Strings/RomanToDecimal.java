import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RomanToDecimal
{
    private void run() throws Exception
    {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0)
        {
            String roman = br.readLine().trim();
            System.out.println(romanToDecimal(roman));
        }
    }
    private int value(char ch)
    {
        return switch(ch)
                {
                    case 'I' -> 1;
                    case 'V' -> 5;
                    case 'X' -> 10;
                    case 'L' -> 50;
                    case 'C' -> 100;
                    case 'D' -> 500;
                    case 'M' -> 1000;
                    default -> -1;
                };
    }
    private int romanToDecimal(String str)
    {
        int res=0;
        for(int i=0;i<str.length();i++)
        {
            int s1=value(str.charAt(i));
            if(i+1<str.length())
            {
                int s2=value(str.charAt(i+1));
                if(s1>=s2)
                {
                    res=res+s1;
                }
                else
                {
                    res=res+s2-s1;
                    i++;
                }
            }
            else
            {
                res=res+s1;
            }
        }
        return res;
    }
    public static void main(String[] args) throws Exception
    {
        new RomanToDecimal().run();
    }
}
