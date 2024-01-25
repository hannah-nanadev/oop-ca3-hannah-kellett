public class Cell {
    //Literally just stores coords for a single value in a square matrix
    private int x;
    private int y;

    public Cell(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }
}
