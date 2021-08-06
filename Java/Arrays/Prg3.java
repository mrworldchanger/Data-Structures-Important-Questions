import java.io.BufferedReader;
import java.io.InputStreamReader;

//Find the Kth Maximum and Minimum Element in the Given Array.
public class Prg3
{
    int []a;
    int k;
    private void read() throws Exception
    {
        int n;
        BufferedReader op = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nEnter Size of the Array= ");
        n = Integer.parseInt(op.readLine());
        a = new int[n];
        System.out.println("Enter Values of the Array-");
        for(int i=0;i<a.length;i++)
            a[i]=Integer.parseInt(op.readLine());
        System.out.print("\nEnter the Value of Kth- ");
        k = Integer.parseInt(op.readLine());
    }
    private void run() throws Exception
    {
        read();
        System.out.print("\nEntered Array- ");
        display(a);
        mergesort(a,0,a.length-1);
        System.out.println();
        System.out.println(k+abb(k)+" Maximum Value of Given Array is "+a[a.length - k]);
        System.out.println(k+abb(k)+" Minimum Value of Given Array is "+a[k-1]);

    }
    private void display(int []arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]);
            if(i<arr.length-1)
                System.out.print(",");
        }
    }
    private void mergesort(int []arr,int low,int high)
    {
        if(low<high)
        {
            int mid = low +(high - low) /2;
            mergesort(arr,low,mid);
            mergesort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }
    private void merge(int[]arr, int l, int m, int h)
    {
        int n1=m-l+1;
        int n2=h-m;
        int []p1=new int[n1];
        int []p2=new int[n2];
        {
            int i=0;
            while (i<n1) {
                p1[i]=arr[l+i];
                i++;
            }
        }
        {
            int i=0;
            while (i<n2) {
                p2[i]=arr[m+i+1];
                i++;
            }
        }
        int i,j,k;
        i=j=0;
        k=l;
        while(i<n1 && j<n2)
        {
            if(p1[i]<=p2[j])
            {
                arr[k]=p1[i];
                i++;
            }
            else
            {
                arr[k]=p2[j];
                j++;
            }
            k++;
        }
        while(i<n1)
        {
            arr[k]=p1[i];
            i++;
            k++;
        }
        while(j<n2)
        {
            arr[k]=p2[j];
            j++;
            k++;
        }
    }
    private String abb(int n)
    {
        return switch (n % 10) {
            case 1 -> "st";
            case 2 -> "nd";
            case 3 -> "rd";
            default -> "th";
        };
    }
    public static void main(String[] args) throws Exception
    {
        new Prg3().run();
    }
}
