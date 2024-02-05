import java.util.Stack;

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

        Stack<Cell> unexplored = new Stack<>();
        unexplored.push(new Cell(3,3));

        int i = 1;

        //Repeatedly solve until stack is empty
        while(!unexplored.isEmpty())
        {
            Cell current = unexplored.pop();
            solve(current.getX(), current.getY(), maze, unexplored);
            System.out.println("Step " + i);
            display(maze);
            i++;
        }

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

    public static void solve(int x, int y, int[][] maze, Stack<Cell> unexplored)
    {
        try
        { //Try/catch block to make sure cell exists
            if(maze[x][y]==-1)
            {
                System.out.println("Unable to solve - Function was placed into wall.");
            }
            else
            {
                maze[x][y] = 2;

                if(x==0||y==0||x==6||y==6) //Assumes maze size of 7x7
                {
                    System.out.println("Exit reached!");
                    while(!unexplored.isEmpty()) //Empty stack to signal that it's done
                    {
                        unexplored.pop();
                    }
                }
                else
                {
                    //Push nearby unexplored paths onto stack
                    if(maze[x][y+1]==0) //North
                    {
                        unexplored.push(new Cell(x, y+1));
                    }
                    if(maze[x+1][y]==0) //East
                    {
                        unexplored.push(new Cell(x+1, y));
                    }
                    if(maze[x][y-1]==0) //South
                    {
                        unexplored.push(new Cell(x, y-1));
                    }
                    if(maze[x-1][y]==0) //West
                    {
                        unexplored.push(new Cell(x-1, y));
                    }
                }
            }
        }catch(Exception e){
            System.out.println("Invalid position was passed to function. Ignoring.");
        }
    }
}
