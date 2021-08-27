import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

public class AllSentences
{
    static int row;
    static int col;
    private void run() throws Exception
    {
        BufferedReader op=new BufferedReader(new InputStreamReader(System.in));
        row=Integer.parseInt(op.readLine());
        col=Integer.parseInt(op.readLine());
        String [][]val=new String[row][col];
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                val[i][j]=op.readLine();
        printAll(val);
    }
    private void printAll(String [][]str)
    {
        String []output = new String[row];
        for (int i = 0; i < col; i++)
            if (!Objects.equals(str[0][i], ""))
                display(str, 0, i, output);
    }
    private void display(String [][]str,int a,int b,String []ot)
    {
        ot[a] = str[a][b];
        if (a == row - 1)
        {
            for (int i = 0; i < row; i++)
                System.out.print(ot[i] + " ");
            System.out.println();
            return;
        }
        for (int i = 0; i < col; i++)
            if (!Objects.equals(str[a + 1][i], "") && a < col)
                display(str, a + 1, i, ot);
    }
    public static void main(String[] args) throws Exception
    {
        new AllSentences().run();
    }
}
