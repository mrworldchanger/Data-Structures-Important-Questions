import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SearchWordGrid
{
    private void run() throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            int[][] ans = searchWord(grid, word);
            for (int[] an : ans)
            {
                for (int i : an)
                {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
    private int[][] searchWord(char [][]grid ,String word)
    {
        ArrayList<Integer> xa=new ArrayList<>();
        ArrayList<Integer> ya=new ArrayList<>();
        for (int row = 0; row < grid.length; row++)
        {
            for (int col = 0; col < grid[row].length; col++)
            {
                if (search2D(grid, row, col, word))
                {
                    xa.add(row);
                    ya.add(col);
                }
            }
        }
        if(xa.size()==0)
            return new int[0][0];
        else
        {
            int [][]arr=new int [xa.size()][2];
            for(int i=0;i<xa.size();i++)
            {
                arr[i][0]=xa.get(i);
                arr[i][1]=ya.get(i);
            }
            return arr;
        }
    }
    private boolean search2D(char [][]grid ,int row ,int col,String word)
    {
        if (grid[row][col] != word.charAt(0))
            return false;
        int R=grid.length;
        int C=grid[0].length;
        int len = word.length();
        int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };
        for (int dir = 0; dir < 8; dir++)
        {
            int k, rd = row + x[dir], cd = col + y[dir];
            for (k = 1; k < len; k++)
            {
                if (rd >= R || rd < 0 || cd >= C || cd < 0)
                    break;
                if (grid[rd][cd] != word.charAt(k))
                    break;
                rd += x[dir];
                cd += y[dir];
            }
            if (k == len)
                return true;
        }
        return false;
    }
    public static void main(String[] args) throws Exception
    {
        new SearchWordGrid().run();
    }
}
