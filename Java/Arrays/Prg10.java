import java.io.BufferedReader;
import java.io.InputStreamReader;

//Program to Minimum no. of Jumps to reach end of an array
public class Prg10
{
    private int calculate(int []arr)
    {
        if(arr.length==0)
            return -1;
        else if (arr[0]==0)
            return -1;
        else if(arr.length==1)
            return 0;
        else
        {
            int halt=0,max=0;
            int jump=0;
            for(int i=0;i<arr.length-1;i++)
            {
                max=Math.max(max,i+arr[i]);
                if(max>=arr.length-1)
                {
                    jump++;
                    return jump;
                }
                else if(i==halt)
                {
                    halt=max;
                    jump++;
                }
            }
            if(halt>=arr.length-1)
            {
                return jump;
            }
            return -1;
        }
    }
    private void run() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = br.readLine().split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(calculate(arr));
        }
    }
    public static void main(String[] args) throws Exception
    {
        new Prg10().run();
    }
}
