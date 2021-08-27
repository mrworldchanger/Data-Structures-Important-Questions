import java.util.Scanner;

public class AllCharacterString
{
    private void run() {
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();

        while(test > 0){
            String s = scan.next();
            String t = scan.next();
            System.out.println(smallestWindow(s,t));
            test--;
        }
    }
    private String smallestWindow(String s, String t)
    {
        int []map = new int[256];
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int count = 0;
        for (int i = 0; i < t.length(); i++) {
            if (map[t.charAt(i)] == 0)
                count++;
            map[t.charAt(i)]++;
        }
        int i=0,j=0;
        while (j < s.length())
        {
            map[s.charAt(j)]--;
            if (map[s.charAt(j)] == 0)
                count--;
            if (count==0)
            {
                while (count==0)
                {
                    if (ans>j-i+1)
                    {
                        ans= Math.min(ans, j - i + 1);
                        start = i;
                    }
                    map[s.charAt(i)]++;
                    if (map[s.charAt(i)] > 0)
                        count++;
                    i++;
                }
            }
            j++;
        }
        if (ans != Integer.MAX_VALUE)
            return s.substring(start, ans+start);
        else
            return "-1";
    }
    public static void main(String[] args) throws Exception
    {
        new AllCharacterString().run();
    }
}
