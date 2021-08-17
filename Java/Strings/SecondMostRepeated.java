import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class SecondMostRepeated
{
    private void run()
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String []arr = new String[n];
            for(int i = 0;i<n;i++)
                arr[i] = sc.next();
            System.out.println(secFrequent(arr));
        }
    }
    private String secFrequent(String[] arr)
    {
        HashMap<String, Integer> occ = new HashMap<>();
        for (String s : arr)
        {
            Integer j = occ.get(s);
            occ.put(s, (j == null) ? 1 : j + 1);
        }
        int first_max = Integer.MIN_VALUE, sec_max = Integer.MIN_VALUE;
        Iterator<Map.Entry<String, Integer>> itr = occ.entrySet().iterator();
        while (itr.hasNext())
        {
            Map.Entry<String, Integer> entry = itr.next();
            int v = entry.getValue();
            if( v > first_max) {
                sec_max = first_max;
                first_max = v;
            }

            else if (v > sec_max &&  v != first_max)
                sec_max = v;
        }
        itr = occ.entrySet().iterator();
        while (itr.hasNext())
        {
            Map.Entry<String, Integer> entry = itr.next();
            int v = entry.getValue();
            if (v == sec_max)
                return entry.getKey();
        }
        return null;
    }
    public static void main(String[] args)
    {
        new SecondMostRepeated().run();
    }
}
