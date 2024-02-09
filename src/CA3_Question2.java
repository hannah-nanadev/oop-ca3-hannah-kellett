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
        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                arr[x][y] = 0;
            }
        }

        arr[5][9] = -1; arr[6][6] = -1;
        arr[5][8] = -1; arr[7][6] = -1;
        arr[5][7] = -1; arr[8][6] = -1;
        arr[5][6] = -1; arr[9][6] = -1;

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
    private static void floodFill(int[][] arr, int startX, int startY)
    {
        Stack<Cell> cells = new Stack<>();

        cells.push(new Cell(startX, startY));
        int i = 1;

        while(!cells.isEmpty())
        {
            Cell current = cells.pop();
            int x = current.getX(); int y = current.getY();
            if(arr[x][y]==0)
            {
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

    }


    public static void start()
    {
        System.out.println("Flood fill 1 - outside the box");
        int[][] arr = floodFillStart();
        floodFill(arr, 5, 3);
        display(arr);

        System.out.println("Flood fill 2 - inside the box");
        int[][] arr2 = floodFillStart();
        floodFill(arr2, 7, 7);

        display(arr2);

    }

    public static void main(String[] args) {
        start();
    }

}
