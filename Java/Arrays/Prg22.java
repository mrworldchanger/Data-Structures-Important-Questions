//Program to Find the Factorial of the Large Number
import java.util.Scanner;

public class Prg22
{
    private void run()
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int N = sc.nextInt();
            factorial(N);
            System.out.println();
        }
    }
    private void factorial(int N)
    {
        byte[] arr =new byte[10000];
        arr[0]=1;
        int i, j, temp, carry = 0;
        int length= 1;
        for(i = 2; i <= N; i++)
        {
            for(j = 0; j < length; j++)
            {
                temp = carry + arr[j] * i;
                carry = temp / 10;
                arr[j]=(byte)(temp % 10);
            }
            while(carry!=0)
            {
                arr[j]=(byte)(carry % 10);
                carry /= 10;
                j++;
            }
            length=j;
        }
        for(i= length-1; i >= 0; i--){
            System.out.printf("%d", arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new Prg22().run();
    }
}
