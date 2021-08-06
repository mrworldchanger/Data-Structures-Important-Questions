//Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose sum is equal to K.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Prg18 {
    private void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = getPairsCount(arr, k);
            System.out.println(ans);
        }
    }
    private int getPairsCount(int []arr,int val)
    {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n=arr.length;
        // Store counts of all elements in map hm
        for (int i = 0; i < n; i++) {

            // initializing value to 0, if key not found
            if (!hm.containsKey(arr[i]))
                hm.put(arr[i], 0);

            hm.put(arr[i], hm.get(arr[i]) + 1);
        }
        int twice_count = 0;

        // iterate through each element and increment the
        // count (Notice that every pair is counted twice)
        for (int i = 0; i < n; i++) {
            if (hm.get(val - arr[i]) != null)
                twice_count += hm.get(val - arr[i]);

            // if (arr[i], arr[i]) pair satisfies the
            // condition, then we need to ensure that the
            // count is decreased by one such that the
            // (arr[i], arr[i]) pair is not considered
            if (val - arr[i] == arr[i])
                twice_count--;
        }

        // return the half of twice_count
        return twice_count / 2;
    }
    public static void main(String[] args) throws Exception
    {
        new Prg18().run();
    }
}
