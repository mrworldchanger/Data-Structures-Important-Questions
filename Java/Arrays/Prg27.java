/*
     Given two arrays: a1[0..n-1] of size n and a2[0..m-1] of size m.
     Task is to check whether a2[] is a subset of a1[] or not.
     Both the arrays can be sorted or unsorted. It may be assumed
     that elements in both array are distinct.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Prg27
{
    public static void main(String[] args) throws Exception
    {
        new Prg27().run();
    }
    private void run() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());

            long n = Long.parseLong(stt.nextToken());
            long m = Long.parseLong(stt.nextToken());
            long[] a1 = new long[(int)(n)];
            long[] a2 = new long[(int)(m)];


            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a1[i] = Long.parseLong(inputLine[i]);
            }
            String[] inputLine1 = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                a2[i] = Long.parseLong(inputLine1[i]);
            }
            System.out.println(isSubset(a1,a2));
        }
    }
    private String isSubset(long[] arr1, long[] arr2)
    {
        HashSet <Long> op=new HashSet<>();
        for (long l : arr1)
            op.add(l);
        for (long l : arr2)
        {
            if (!op.contains(l))
                return "No";
        }
        return "Yes";
    }
}
