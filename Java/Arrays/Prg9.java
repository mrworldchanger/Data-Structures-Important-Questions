import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//Program to Minimise the maximum difference between heights [V.IMP]
public class Prg9
{
    private void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = getMinDiff(arr,k);
            System.out.println(ans);
        }
    }
    private int getMinDiff(int []arr,int k)
    {
         int n= arr.length;
         Arrays.sort(arr);
         int ini=arr[n-1]-arr[0];
         int max,min;
         for(int i=1;i<arr.length;i++)
         {
             if(arr[i]>=k)
             {
                 max=Math.max(arr[i-1]+k,arr[n-1]+k);
                 min=Math.min(arr[i]-k,arr[0]+k);
                 ini=Math.min(ini,max-min);
             }
         }
         return ini;
    }
    public static void main(String[] args) throws Exception
    {
        new Prg9().run();
    }
}
