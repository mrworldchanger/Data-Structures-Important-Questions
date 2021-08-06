//Given a Integer array A[] of n elements. Your task is to complete the function PalinArray. Which will return 1 if all the elements of the Array are palindrome otherwise it will return 0.

import java.util.Scanner;

public class Prg34
{
    public static void main(String[] args)
    {
        new Prg34().run();
    }
    private void run()
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0 ;i < n; i++)
                a[i]=sc.nextInt();
            System.out.println(new Prg34().palinArray(a));
        }
    }
    private int palinArray(int[] arr)
    {
        for(int n: arr)
        {
            if(n!=reverse(n))
                return 0;
        }
        return 1;
    }
    private int reverse(int num)
    {
        int rev=0;
        while(num>0)
        {
            rev=rev*10+num%10;
            num/=10;
        }
        return rev;
    }
}
