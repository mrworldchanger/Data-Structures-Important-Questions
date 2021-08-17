import java.util.Scanner;
import java.util.Stack;

public class BalanceParenthesis
{
    private void run()
    {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t-- >0)
        {
            String st = sc.next();
            if(check(st))
                System.out.println("balanced");
            else
                System.out.println("not balanced");

        }
    }
    private boolean check(String str)
    {
        Stack<Character> op=new Stack<>();
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(ch=='(' || ch=='{' || ch=='[')
            {
                op.push(ch);
                continue;
            }
            if(op.isEmpty())
                return false;
            char check;
            switch (ch)
            {
                case ')':
                    check = op.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = op.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = op.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }
        return (op.isEmpty());
    }
}
