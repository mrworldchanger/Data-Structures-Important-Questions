//Given an array arr[] of N non-negative integers representing the height of blocks. If width of each block is 1, compute how much water can be trapped between the blocks
//during the rainy season.

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prg29
{
    public static void main (String[] args) throws Exception
    {
        new Prg29().run();
    }
    private void run() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){

            //size of array
            int n = Integer.parseInt(br.readLine().trim());
            int [] arr = new int[n];
            String []inputLine = br.readLine().trim().split(" ");

            //adding elements to the array
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            //calling trappingWater() function
            System.out.println(trappingWater(arr, n));
        }
    }
    private int trappingWater(int[] arr, int n)
    {
        if(n<=2)
            return 0;
        int maxleft=arr[0];
        int maxright=arr[n-1];
        int left=1;
        int right=n-2;
        int water=0;
        while(left<=right)
        {
            if(maxleft < maxright)
            {
                if(maxleft<arr[left])
                    maxleft=arr[left];
                else
                    water+=maxleft-arr[left];
                left++;
            }
            else
            {
                if(maxright <arr[right])
                    maxright=arr[right];
                else
                    water+=maxright-arr[right];
                right--;
            }
        }
        return water;
    }
}
