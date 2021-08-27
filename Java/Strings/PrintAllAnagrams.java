import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PrintAllAnagrams
{
    private void run() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine().trim());
        while(t > 0)
        {
            int n= Integer.parseInt(br.readLine().trim());
            String x = br.readLine().trim();
            String []string_list  = x.split(" ",n);

            List <List<String>> ans = anagrams(string_list);

            Collections.sort(ans, (l1, l2) -> {
                String s1 =  l1.get(0);
                String s2 =  l2.get(0);
                return s1.compareTo(s2);
            });

            for (List<String> an : ans) {
                for (String s : an) {
                    System.out.print(s + " ");
                }
                System.out.println();
            }
            t--;
        }
    }
    private List<List<String>> anagrams(String[] text)
    {
        HashMap<String,List<String>> hash = new HashMap<>();
        for (String value : text)
        {
            char[] c = value.toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            if (!hash.containsKey(s))
            {
                hash.put(s, new ArrayList<>());
            }
            hash.get(s).add(value);
        }
        List<List<String>> ret = new ArrayList<>();
        Set<String> set = hash.keySet();
        for(String s:set)
        {
            ret.add(hash.get(s));
        }
        return ret;
    }
    public static void main(String[] args) throws IOException
    {
        new PrintAllAnagrams().run();
    }
}
