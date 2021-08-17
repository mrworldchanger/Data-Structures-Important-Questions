import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LongestCommonPrefix
{
    private void run() throws Exception
    {
        BufferedReader op=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(op.readLine());
        while(t-- > 0)
        {
            String str=op.readLine();
            String []input=str.trim().split("\\+s");
            System.out.println(lcp(input));
        }
    }
    private String lcp(String []grid)
    {
        if(grid.length==0)
            return " ";
        String prefix=grid[0];
        for (String s : grid)
        {
            while (s.indexOf(prefix) != 0)
            {
                prefix = prefix.substring(0, prefix.length() - 1);
                //System.out.println(prefix);
                if (prefix.isEmpty())
                    return " ";
            }
        }
        return prefix;
    }

    public static void main(String[] args) throws Exception
    {
        new LongestCommonPrefix().run();
    }
}
