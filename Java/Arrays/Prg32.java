/*
    Given an array of size n and a range [a, b]. The task is to partition the array around the range such that array is divided into three parts.
    1) All elements smaller than a come first.
    2) All elements in range a to b come next.
    3) All elements greater than b appear in the end.
    The individual elements of three sets can appear in any order. You are required to return the modified array.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Prg32
{
    public static void main(String[] args)throws Exception
    {
        new Prg32().run();
    }
    private void run() throws Exception
    {
        BufferedReader read= new BufferedReader(new InputStreamReader(System.in));
        int t  =Integer.parseInt(read.readLine());

        while(t-->0)
        {
            int N = Integer.parseInt(read.readLine());
            int[] array = new int[N];
            Map<Integer, Integer> mp = new HashMap<>();

            String[] input_line = read.readLine().trim().split(" ");
            for(int i=0;i<N;i++)
            {
                array[i] = Integer.parseInt(input_line[i]);
                if (mp.containsKey(array[i]))
                {
                    mp.put(array[i], mp.get(array[i]) + 1);
                }
                else
                {
                    mp.put(array[i], 1);
                }
            }

            input_line = read.readLine().trim().split(" ");
            int a = Integer.parseInt(input_line[0]);
            int b = Integer.parseInt(input_line[1]);

            int[] original = new int[N];

            System.arraycopy(array, 0, original, 0, N);

            int k1=0,k2=0,k3=0;
            int kk1=0;int kk2=0;int kk3=0;

            for(int i=0;i<N;i++)
            {
                if(original[i]>b)
                    k3++;
                else if(original[i]<=b && original[i]>=a)
                    k2++;
                else if(original[i]<b)
                    k1++;
            }
            threeWayPartition(array,a,b);

            for(int i=0;i<k1;i++)
            {
                if(array[i]<b)
                    kk1++;
            }

            for(int i=k1;i<k1+k2;i++)
            {
                if(array[i]<=b && array[i]>=a)
                    kk2++;

            }

            for(int i=k1+k2;i<k1+k2+k3;i++)
            {
                if(array[i]>b)
                    kk3++;
            }
            boolean ok = k1 == kk1 && k2 == kk2 && k3 == kk3;

            for (int j : array) mp.put(j, mp.get(j) - 1);

            for (int j : array)
                if (mp.get(j) != 0)
                    ok = false;

            if(ok)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
    public void threeWayPartition(int[] array, int a, int b)
    {
        int i=0;
        int start=0,end= array.length-1;
        while(i<=end)
        {
            if(array[i] < a)
            {
                int temp=array[start];
                array[start]=array[i];
                array[i]=temp;
                start+=1;
                i+=1;
            }
            else if(array[i] > b)
            {
                int temp=array[end];
                array[end]=array[i];
                array[i]=temp;
                end--;
            }
            else
                i++;
        }
    }

}
