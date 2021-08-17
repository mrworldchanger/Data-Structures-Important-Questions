import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestCommonSubsequence
{
    int[][] tr;
    private void run() throws Exception
    {
        BufferedReader op=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(op.readLine());
        while(t-- > 0)
        {
            String input=op.readLine();
            String []val=input.trim().split(" ");
            System.out.print("\n1st Input String= "+val[0]);
            System.out.print("\n2nd Input String= "+val[1]);
            tr=new int[val[0].length()+1][val[1].length()+1];
            for(int []i :tr)
                Arrays.fill(i,-1);
            System.out.println("\nLength of the Longest Common Subsequence in 1st and 2nd Input String= "+(lcs(val[0],val[1],val[0].length(),val[1].length())));
            System.out.println("\nLength of the Longest Common Subsequence in 1st and 2nd Input String= "+(lcs2(val[0],val[1],val[0].length(),val[1].length())));
            String str=(lcs3(val[0],val[1]));
            System.out.println("\nLongest Common Subsequence in 1st and 2nd Input String= "+str+" And its Length is "+str.length());
        }
    }
    private int lcs (String s1,String s2,int m,int n)
    {
        if(m==0||n==0)
            return 0;
        if(s1.charAt(m-1)==s2.charAt(n-1))
            return 1+lcs(s1,s2,m-1,n-1);
        else
            return Math.max(lcs(s1,s2,m-1,n),lcs(s1,s2,m,n-1));
    }
    private int lcs2 (String s1,String s2,int m,int n)
    {
        if(m==0||n==0)
            return 0;
        if(tr[m][n]!=-1)
            return tr[m][n];
        if(s1.charAt(m-1)==s2.charAt(n-1))
            return tr[m][n]= 1+lcs(s1,s2,m-1,n-1);
        else
            return tr[m][n]=Math.max(lcs(s1,s2,m-1,n),lcs(s1,s2,m,n-1));
    }
    private String lcs3 (String s1,String s2)
    {
        StringBuilder op=new StringBuilder();
        int[][] lc =new int[s1.length()+1][s2.length()+1];
        boolean br=true;
        int m=s1.length();
        int n=s2.length();
        for (int i = 0; i <= m; i++)
        {
            for (int j = 0; j <= n; j++)
            {
                if(i==0 || j==0)
                    lc[i][j]=0;
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    lc[i][j]=1+lc[i-1][j-1];
                }
                else
                    lc[i][j]=Math.max(lc[i-1][j],lc[i][j-1]);
            }
            br=true;
        }
        int i = m, j = n;
        while (i > 0 && j > 0)
        {
            if (s1.charAt(i-1) == s2.charAt(j-1))
            {
                op.append(s1.charAt(i-1)); // Put current character in result
                i--; j--;     // reduce values of i, j and index
            }
            else if (lc[i-1][j] > lc[i][j-1])
                i--;
            else
                j--;
        }
        op.reverse();
        return op.toString();
    }
    public static void main(String[] args) throws Exception
    {
        new LongestCommonSubsequence().run();
    }
}
