//Program to Print for a Given string S, check if it is palindrome or not.
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PalindromeString
{
    public static void main(String[] args) throws Exception
    {
        new PalindromeString().run();
    }
    private void run() throws Exception
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0)
        {
            String S = read.readLine();
            System.out.println(isPlaindrome(S));
        }
    }
    int isPlaindrome(String S)
    {
        for(int i=0,j=S.length()-1;i<S.length();i++,j--)
        {
            if(S.charAt(i)!=S.charAt(j))
                return 0;
        }// code here
        return 1;
    }
}
