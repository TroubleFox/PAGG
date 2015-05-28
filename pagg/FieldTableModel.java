package pagg;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author troublefox
 */
class FieldTableModel extends AbstractTableModel
{
//    private List<Tile> tileSet;
//    private int[][] integerMap;
    private Tile[][] tileTable;
    private Tile[][] tileTableOrigin;
    private Player player1 = new Player(36,0,true, true, true);
    private Player player2 = new Player(37,0,true,true,true);
//    private Tile spieler = new Tile(53, 0, true, true, true);
            
    public FieldTableModel()
    {
        
        List<Tile> tileSet = new ArrayList<>();
        
        TileSet ts = new TileSet();
//        System.out.println(ts.getTileSet().size());
        MapLoader ml = new MapLoader();
//        System.out.println(ml.getRows() + ml.getCols());
        tileTable = new Tile[ml.getRows()][ml.getCols()]; 
        tileTableOrigin = new Tile[ml.getRows()][ml.getCols()];
        int[][] integerMap = new int[ml.getRows()][ml.getCols()];
        //holt auf MapLoader die größe des 2DimArrays
        ts.einlesen("src/data/integerTileSet.txt");                        //ließt hier das TileSet ein
        tileSet = ts.getTileSet();                                      //holt Liste aus TileSet in tileSet

//        System.out.println(tileSet.size());

        integerMap = ml.einlesen("src/maps/integerMap1.txt");
        int zeile=0;
        int spalte;
        while(zeile < integerMap.length) { 
//        while(zeile < integerMap.length) {                                                                //    oder  ml.einlesen("/maps/integerMap1.txt").length
            for (spalte = 0; spalte < integerMap[0].length; spalte++) {
//                System.out.println(tileSet.get(40).getTileNum());
//                System.out.println(integerMap[0][0]);
                tileTable[zeile][spalte] = tileSet.get(integerMap[zeile][spalte]);                          
//                System.out.println(tileTable[0][0].getTileNum());
                
            }
            zeile++;
        }
        for (int i = 0; i < tileTable.length; i++) {
            
        System.arraycopy(tileTable[i], 0, tileTableOrigin[i], 0, tileTable[i].length);                      //kopiert 2D.Array ohne Referenz
        
        }
                 
        
    }

//    @Override
//    public Class getColumnClass(int column)
//    {
//      if (column == 0)                                                                                      //----------0?
//      {
//          return Tile.class;
//      }
//        return getValueAt(0, column).getClass();               
//
//    }

    @Override
    public int getRowCount() {
//            System.out.println("text");
        return getTileTable().length;
    }

    @Override
    public int getColumnCount() {
        return getTileTable()[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        return tileTable[rowIndex][columnIndex];
//        return getTileTable()[rowIndex][columnIndex];
   }

    public void setValueAt(Object tile, int row, int col)
    {
        tileTable[row][col] = (Tile) tile;
        /*
        1. alte Spielerposition resetten
        2.Sichtbarkeit des Feldes neu berechnen -> ausgehend neuer Spielerposition
        3.Sicht = Schussweite
        4.Tilearray neu einlesen
        */
    }
    
//    public boolean isCellEditable(int row, int col)           //auskommentiert, da sonst Referenz editierbar
//    {
//        return true;
//    }



    private void contentChanged() 
    {
        fireTableDataChanged();
    }

    /**
     * @return the tileTable
     */
    public Tile[][] getTileTable() {
        return tileTable;
    }
    

    /**
     * @param tileTable the tileTable to set
     */
    public void setTileTable(Tile[][] tileTable) {
        this.tileTable = tileTable;
    }

    /**
     * @return the player2
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * @param player2 the player2 to set
     */
    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    /**
     * @return the tileTableOrigin
     */
    public Tile[][] getTileTableOrigin() {
        return tileTableOrigin;
    }

    /**
     * @param tileTableOrigin the tileTableOrigin to set
     */
    public void setTileTableOrigin(Tile[][] tileTableOrigin) {
        this.tileTableOrigin = tileTableOrigin;
    }

    /**
     * @return the player1
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * @param player1 the player1 to set
     */
    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

}
