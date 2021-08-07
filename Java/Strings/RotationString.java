import java.io.BufferedReader;
import java.io.InputStreamReader;

//A Program to check if strings are rotations of each other or not
public class RotationString
{
    public static void main(String[] args) throws Exception
    {
        new RotationString().run();
    }
    private void run() throws Exception
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0)
        {
            String S = read.readLine();
            String []val=S.trim().split(" ");
            if (rotation(val[0],val[1]))
                System.out.println("Strings are rotations of each other");
            else
                System.out.println("Strings are not rotations of each other");
        }
    }
    private boolean rotation(String str1 , String str2)
    {
        return ((str1.length()==str2.length()) &&((str1 + str2).contains(str2)) );
    }
}
