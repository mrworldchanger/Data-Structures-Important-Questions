import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountStringOccurrenceArray
{
    public static void main(String[] args) throws Exception
    {
        new CountStringOccurrenceArray().run();
    }
    private void run() throws Exception
    {
        BufferedReader op=new BufferedReader(new InputStreamReader(System.in));
        int t;
        String []arr={ "BBABBM", "CBMBBA","IBABBG", "GOZBBI", "ABBBBC", "MCIGAM" };
        String []demo;
        String str;
        System.out.println("Given Grid - ");
        display(arr);
        //str=op.readLine();
        //arr=str.trim().split(" ")
        demo=arr.clone();
        t=Integer.parseInt(op.readLine());
        while(t-- > 0)
        {
            str=op.readLine();
            System.out.println("Given Input String \""+str+"\" Found "+solve(str,demo)+" Times");
        }
    }
    private void display(String []grid)
    {
        for(int i=0;i< grid.length;i++)
        {
            for(int j=0;j<grid[i].length();j++)
            {
                System.out.print("  "+grid[i].charAt(j)+"\t");
            }
            System.out.println();
        }
    }
    private int solve(String input,String []grid)
    {
        int found=0;
        int r_max=grid.length;
        int c_max=grid[0].length();
        for(int i=0;i<r_max;i++)
        {
            for(int j=0;j<c_max;j++)
            {
                found+=find(input,grid,i,j,r_max-1,c_max-1,0);
            }
        }
        return found;
    }
    private int find(String input, String[] grid, int row, int col, int row_max, int col_max, int ind )
    {
        int found=0;
        if (row >= 0 && row <= row_max && col >= 0 && col <= col_max && ind < input.length() && input.charAt(ind) == grid[row].charAt(col))
        {
            char match = input.charAt(ind);
            ind += 1;
            grid[row] = grid[row].substring(0, col) + "0" + grid[row].substring(col + 1);
            if (ind == input.length())
            {
                found = 1;
            }
            else
            {
                found += find(input, grid, row, col + 1, row_max, col_max,ind);
                found += find(input, grid, row, col - 1, row_max, col_max,ind);
                found += find(input, grid, row + 1, col, row_max, col_max,ind);
                found += find(input, grid, row - 1, col, row_max, col_max,ind);
            }

            grid[row] = grid[row].substring(0, col) +  match + grid[row].substring(col + 1);
        }
        return found;
    }
}
