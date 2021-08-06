//Given an array of positive integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Prg24
{
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }
    }
    private void run() {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();

        while(t>0)
        {
            int n = sc.nextInt();
            int[] a = new int[n];

            for(int i=0; i<n; i++)
                a[i] = sc.nextInt();
            out.println(findLongestConsesSubsets(a));
            t--;
        }
        out.flush();
    }
    int findLongestConsesSubsets(int[] arr)
    {
        Set<Integer> hashSet = new HashSet<>();
        for (int val : arr)
            hashSet.add(val);
        int max = 0;
        for (int val : arr)
        {
            if (!hashSet.contains(val - 1))
            {
                int curNum = val;
                int curSt = 1;
                while (hashSet.contains(curNum + 1))
                {
                    curNum += 1;
                    curSt += 1;
                }
                max = Math.max(max, curSt);
            }
        }
        return max;
    }

    public static void main(String[] args) throws Exception
    {
        new Prg24().run();
    }
}
