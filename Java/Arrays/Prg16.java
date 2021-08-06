//Program Given an array of integers. Find the Inversion Count in the array.
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prg16
{
    public int mergesort(int[] arr,int low,int high)
    {
        int count=0;
        if(low<high)
        {
            int mid=low+(high-low)/2;
            count+=mergesort(arr,low,mid);
            count+=mergesort(arr,mid+1,high);
            count+=merge(arr,low,mid,high);
        }
        return count;
    }
    private int merge(int[]arr, int l, int m, int h)
    {
        int []p1=new int[m-l+1];
        int []p2=new int[h-m];
        {
            int i=0;
            while (i<p1.length) {
                p1[i]=arr[l+i];
                i++;
            }
        }
        {
            int i=0;
            while (i< p2.length) {
                p2[i]=arr[m+i+1];
                i++;
            }
        }
        int i,j,k,co;
        i=j=co=0;
        k=l;
        while(i<p1.length && j<p2.length)
        {
            if(p1[i]<=p2[j])
            {
                arr[k++]=p1[i++];
            }
            else
            {
                arr[k++]=p2[j++];
                co=co+(m+1)-(l+i);
                //System.out.println(co);
            }
        }
        while(i<p1.length)
        {
            arr[k++]=p1[i++];
        }
        while(j<p2.length)
        {
            arr[k++]=p2[j++];
        }
        return co;
    }
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
           System.out.println(mergesort(arr,0,arr.length-1));
        }
    }
    public static void main(String[] args) throws Exception
    {
        new Prg16().run();
    }
}
