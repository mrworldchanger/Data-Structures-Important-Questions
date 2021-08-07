//Print Reverse of Given String Str
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReverseString
{
    public static void main(String[] args) throws Exception
    {
        new ReverseString().run();
    }
    private void run() throws Exception
    {
        BufferedReader op=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(op.readLine());
        while(t-- > 0)
        {
            String str= op.readLine();
            System.out.println(reverse(str));
        }
    }
    private String reverse(String str)
    {
        int low=0;
        int high=str.length()-1;
        char []ch=str.toCharArray();
        while(low < high)
        {
            char temp=ch[low];
            ch[low] = ch[high];
            ch[high] = temp;
            low++;
            high--;
        }
        return Arrays.toString(ch);
    }
}
