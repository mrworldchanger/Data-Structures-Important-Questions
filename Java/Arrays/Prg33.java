// Given an array of n positive integers and a number k. Find the minimum number of swaps required to bring all the
// numbers less than or equal to k together.

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prg33
{
	public static void main (String[] args) throws Exception
	{
		new Prg33().run();
	}
	private void run() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testcases = Integer.parseInt(br.readLine());

		// looping through all testcases
		while(testcases-- > 0){
			String line = br.readLine();
			String[] element = line.trim().split("\\s+");
			int sizeOfArray = Integer.parseInt(element[0]);

			int[] arr = new int[sizeOfArray];

			line = br.readLine();
			String[] elements = line.trim().split("\\s+");
			for(int i = 0;i<sizeOfArray;i++){
				arr[i] = Integer.parseInt(elements[i]);
			}
			int K = Integer.parseInt(br.readLine());

			int ans = minSwap(arr, sizeOfArray, K);
			System.out.println(ans);
		}
	}
    // Function for finding maximum and value pair
    public int minSwap (int[] arr, int n, int k)
    {
        int count=0;
        for(int j: arr)
        {
			if(j<=k)
				++count;
		}
        int bad=0;
        for(int j=0;j<count;j++)
		{
			if(arr[j]>k)
				bad++;
		}
        int ans=bad;
        for(int i=0,j=count;j<n;i++,j++)
		{
			if(arr[i]>k)
				bad--;
			if(arr[j]>k)
				bad++;
			ans=Math.min(ans,bad);
		}
        return ans;
    }
}
