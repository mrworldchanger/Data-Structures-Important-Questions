import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MinimumSwapBalanceBracket {
    private void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            System.out.println(minimumNumberOfSwaps(S));
            System.out.println(minimumNumberOfSwapsLess(S));
        }
    }

    private int minimumNumberOfSwaps(String str)
    {
        ArrayList<Integer> pos = new ArrayList<>();
        for(int i = 0; i < str.length(); ++i)
            if (str.charAt(i) == '[')
                pos.add(i);
        int count = 0;
        int p = 0;
        int sum = 0;
        char[] S = str.toCharArray();
        for(int i = 0; i < str.length(); ++i)
        {
            if (S[i] == '[')
            {
                ++count;
                ++p;
            }
            else if (S[i] == ']')
                --count;
            if (count < 0)
            {
                sum += pos.get(p) - i;
                char temp = S[i];
                S[i] = S[pos.get(p)];
                S[pos.get(p)] = temp;
                ++p;
                count = 1;
            }
        }
        return sum;
    }
    private int minimumNumberOfSwapsLess(String str)
    {
        char[] chars = str.toCharArray();
        int countLeft = 0, countRight = 0;
        int swap = 0 , imbalance = 0;
        for (char aChar : chars)
        {
            if (aChar == '[')
            {
                countLeft++;
                if (imbalance > 0)
                {
                    swap += imbalance;
                    imbalance--;
                }
            }
            else if (aChar == ']')
            {
                countRight++;
                imbalance = (countRight - countLeft);
            }
        }
        return swap;
    }
    public static void main(String[] args)throws IOException
    {
        new MinimumSwapBalanceBracket().run();
    }
}
