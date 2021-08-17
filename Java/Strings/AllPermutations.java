import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AllPermutations
{
    private void run() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            List<String> ans = find_permutation(S);
            for (String an : ans) {
                System.out.print(an + " ");
            }
            System.out.println();
        }
    }
    private List<String> find_permutation(String str)
    {
        List<String> op= new ArrayList<>();
        permute(str,0,str.length()-1,op);
        return op;
    }

    private void permute(String str, int l, int r,List op)
    {
        if (l == r)
            op.add(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r,op);
                str = swap(str,l,i);
            }
        }
    }
    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) throws Exception
    {
        new AllPermutations().run();
    }
}
