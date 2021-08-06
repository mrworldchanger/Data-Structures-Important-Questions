//Given an array arr of size n and an integer X. Find if there's a triplet in the array which sums up to the given integer X.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Prg28
{
    public static void main (String[] args) throws Exception
    {
        new Prg28().run();
    }
    private void run() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            String[] inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int X = Integer.parseInt(inputLine[1]);
            int[] A = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++) {
                A[i] = Integer.parseInt(inputLine[i]);
            }
            boolean ans = find3Numbers(A, n, X);
            System.out.println(ans?1:0);
        }
    }
    private boolean find3Numbers(int []arr,int n,int target)
    {
        HashSet<Integer> op=new HashSet<>();
        for(int i=0;i<n-2;i++)
        {
            int curr=target-arr[i];
            for(int j=i+1;j<n;j++)
            {
                if(op.contains(curr-arr[j]))
                    return true;
                op.add(arr[j]);
            }
        }
        return false;
    }
}
