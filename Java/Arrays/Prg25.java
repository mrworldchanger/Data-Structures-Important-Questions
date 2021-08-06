//Given an array of size n and a number k, find all elements that appear more than n/k times
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Prg25
{
    public static void main(String[] args) throws Exception
    {
        new Prg25().run();
    }
    private void run() throws Exception
    {
        BufferedReader op = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(op.readLine());
        int []arr;
        int n,k;
        while(t-- > 0)
        {
            n=Integer.parseInt(op.readLine());
            arr=new int[n];
            String str=op.readLine();
            String []val=str.trim().split(" ");
            for(int i=0;i<arr.length;i++)
            {
                arr[i]=Integer.parseInt(val[i]);
            }
            k=Integer.parseInt(op.readLine());
            System.out.println(repeat(arr,n/k));
        }
    }
    private Set<Integer> repeat(int[] a, int occur)
    {
        HashMap<Integer,Integer> temp=new HashMap<>();
        int count;
        for (int j : a)
        {
            count = 0;
            if (!temp.containsKey(j))
            {
                temp.put(j, count + 1);
            }
            else
            {
                count = temp.get(j);
                temp.put(j, ++count);
            }
        }
        Set<Integer> temp2=new HashSet<>();
        for(Map.Entry val: temp.entrySet())
        {
            int key=(int)val.getKey();
            int value=(int)val.getValue();
            if(value>=occur)
                temp2.add(key);
        }
        return temp2;
    }
}
