//Program to Find The Next Permutation in Lexicographical Order(Dictionary Format)
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prg15
{
    private void run() throws Exception
    {
        BufferedReader op=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(op.readLine());
        while(n-- > 0)
        {
            String line=op.readLine();
            String []val=line.trim().split("\\s+");
            int size=Integer.parseInt(val[0]);
            line=op.readLine();
            val=line.trim().split("\\s+");
            int[] arr =new int[size];
            for(int i=0;i<size;i++)
                arr[i]=Integer.parseInt(val[i]);
            permute(arr);
        }
    }
    private void permute(int [] arr)
    {
        int i=arr.length-2,j;
        while(i>=0 && arr[i+1]<=arr[i])
            i--;
        if(i>=0)
        {
            j=arr.length-1;
            while(arr[i]>=arr[j])
                j--;
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        reverse(arr,i+1,arr.length-1);
        System.out.println();
        for (int val : arr) System.out.print(val+" ");

    }
    private void reverse(int [] arr,int l,int h)
    {
        while(l<h)
        {
            int temp=arr[l];
            arr[l]=arr[h];
            arr[h]=temp;
            l++;
            h--;
        }
    }
    public static void main(String[] args) throws Exception
    {
        new Prg15().run();
    }
}
