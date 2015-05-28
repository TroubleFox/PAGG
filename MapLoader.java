package pagg;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author troublefox
 */
public class MapLoader {
//    private int[][] integerMap2;
    private int rows = 24;
    private int cols = 32;
    
    public int[][] einlesen(String im)
    {
        
        int[][] integerMap = new int[rows][cols];
        
        try(BufferedReader bf = new BufferedReader(new FileReader(im))) {
            String zeile = "";
            int zeilennr = 0;
            while ((zeile = bf.readLine()) != null) {                
                
                if( zeile.length()!=0 && zeilennr>0 ){  
                    
//                String[] temp = zeile.split(",");
                String[] temp = zeile.split(",\\s|,");
//                    System.out.println(temp.length);
//                    System.out.println(temp[zeilennr]);
                    for ( cols = 0 ; cols < temp.length ; cols++) {
//                        System.out.print(temp[cols]+" ");
                        integerMap[zeilennr-1][cols] = Integer.parseInt(temp[cols]);
                    }
                }
//                System.out.println(" :"+zeilennr+". Zeilennr");
                zeilennr++;
            }
        } catch (Exception e) {
            System.out.println(e+" MapLoader einlesen gescheitert");
        }
//        System.out.println("integerMap länge ist "+integerMap.length);
        return integerMap;
    }

    /**
     * @return the rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * @param rows the rows to set
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * @return the cols
     */
    public int getCols() {
        return cols;
    }

    /**
     * @param cols the cols to set
     */
    public void setCols(int cols) {
        this.cols = cols;
    }
}
