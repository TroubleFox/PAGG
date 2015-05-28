package pagg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author troublefox
 */
public class TileSet {
    private List<Tile> tileSet;
    
    public void einlesen(String tl)
    {   
        int nr;
        int move;
        boolean walk;
        boolean obstacle;
        boolean sight;
        List<Tile> tileSet = new ArrayList<>();
        try
            (BufferedReader bf = new BufferedReader(new FileReader(tl))) {
            String zeile = "";
            int zeilennr = 0;
            while ((zeile = bf.readLine()) != null) {                
                
                if( zeile.length()!=0 && zeilennr>0 ){  
                //zeile in 5 int umwandeln
                String[] temp = zeile.split(",");
//                    System.out.println(temp[0]+","+temp[1]+","+temp[2]+","+temp[3]+","+temp[4]);
                nr = Integer.parseInt(temp[0]);
                move = Integer.parseInt(temp[1]);
//                walk = Boolean.parseBoolean(temp[2]);
//                obstacle = Boolean.parseBoolean(temp[3]);
//                sight = Boolean.parseBoolean(temp[4]);
                walk = boolCheck(Integer.parseInt(temp[2]));
                obstacle = boolCheck(Integer.parseInt(temp[3]));
                sight = boolCheck(Integer.parseInt(temp[4]));
                //die int ins tile übernehmen
                Tile a = new Tile(nr,move,walk,obstacle,sight);          
                tileSet.add(a);
                
//                    System.out.println(a.getTileNum());
//                    System.out.println(tileSet.size());
//                    System.out.println(tileSet.get(0));
   
                }
                zeilennr++;
            }
        this.tileSet = tileSet;
        } catch (Exception e) {
            System.out.println(e+" einlesen von TileSet gescheitert");
        }
           
    }

    public boolean boolCheck(int bool)
    {
        if (bool == 0)
        {
            return false;
        }    
        else
        {
            return true;
        }
    }
    /**
     * @return the tileSet
     */
    public List<Tile> getTileSet() {
        return tileSet;
    }

    /**
     * @param tileSet the tileSet to set
     */
    public void setTileSet(List<Tile> tileSet) {
        this.tileSet = tileSet;
    }
}
