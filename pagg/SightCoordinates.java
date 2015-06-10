/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagg;

/**
 *
 * @author viona-066
 */
public class SightCoordinates extends Coordinates
{
    //table coordinates
    private int row;
    private int col;
    //vector data
    private int vrow=0;
    private int vcol=0;
    private int nrow=0;
    private int ncol=0;
    
    public SightCoordinates(int row, int col)
    {
        super( row, col);
        this.row = row;
        this.col = col;
    }
    
    public SightCoordinates(int row, int col, int vrow, int vcol)
    {
        super( row, col);
        this.row = row;
        this.col = col;
        this.vrow = vrow;
        this.vcol = vcol;
    }

    public SightCoordinates(int row, int col, int vrow, int vcol, int nrow, int ncol)
    {
        super( row, col);
        this.row = row;
        this.col = col;
        this.vrow = vrow;
        this.vcol = vcol;
        this.nrow = nrow;
        this.ncol = ncol;
    }

    /**
     * @return the vrow
     */
    public int getVrow() {
        return vrow;
    }

    /**
     * @param vrow the vrow to set
     */
    public void setVrow(int vrow) {
        this.vrow = vrow;
    }

    /**
     * @return the vcol
     */
    public int getVcol() {
        return vcol;
    }

    /**
     * @param vcol the vcol to set
     */
    public void setVcol(int vcol) {
        this.vcol = vcol;
    }

    /**
     * @return the nrow
     */
    public int getNrow() {
        return nrow;
    }

    /**
     * @param nrow the nrow to set
     */
    public void setNrow(int nrow) {
        this.nrow = nrow;
    }

    /**
     * @return the ncol
     */
    public int getNcol() {
        return ncol;
    }

    /**
     * @param ncol the ncol to set
     */
    public void setNcol(int ncol) {
        this.ncol = ncol;
    }
    
}
