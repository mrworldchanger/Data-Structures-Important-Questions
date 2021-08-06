/*
    Given an array A[ ] of positive integers of size N, where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates. There are M students, the task is to distribute chocolate packets among M students such that :
    1. Each student gets exactly one packet.
    2. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Prg30
{
    public static void main (String[] args)
    {
        new Prg30().run();
    }
    private void run()
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            long n = sc.nextLong();
            ArrayList<Long> arr = new ArrayList<>();
            for(int i = 0;i<n;i++)
            {
                long x = sc.nextInt();
                arr.add(x);
            }
            long m = sc.nextLong();

            System.out.println(findMinDiff(arr,n,m));
        }
    }
    private long findMinDiff (ArrayList<Long> a, long n, long m)
    {
        if(n<m)
            return -1;
        if(n==0 || m==0)
            return 0;
        Collections.sort(a);
        long min_diff=Long.MAX_VALUE;
        for(int i=0;i+m-1<a.size();i++)
        {
            long x1=a.get((int)(i+m-1));
            long x2= a.get(i);
            long diff = x1 - x2;
            if (diff < min_diff)
                min_diff = diff;
        }
        return min_diff;
    }
}
