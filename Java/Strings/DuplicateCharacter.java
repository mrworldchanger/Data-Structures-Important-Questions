//Write an efficient program to print all the duplicates and their counts in the input string
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DuplicateCharacter
{
    public static void main(String[] args) throws Exception
    {
        new DuplicateCharacter().run();
    }
    private void run() throws Exception
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0)
        {
            String S = read.readLine();
            duplicate(S);
        }
    }
    private void duplicate(String str)
    {
        int []count=new int[26];
        str=str.toLowerCase();
        Arrays.fill(count,0);
        for(int i=0;i<str.length();i++)
        {
            int ind=str.charAt(i)-'a';
            count[ind]=++count[ind];
        }
        for(int i=0;i<count.length;i++)
        {
            if(count[i]>1)
            {
                char ch=(char)(i+'a');
                System.out.println(ch+" count= "+count[i]);
            }
        }
    }
}
