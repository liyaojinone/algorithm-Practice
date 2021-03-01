package arrayDemo;

public class sparse {
     private int row;
     private int column;
     private int result;

    public sparse(int row, int column, int result) {
        this.row = row;
        this.column = column;
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getColumn() {
        return column;
    }


    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}

