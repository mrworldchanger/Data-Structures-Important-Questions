import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prg36
{
    public static void main(String[] args) throws Exception
    {
        new Prg36().run();
    }
    private void run() throws Exception
    {
        BufferedReader op=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(op.readLine());
        while(t-- != 0)
        {
            String input=op.readLine();
            String []val=input.trim().split(" ");
            int[] arr1=new int[Integer.parseInt(val[0])];
            input=op.readLine();
            val=input.trim().split(" ");
            for(int i=0;i<arr1.length;i++)
                arr1[i]=Integer.parseInt(val[i]);
            input=op.readLine();
            val=input.trim().split(" ");
            int[] arr2=new int[Integer.parseInt(val[0])];
            input=op.readLine();
            val=input.trim().split(" ");
            for(int i=0;i<arr2.length;i++)
                arr2[i]=Integer.parseInt(val[i]);
            System.out.println(median(arr1,arr2));
        }
    }
    private int median(int []ar1,int []ar2)
    {
        int j=0;
        int []arr=new int [ar1.length+ar2.length];
        for (int k : ar1) {
            arr[j] = k;
            j++;
        }
        for (int k : ar2) {
            arr[j] = k;
            j++;
        }
        Arrays.sort(arr);
        int val;
        int index= arr.length/2;
        if(arr.length%2==0)
        {
            val=(arr[index]+arr[index+1])/2;
        }
        else
        {
            val=arr[index];
        }
        return val;
    }
}