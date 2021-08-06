/*
    Given an array of integers (A[])  and a number x, find the smallest subarray with sum greater than the given value.
    Note: The answer always exists. It is guaranteed that x doesn't exceed the summation of a[i] (from 1 to N).
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prg31
{
    public static void main(String[] args) throws Exception
	{
        new Prg31().run();
	}
	private void run() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            // int n = Integer.parseInt(br.readLine().trim());
            int []a = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(sb(a, n, m));
        }
    }
    private int sb(int []arr, int n, int x)
    {
        int sum=0;
        int length=Integer.MAX_VALUE;
        int start=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]==x)
                return x;
            sum+=arr[i];
            while(sum>x && start<=i)
            {
                length=Math.min(length,i-start+1);
                sum-=arr[start];
                start++;
            }
        }
        return length;
    }

}
