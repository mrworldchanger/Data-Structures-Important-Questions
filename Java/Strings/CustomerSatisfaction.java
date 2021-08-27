import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CustomerSatisfaction
{
    private void run() throws Exception
    {
        BufferedReader op=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(op.readLine());
        while(t-- > 0)
        {
            String line=op.readLine();
            String []val=line.trim().split(" ");
            int n=Integer.parseInt(val[0]);
            System.out.println(simulation(n,val[1]));
        }
    }
    private int simulation(int n, String str)
    {
        int res = 0;
        int []occur=new int [26];
        int occ=0;
        for(int i=0;i<str.length();i++)
        {
            int ind=str.charAt(i) - 'A';
            if(occur[ind]==0)
            {
                occur[ind]=1;
                if(occ < n)
                {
                    occ++;
                    occur[ind]=2;
                }
                else
                    res++;
            }
            else
            {
                if(occur[ind]==2)
                    occ--;
                occur[ind]=0;
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception
    {
        new CustomerSatisfaction().run();
    }
}
