import java.util.Random;

/**
 *  Name: Hannah Kellett
 *  Class Group: GD2B
 */

/*
Direction enum used to indicate direction.
 */
enum DIRECTION {NORTH, SOUTH,EAST,WEST};

public class CA3_Question9 {

    public static void main(String[] args) {
        int[][] maze = mazeGen(7, 7);
        display(maze);
    }

    public static void display(int[][] image) {
        for (int x = 0; x < image.length; x++) {
            for (int y = 0; y < image[0].length; y++) {
                System.out.printf("%4d", image[x][y]);
            }
            System.out.println();
        }
    }

    public static int[][] mazeGen(int x, int y)
    { //Generates maze for rest of program to solve
        int[][] maze = new int[x][y];
        for(int i = 0; i<x; i++)
        {
            //Fill maze with 0, -1 at edges
            for(int j = 0; j<y; j++)
            {
                if(i==0||j==0||i==x-1||j==y-1)
                {
                    maze[i][j] = -1;
                }
                else{
                    maze[i][j] = 0;
                }
            }

            Random r = new Random();
            int side = r.nextInt(2);
            int side2 = r.nextInt(2);
            int pos;

            switch(side)
            {
                case 0:
                    pos = r.nextInt(x);

                    switch(side2)
                    {
                        case 0:
                            maze[0][pos] = 0;
                            break;
                        case 1:
                            maze[x-1][pos] = 0;
                            break;
                    }
                    break;
                case 1:
                    pos = r.nextInt(y);

                    switch(side2)
                    {
                        case 0:
                            maze[pos][0] = 0;
                            break;
                        case 1:
                            maze[pos][y-1] = 0;
                            break;
                    }
                    break;
            }
        }

        return maze;

    }

    public void solve(int x, int y, DIRECTION dir)
    {

    }
}
