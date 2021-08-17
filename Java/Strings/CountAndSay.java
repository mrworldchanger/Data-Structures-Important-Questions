import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountAndSay
{
    private String count(int n)
    {
        // Base cases
        if (n == 1)
            return "1";
        if (n == 2)
            return "11";
        StringBuilder str = new StringBuilder("11");
        for (int i = 3; i <= n; i++)
        {
            str.append('$');
            int len = str.length();
            int cnt = 1;
            StringBuilder tmp = new StringBuilder(); // Initialize i'th
            char []arr = str.toString().toCharArray();
            for (int j = 1; j < len; j++)
            {
                if (arr[j] != arr[j - 1])
                {
                    tmp.append(cnt);
                    tmp.append(arr[j - 1]);
                    cnt = 1;
                }
                else
                    cnt++;
            }
            str = new StringBuilder(tmp.toString());
        }

        return str.toString();
    }
    private void run() throws Exception
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0)
        {
            int num=Integer.parseInt(read.readLine());
            System.out.println(count(num));
        }
    }
    public static void main(String[] args) throws Exception
    {
        new CountAndSay().run();
    }

}
