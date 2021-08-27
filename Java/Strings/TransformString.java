import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TransformString
{
    private void run() throws Exception
    {
        BufferedReader op=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(op.readLine());
        while(t-- > 0)
        {
            String line=op.readLine();
            String []val=line.trim().split(" ");
            System.out.println(transform(val[0],val[1]));
        }
    }
    private int transform(String str1,String str2)
    {
         if(str1.length() != str2.length())
             return -1;
         int i,j,res=0;
         int []count=new int [26];
         int cn=0;
         for(i=0;i<str1.length();i++)
         {
             int ind=str1.charAt(i) - 'A';
             count[ind]++;
             ind=str2.charAt(i) - 'A';
             count[ind]++;
         }
         for(i=0;i<26;i++)
         {
             if(count[i] == 0)
                 cn++;
         }
         if(cn==26)
             return -1;
         i = str1.length() - 1;
         j = str2.length() - 1;
         while(i>=0)
         {
             if(str1.charAt(i) != str2.charAt(j))
                 res++;
             else
                 j--;
             i--;
         }
         return res;
    }

    public static void main(String[] args) throws Exception
    {
        new TransformString().run();
    }
}
