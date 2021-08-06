//Rearrange array in alternating positive & negative items with O(1) extra space
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prg20
{
	private void run() throws Exception
    {
        BufferedReader op=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(op.readLine());
        while(n-- > 0)
        {
            /* String line=op.readLine();
            String []val=line.trim().split("\\s+");
            int size=Integer.parseInt(val[0]);
            line=op.readLine();
            val=line.trim().split("\\s+");
            int[] arr =new int[size];
            for(int i=0;i<size;i++)
                arr[i]=Integer.parseInt(val[i]); */
			int[] arr = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
			display(arr);
            display(arrange(arr));	
        }
    }
	private int [] arrange(int[] arr)
	{
		int n=arr.length;
		int i = 0, j = n - 1;

		// shift all negative values to the end
		while (i < j)
		{
			while(i <= n - 1 && arr[i] > 0)
				i += 1;
			while (j >= 0 && arr[j] < 0)
				j -= 1;
			if (i < j)
			{
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}

		}

		// i has index of leftmost negative element
		if (i == 0 || i == n)
			return arr;

		// start with first positive
		// element at index 0

		// Rearrange array in alternating positive &
		// negative items
		int k = 0;
		while (k < n && i < n)
		{
			// swap next positive element
			// at even position
			// from next negative element.
			int temp=arr[k];
			arr[k]=arr[i];
			arr[i]=temp;
			i = i + 1;
			k = k + 2;
		}
		return arr;
	}
	private void display(int [] arr)
	{
		System.out.println();
		for(int j : arr)
		{
			System.out.print(j+" ");
		}
		System.out.println();
	}
    public static void main(String [] args) throws Exception
    {
        new Prg20().run();
    }
}
