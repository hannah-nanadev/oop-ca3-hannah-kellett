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
        Stack<Pair> pairs = new Stack<>();

        for(int i = 0; i<arr[0].length; i++) //Assumes square matrix
        {
            pairs.push(new Pair(arr, i, i));
        }

        int j = 1;

        int pairNo = 0;

        while(!pairs.isEmpty())
        {
            Pair current = pairs.pop();

            for(int i = 0; i<current.getLength(); i++)
            {
                if(current.getRowValue(i)==0)
                {
                    current.setRowValue(i, j);
                }
                if(current.getColumnValue(i)==0)
                {
                    current.setColValue(i, j);
                }
            }

            j++;

            current.copyToRow(pairNo, arr);
            current.copyToColumn(pairNo, arr);

            pairNo++;

        }

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
