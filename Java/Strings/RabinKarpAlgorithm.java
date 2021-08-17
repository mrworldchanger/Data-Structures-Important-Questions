import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class RabinKarpAlgorithm
{
    public static void main(String[] args) throws Exception
    {
        new RabinKarpAlgorithm().run();
    }
    private void run() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            System.out.println(rba(S[0], S[1]));
        }
    }
    private HashMap<Integer ,Integer> rba(String pat,String txt)
    {
        int M = pat.length();
        int N = txt.length();
        final int d=256;
        final int q=113;
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h;
        HashMap<Integer ,Integer> op=new HashMap<>();
        h=(int)Math.pow(d, M-1)%q;
        for (i = 0; i < M; i++)
        {
            p = (d*p + pat.charAt(i))%q;
            t = (d*t + txt.charAt(i))%q;
        }
        for (i = 0; i <= N - M; i++)
        {
            if ( p == t )
            {
                for (j = 0; j < M; j++)
                {
                    if (txt.charAt(i+j) != pat.charAt(j))
                        break;
                }
                if (j == M)
                    op.put(i,i+M);
            }
            if ( i < N-M )
            {
                t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+M))%q;
                if (t < 0)
                    t = (t + q);
            }
        }
        return op;
    }
}
