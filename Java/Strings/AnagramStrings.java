//Program to Find Anagrams From Given String Array in Sorted Array
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AnagramStrings
{
    public static void main(String []args) throws Exception
    {
        new AnagramStrings().run();
    }
    public void run() throws Exception
    {
        BufferedReader op=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(op.readLine());
        while(t-- > 0)
        {
            String input=op.readLine();
            String []val=input.trim().split(" ");
            ArrayList<String> list =new ArrayList<>();
            Collections.addAll(list, val);
            System.out.println(anagrams(list));
        }
        /*ArrayList<String> list =new ArrayList<>();
        list.add("poke");
        list.add("okpe");
        list.add("kope");
        list.add("lust");
        list.add("ustl");
        list.add("anagrams");
        list.add("aangarms");
        System.out.println(list);
        System.out.println(anagrams(list));*/

    }
    private ArrayList<String> anagrams(ArrayList<String> text)
    {
        boolean []con= new boolean[text.size()];
        ArrayList<String> ret=new ArrayList<>();
        Arrays.fill(con,false);
        for(int i=0;i<text.size();i++)
        {
            if(con[i])
                continue;
            con[i]=true;
            ret.add(text.get(i));
            for(int j=i+1;j<text.size();j++)
            {
                if(text.get(i).length() == text.get(j).length())
                {
                    boolean val = check(text.get(i), text.get(j));
                    if (val)
                       con[j]=true;
                }
            }
        }
        Collections.sort(ret);
        return ret;
    }
    private boolean check(String str1,String str2)
    {
        for(int i= str1.length()-1;i>=0;i--)
            System.out.println(str1.charAt(i));
        ArrayList <Character> st1 =new ArrayList<>();
        for(int i=0;i<str1.length();i++)
            st1.add(str1.charAt(i));
        for(int i=0;i<str1.length();i++)
        {
            if(!st1.contains(str2.charAt(i)))
                return false;
        }
        return true;
    }
}
