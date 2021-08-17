import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NextGreatestNumber
{
    private void run() throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(in.readLine());
            String []a = in.readLine().trim().split("\\s+");
            int []arr = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            List<Integer> ans;
            ans = permute(arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i)).append(" ");
            System.out.println(out);
        }
    }
    public List<Integer> permute(int[] nums)
    {
        List<Integer> op=new ArrayList<>();
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i])
        {
            i--;
        }
        if (i >= 0)
        {
            int j = nums.length - 1;
            while (nums[j] <= nums[i])
            {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
        for(int val: nums)
            op.add(val);
        return op;
    }

    private void reverse(int[] nums, int start)
    {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) throws Exception
    {
        new NextGreatestNumber().run();
    }
}

