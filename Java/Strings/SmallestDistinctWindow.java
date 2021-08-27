import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SmallestDistinctWindow
{
    private void run() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            System.out.println(findSubString(str).length());
            System.out.println(findSubString(str));
        }
    }
    private String findSubString(String str)
    {
        int n=str.length();
        int dc=0;
        boolean []vis=new boolean[256];
        Arrays.fill(vis,false);
        for(int i=0;i<n;i++)
        {
            if(!vis[str.charAt(i)])
            {
                vis[str.charAt(i)]=true;
                dc++;
            }
        }
        int st=0;
        int si=-1;
        int ml=Integer.MAX_VALUE;
        int c=0;
        int []cur=new int [256];
        for(int j=0;j<n;j++)
        {
            cur[str.charAt(j)]++;
            if(cur[str.charAt(j)] == 1)
                c++;
            if(c == dc)
            {
                while(cur[str.charAt(st)] > 1)
                {
                    if (cur[str.charAt(st)] > 1)
                        cur[str.charAt(st)]--;
                    st++;
                }
                int len=j-st+1;
                if(ml > len)
                {
                    ml=len;
                    si=st;
                }
            }
        }
        return str.substring(si,si+ml);
    }
    public static void main(String[] args) throws Exception
    {
        new SmallestDistinctWindow().run();
    }
}
