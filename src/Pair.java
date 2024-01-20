public class Pair {

    //Pair class will assume a square matrix.
    private int[] row;
    private int[] column;

    public Pair(int[][] arr, int r, int c)
    {
        this.row = arr[r];
        this.column = evalColumn(arr, c);

    }

    private int[] evalColumn(int[][] arr, int c)
    {

        int l = arr[0].length;
        int[] column = new int[l];

        for(int i = 0; i<l; i++)
        {
            column[i] = arr[i][c];
        }

        return column;
    }

    public int[] getColumn()
    {
        return this.column;
    }
    public int[] getRow()
    {
        return this.row;
    }

    public int getLength()
    {
        return this.row.length;
    }

    public void copyToRow(int roNo, int[][] to)
    {
        for(int i = 0; i<getLength(); i++)
        {
            to[roNo][i] = this.row[i];
        }
    }

    public void copyToColumn(int colNo, int[][] to)
    {
        for(int i = 0; i<getLength(); i++)
        {
            to[i][colNo] = this.column[i];
        }
    }

    public void setRowValue(int idx, int val)
    {
        this.row[idx] = val;
        if(idx==0)
        {
            this.column[idx] = val;
        }
    }

    public void setColValue(int idx, int val)
    {
        this.column[idx] = val;
        if(idx==0)
        {
            this.row[idx] = val;
        }
    }

    public int getRowValue(int idx)
    {
        return this.row[idx];
    }
    public int getColumnValue(int idx)
    {
        return this.column[idx];
    }
}
