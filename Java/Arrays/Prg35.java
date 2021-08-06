import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prg35
{
    public static void main(String[] args) throws Exception
    {
        new Prg35().run();
    }
    private void run() throws Exception
    {
        BufferedReader op=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(op.readLine());
        while(t-- != 0)
        {
            String input=op.readLine();
            String []val=input.trim().split(" ");
            int[] arr=new int[Integer.parseInt(val[0])];
            input=op.readLine();
            val=input.trim().split(" ");
            for(int i=0;i<arr.length;i++)
                arr[i]=Integer.parseInt(val[i]);
            System.out.println(median(arr));
        }
    }
    private int median(int []arr)
    {
        if(arr.length==1)
            return arr[0];
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
