import java.io.BufferedReader;
import java.io.InputStreamReader;

//Program to Find duplicate in an array of N+1 Integers
public class Prg11
{
    private int findDuplicate(int[] nums)
    {
        int n = nums.length;
        for(int i=0; i<n; i++)
        {
            nums[nums[i]%n]=nums[nums[i]%n]+n;
        }
        System.out.println();
        for(int i=0; i<n; i++)
        {
            if(nums[i]/n>1)
            {
                return i;
            }
        }
        return -1;
    }
    private void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0)
        {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = findDuplicate(arr);
            System.out.println(ans);
        }
    }
    public static void main(String[] args) throws Exception
    {
        new Prg11().run();
    }
}
