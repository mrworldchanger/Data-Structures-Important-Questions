import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class CountBracketReversal
{
    public static void main(String[] args) throws Exception
    {
       new CountBracketReversal().run();
    }
    private void run() throws Exception
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0)
        {
            String S = read.readLine();
            System.out.println(bracket(S));
        }
    }
    private int bracket(String str)
    {
        int len = str.length();
        if (len%2 != 0)
            return -1;
        Stack<Character> op=new Stack<>();
        for (int i=0; i<len; i++)
        {
            char c = str.charAt(i);
            if (c =='}' && !op.empty())
            {
                if (op.peek()=='{')
                    op.pop();
                else
                    op.push(c);
            }
            else
                op.push(c);
        }
        int red_len = op.size();
        int n = 0;
        while (!op.empty() && op.peek() == '{')
        {
            op.pop();
            n++;
        }
        return (red_len/2 + n%2);
    }
}
