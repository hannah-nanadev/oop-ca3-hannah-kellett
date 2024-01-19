public class Pair {

    //Pair class will assume a square matrix.
    private int[] row;
    private int[] column;

    public Pair(int[][] arr, int r, int c)
    {
        this.row = arr[r];
        this.column = getColumn(arr, c);

    }

    private int[] getColumn(int[][] arr, int c)
    {

        int l = arr[0].length;
        int[] column = new int[l];

        for(int i = 0; i<l; i++)
        {
            column[i] = arr[i][c];
        }

        return column;
    }

}
