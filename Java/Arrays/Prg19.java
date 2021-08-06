//Given three arrays sorted in increasing order. Find the elements that are common in all three arrays.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Prg19
{
    private void run() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            /* int n;
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            n = Integer.parseInt(inputLine[0]);
            System.out.println(n);
            int[] A = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            n = Integer.parseInt(inputLine[0]);
            System.out.println(n);
            int[] B = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
            {
                B[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            n = Integer.parseInt(inputLine[0]);
            System.out.println(n);
            int[] C = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                C[i] = Integer.parseInt(inputLine[i]);
            }
            */
            int[] A = { 1, 5, 10, 20, 40, 80, 100, 100 };
            int[] B = { 6, 7, 20, 80, 100, 100 };
            int[] C = { 3, 4, 15, 20, 30, 70, 80, 100, 100, 120 };
            ArrayList<Integer> res = commonElements(A, B, C);
            if (res.size() == 0)
            {
                System.out.print(-1);
            }
            else
            {
                for (Integer re : res) {
                    System.out.print(re + " ");
                }
            }
            System.out.println();
        }
    }
    private ArrayList<Integer> commonElements(int[] arr1, int[] arr2, int[] arr3)
    {
        ArrayList<Integer> com = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        int last = 0;
        while (i < arr1.length && j < arr2.length && k < arr3.length)
        {

            if (arr1[i] > arr2[j] && arr1[i] > arr3[k])
            {
                j++;
                k++;
            }
            else if (arr2[j] > arr1[i] && arr2[j] > arr3[k])
            {
                i++;
                k++;
            }
            else if (arr3[k] > arr1[i] && arr3[k] > arr2[j])
            {
                i++;
                j++;
            }
            else if (arr1[i] == arr2[j] && arr1[i] == arr3[k])
            {
                if (last != arr1[i])
                    com.add(arr1[i]);
                last = arr1[i];
                i++;
                k++;
                j++;
            }
            else if (arr1[i] < arr2[j] || arr1[i] < arr3[k])
            {
                i++;
            }
            else if (arr2[j] < arr1[i] || arr2[j] < arr3[k])
            {
                j++;
            }
            else if (arr3[k] < arr1[i] || arr3[k] < arr2[j])
            {
                k++;
            }
        }
        return com;
    }
    public static void main(String[] args) throws Exception
    {
        new Prg19().run();
    }
}
