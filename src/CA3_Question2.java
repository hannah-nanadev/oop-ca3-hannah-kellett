import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Hannah Kellett
 *  Class Group: GD2B
 */
public class CA3_Question2
{
    /*
        Starter function to create the 2D array and populate it with 0

     */
    public static int[][]  floodFillStart() {
        Scanner kb = new Scanner(System.in);
        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                arr[x][y] = 0;
            }
        }
       return arr;
    }
    /*
        Helper function to display the image
     */
    public static void display(int[][] arr)
    {
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }
    private static void floodFill(int[][] arr)
    {
        Stack<Cell> cells = new Stack<>();

        cells.push(new Cell(0, 0));
        int i = 1;

        while(!cells.isEmpty()&&arrContains(arr, 0))
        {
            Cell current = cells.pop();
            int x = current.getX(); int y = current.getY();
            arr[x][y] = i;

            //Check if neighbours are there and are equal to 0
            if(x<9&&arr[x+1][y]==0)
            {
                cells.push(new Cell(x+1, y));
            }
            if(y<9&&arr[x][y+1]==0)
            {
                cells.push(new Cell(x, y+1));
            }
            if(x>0&&arr[x-1][y]==0)
            {
                cells.push(new Cell(x-1, y));
            }
            if(y>0&&arr[x][y-1]==0)
            {
                cells.push(new Cell(x, y-1));
            }

            i++;

        }

    }

    private static boolean arrContains(int[][] arr, int a)
    {
        int max = arr[0].length;
        boolean result = false;

        for(int i = 0; i<max; i++)
        {
            for(int j = 0; j<max; j++)
            {
                if(arr[i][j]==a)
                {
                    result = true;
                }
            }
        }

        return result;
    }

    public static void start()
    {
        int[][] arr = floodFillStart();
        floodFill(arr);

        display(arr);

    }

    public static void main(String[] args) {
        start();
    }

}
