package pagg;

/**
 *
 * @author troublefox
 */
public class Coordinates {
    private int row;
    private int col;
//    private boolean checked;
    private int moveCost;
    private boolean parent = false;

    public Coordinates(int row, int col, int moveCost)
    {
        this.row = row;
        this.col = col;
        this.moveCost = moveCost;
//        checked = true;
    }
    
    public Coordinates(int row, int col)
    {
        this.row = row;
        this.col = col;
        this.moveCost = 0;
//        checked = true;
    }
    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * @return the col
     */
    public int getCol() {
        return col;
    }

    /**
     * @param col the col to set
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * @return the moveCost
     */
    public int getMoveCost() {
        return moveCost;
    }

    /**
     * @param moveCost the moveCost to set
     */
    public void setMoveCost(int moveCost) {
        this.moveCost = moveCost;
    }

    /**
     * @return the parent
     */
    public boolean isParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(boolean parent) {
        this.parent = parent;
    }

    
    
}
