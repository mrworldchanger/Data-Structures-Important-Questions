import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//Program to Merge to Sorted Array with out Using Extra Space.
public class Prg12
{
    private void run() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0)
        {
            String[] inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[] arr1 = new int[n];
            int[] arr2 = new int[m];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                arr2[i] = Integer.parseInt(inputLine[i]);
            }

            new Prg12().merge(arr1, arr2);
        }
    }
    private void merge(int []arr1,int []arr2)
    {
        int n= arr1.length;
        int m= arr2.length;
        int i = 0, j = 0, k = n - 1;

        // Until i less than equal to k
        // or j is less tha m
        while (i <= k && j < m) {
            if (arr1[i] < arr2[j])
                i++;
            else
            {
                //swap(arr2[j++], arr1[k--]);
                int temp=arr2[j];
                arr2[j]=arr1[k];
                arr1[k]=temp;
                j++;
                k--;
            }
        }

        // Sort first array
        Arrays.sort(arr1);

        // Sort second array
        Arrays.sort(arr2);
       for (i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]+" ");
        }
        for (i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]+" ");
        }
    }
    public static void main(String[] args) throws Exception
    {
        new Prg12().run();
    }
}
