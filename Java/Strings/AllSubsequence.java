import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class AllSubsequence
{
    private void run() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            ArrayList<String> op=new ArrayList<>();
            AS(str,"",op);
            op.sort(new Length());
            System.out.println("Total Number of All Subsequence is "+op.size()+"\nSubsequence are - ");
            System.out.println(op);
        }
    }
    private void AS(String str, String ans, ArrayList ret) {
        if (str.length() == 0) {
            ret.add(ans);
            return;
        }
        AS(str.substring(1), ans + str.charAt(0), ret);
        AS(str.substring(1), ans, ret);
    }
    public static void main(String[] args) throws Exception
    {
        new AllSubsequence().run();
    }
    class Length implements Comparator<String> {
        // Used for sorting in ascending order of
        // roll number
        public int compare(String a, String b) {
            return a.length() - b.length();
        }
    }
}