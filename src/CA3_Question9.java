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
        int[][] maze = mazeGen();
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

    public static int[][] mazeGen()
    { //Builds maze for rest of program to solve
        int[][] maze = new int[7][7];
        for(int i = 0; i<7; i++) {
            //Fill maze with 0, -1 at edges
            for (int j = 0; j < 7; j++) {
                if (i == 0 || j == 0 || i == 6 || j == 6) {
                    maze[i][j] = -1;
                } else {
                    maze[i][j] = 0;
                }
            }
        }

        maze[3][0] = 0; //add gap

        //Add some lines
        for(int i = 1; i<3; i++)
        {
            maze[2][i] = -1;
            maze[4][i] = -1;
        }

        for(int i = 4; i<6; i++)
        {
            maze[2][i] = -1;
            maze[4][i] = -1;
        }

        maze[1][1] = -1;
        maze[5][5] = -1;

        return maze;

    }

    public void solve(int x, int y, DIRECTION dir)
    {

    }
}
