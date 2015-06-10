/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagg;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author viona-066
 */
public class ShowSight {
    private List<SightCoordinates> openList = new ArrayList<>();
    private List<SightCoordinates> closedList = new ArrayList<>();
    private List<SightCoordinates> tempList = new ArrayList<>();
   
    private boolean diagonal = false;
    private int rowOrigin;
    private int colOrigin;
    private Tile[][] map;
    int dl=1;
    
    public ShowSight(int x, int y,Tile[][] map)
    {
        openList.add(new SightCoordinates(x, y, 0, 0, 0, 0));
//        openList.get(0).setParent(true);
        this.map = new Tile[map.length][map[0].length];
        this.map = map;
        rowOrigin = x;
        colOrigin = y;
        
    }
    
    public boolean indexCheck(SightCoordinates e)
    {
        if( e.getRow() >= 0 && e.getCol() >= 0 && (e.getRow() <= 23) && (e.getCol() <= 31) == true)
            return true;
        else
            return false;
                    
    }
    
    public SightCoordinates directionCheck(SightCoordinates e, int switchNum)
    {
        SightCoordinates eNew = null;
        switch( switchNum)
        {
            
            case 0:
                
            // x und y positiv   
                    // x < y   -> rechts
            case 1: if( Math.abs(e.getNrow()) < Math.abs(e.getNcol()) )
                    {
                        eNew = new SightCoordinates(e.getRow(), e.getCol()+1, e.getVrow(), e.getVcol(), e.getNrow()+e.getVrow(), e.getNcol()-e.getVrow());
//                        System.out.println(eNew.getRow()+" "+eNew.getCol()+" ist Sichtblock: "+eNew.getVrow()+" "+eNew.getVcol()+" wird zum neuen Vector berechnet: "+eNew.getNrow()+" "+eNew.getNcol());
                    }
                    // x > y   -> runter
                    else if( Math.abs(e.getNrow()) > Math.abs(e.getNcol()) )
                    {
                        eNew = new SightCoordinates(e.getRow()+1, e.getCol(), e.getVrow(), e.getVcol(), e.getNrow()-e.getVcol(), e.getNcol()+e.getVcol());
                    }
                    // x = y   -> diagonal
                    else
                    {
                        eNew = new SightCoordinates(e.getRow(), e.getCol()+1, e.getVrow(), e.getVcol(), e.getNrow()+e.getVrow(), e.getNcol()-e.getVrow());
                        diagonal = true;
                    }
                    break;
            // x positiv und y negativ    
                    // x < y   -> links
            case 2: if( Math.abs(e.getNrow()) < Math.abs(e.getNcol()) )
                    {
                        eNew = new SightCoordinates(e.getRow(), e.getCol()-1, e.getVrow(), e.getVcol(), e.getNrow()+e.getVrow(), Math.abs(e.getNcol())-Math.abs(e.getVrow()));
                    }
                    // x > y   -> runter
                    else if( Math.abs(e.getNrow()) > Math.abs(e.getNcol()) )
                    {
                        eNew = new SightCoordinates(e.getRow()+1, e.getCol(), e.getVrow(), e.getVcol(), e.getNrow()-Math.abs(e.getVcol()), Math.abs(e.getNcol())+Math.abs(e.getVcol()));
                    }
                    // x = y   -> diagonal
                    else
                    {
                        eNew = new SightCoordinates(e.getRow(), e.getCol()-1, e.getVrow(), e.getVcol(), e.getNrow()+e.getVrow(), Math.abs(e.getNcol())-Math.abs(e.getVrow()));
                        diagonal = true;
                    }
                    break;
            // x negativ und y positiv 
                    // x < y   -> rechts
            case 3: if( Math.abs(e.getNrow()) < Math.abs(e.getNcol()) )
                    {
                        eNew = new SightCoordinates(e.getRow(), e.getCol()+1, e.getVrow(), e.getVcol(), Math.abs(e.getNrow())+Math.abs(e.getVrow()), e.getNcol()-Math.abs(e.getVrow()));
                    }
                    // x > y   -> hoch
                    else if( Math.abs(e.getNrow()) > Math.abs(e.getNcol()) )
                    {
                        eNew = new SightCoordinates(e.getRow()-1, e.getCol(), e.getVrow(), e.getVcol(), Math.abs(e.getNrow())-e.getVcol(), e.getNcol()+e.getVcol());
                    }
                    // x = y   -> diagonal
                    else
                    {
                        eNew = new SightCoordinates(e.getRow(), e.getCol()+1, e.getVrow(), e.getVcol(), Math.abs(e.getNrow())+Math.abs(e.getVrow()), e.getNcol()-Math.abs(e.getVrow()));
                        diagonal = true;
                    }
                    break;
            // x negativ und y negativ 
                    // x < y   -> links
            case 4: System.out.println("case 4: "+e.getVrow()+" "+e.getVcol()+"  "+e.getNrow()+" "+e.getNcol());
                    if( Math.abs(e.getNrow()) < Math.abs(e.getNcol()) )
                    {
                        eNew = new SightCoordinates(e.getRow(), e.getCol()-1, e.getVrow(), e.getVcol(), Math.abs(e.getNrow())+Math.abs(e.getVrow()), Math.abs(e.getNcol())-Math.abs(e.getVrow()));
                    }
                    // x > y   -> hoch
                    else if( Math.abs(e.getNrow()) > Math.abs(e.getNcol()) )
                    {
                        eNew = new SightCoordinates(e.getRow()-1, e.getCol(), e.getVrow(), e.getVcol(), Math.abs(e.getNrow())-Math.abs(e.getVcol()), Math.abs(e.getNcol())+Math.abs(e.getVcol()));
                    }
                    // x = y   -> diagonal
                    else
                    {
                        eNew = new SightCoordinates(e.getRow(), e.getCol()-1, e.getVrow(), e.getVcol(), Math.abs(e.getNrow())+Math.abs(e.getVrow()), Math.abs(e.getNcol())-Math.abs(e.getVrow()));
                        diagonal = true;
                    }
                    break;
        }
        return eNew;
        
        
        
            
    }
//    public void sightVector(SightCoordinates sc)
//    {
//        closedList.add(sc);
//    }
    
    public void newNodes() throws IndexOutOfBoundsException
    {    
        
        System.out.println("\nDurchlauf "+dl+". openList wird gelesen: ");
        for ( SightCoordinates e : openList ) 
        {
//            System.out.println("nächstes Element: "+e.getRow()+" "+e.getCol()+" Vector: "+e.getVrow()+" "+e.getVcol()+" nVector: "+e.getNrow()+" "+e.getNcol());
            // rausfiltern von x:0 und y:0 Vektor-Koordinaten
            if( (e.getVrow() != 0) || (e.getVcol() != 0) )
            {   
                SightCoordinates eNew = null;
                // x positiv oder 0
                if( e.getVrow() >= 0 )
                {
                    // x positiv oder 0 und y positiv oder 0
                    if( e.getVcol() >= 0 )
                    {
                        System.out.println("x positiv oder 0 und y positiv oder 0");
                        eNew = directionCheck( e, 1);

                    }
                    // x positiv oder null und y negativ
                    else
                    {
                        System.out.println("x positiv oder null und y negativ");
                        eNew = directionCheck( e, 2);
                    }
                }
                // x negativ
                else
                {
                    // x negativ und y positiv oder 0
                    if( e.getVcol() >= 0)
                    {
                        System.out.println("x negativ und y positiv oder 0");
                        eNew = directionCheck( e, 3);
                    }
                    // x negativ und y negativ
                    else
                    {
                        System.out.println("x negativ und y negativ");
                        eNew = directionCheck( e, 4);
                    }

                }

                if( indexCheck(eNew) )
                {
                        
                    tempList.add(eNew);
                        if( diagonal != true)
                        {
                            map[eNew.getRow()][eNew.getCol()].setVisible(false);
                        }
    //                    System.out.println(eNew.getRow()+" "+eNew.getCol()+" in tempList hinzugefügt");
                        diagonal = false;
                }      
            }
            else
            {
//                System.out.println("Element: "+e.getRow()+" "+e.getCol()+" aus openList gezogen");
    //            if ( e.isParent() == true )
    //            {
//                    System.out.println("Überprüfe 1. Kind von "+e.getRow()+" "+e.getCol());
                    checkListAdd(e, 0, +1);         //Feld O
//                    System.out.println("Überprüfe 2. Kind von "+e.getRow()+" "+e.getCol());
                    checkListAdd(e, +1, 0);         //Feld S
//                    System.out.println("Überprüfe 3. Kind von "+e.getRow()+" "+e.getCol());
                    checkListAdd(e, 0, -1);         //Feld W
//                    System.out.println("Überprüfe 4. Kind von "+e.getRow()+" "+e.getCol());
                    checkListAdd(e, -1, 0);         //Feld N
//                    System.out.println("Neue Kinder für "+e.getRow()+" "+e.getCol()+" angelegt");
    //            }
    //            System.out.println(e.getRow()+" "+e.getCol()+" "+e.getMoveCost()+" "+e.isParent());
            }

        }
        closedList.clear();
//        System.out.println("clear closedList!");
        dl++;
//        for( int i = 0; i < openList.size(); i++ )
//        {
//            System.out.println(openList.get(i).getVrow()+" "+openList.get(i).getVcol());
//            if ((openList.get(i).getVrow() != 0) && (openList.get(i).getVcol() != 0))
//            {
//                System.out.println(openList.get(i).getRow()+" "+openList.get(i).getCol()+" von openList zu ClosedList");
////                openList.get(i).setParent(false);
//                closedList.add(openList.get(i));
//                openList.remove(i);
//                i--;
//            }
//        }
        
        for (SightCoordinates sc : openList) {
            closedList.add(sc); 
//            System.out.println("füge "+sc.getRow()+" "+sc.getCol()+" in closedList hinzu!");
        }
        
        
        
        for (SightCoordinates o : closedList) {
//            System.out.println("closedList aktuell: "+o.getRow()+" "+o.getCol());
        }
        for (SightCoordinates o : openList) {
//            System.out.println("openList aktuell: "+o.getRow()+" "+o.getCol());
        }
        
//        openList = tempList;
        
        openList = new ArrayList<>(tempList);
//        System.out.println("tempList zu openList!");
//        for (int i = 0; i < tempList.size(); i++) {
//            
//        System.arraycopy(tempList[i], 0, openList[i], 0, tempList[i].length);                      //kopiert 2D.Array ohne Referenz
//        
//        }
        
//        for (SightCoordinates o : openList) {
//            System.out.println("in openList übernommen: "+o.getRow()+" "+o.getCol());
//        }
        
//        System.out.println(openList.get(0).getMoveCost());
//        System.out.println("Parentumstellung");
//        for (SightCoordinates e : openList ) {
////            e.setParent(true);
////            System.out.println(e.getRow()+" "+e.getCol()+" auf Parent true gesetzt");
//        }

//         for (SightCoordinates o : openList) {
//            System.out.println("openList aktuell: "+o.getRow()+" "+o.getCol());
//        }        
        
        if( openList.size() > 0 && dl<=62) 
        {
            tempList.clear();
//            System.out.println("tempList clear!");
            System.out.println(""+openList.size());
            newNodes();
        }
    }  
    
    
    
    public boolean CoordinatesCompare(SightCoordinates c, List<SightCoordinates> list)
    {
        for (SightCoordinates cl : list) {
//            System.out.println("Ziehe "+cl.getRow()+"  "+cl.getCol()+" aus Liste und überprüfe mit "+c.getRow()+"  "+c.getCol());
            if(cl.getRow()==c.getRow() && cl.getCol()==c.getCol())
            {
//                System.out.println(cl.getRow()+" "+cl.getCol()+" aus Liste stimmen überein mit: "+c.getCol()+" "+c.getRow()+" --> keine Aufnahme als Kind");
//                tempCoordinates = cl;
                return false;
            }
            
        }
        return true;
    
    }
    
    
        public void checkListAdd(SightCoordinates e, int x, int y)
    {
//        System.out.println("Kind von "+e.getRow()+" "+e.getCol()+" ist: "+(e.getRow()+x)+" "+(e.getCol()+y));
        e.setRow(e.getRow()+x);
        e.setCol(e.getCol()+y);
//        System.out.println(e.getRow());
        
//        if ( e.getRow()+x >= 0 && e.getCol()+y >= 0 && (e.getRow()+x <= 23) && (e.getCol()+y <= 31) == true)
        if ( indexCheck(e) )
        {
            if( CoordinatesCompare( e, tempList))
            {
                if( CoordinatesCompare(e, closedList))
                {
                    SightCoordinates c = null;
//                    if( map[e.getRow()+x][e.getCol()+y].isSightBlock())
                    if( map[e.getRow()][e.getCol()].isSightBlock())
                    {
//                        c = new SightCoordinates((e.getRow()+x), (e.getCol()+y), (e.getRow()+x)-rowOrigin, (e.getCol()+y)-colOrigin, (e.getRow()+x)-rowOrigin, (e.getCol()+y)-colOrigin );
                        c = new SightCoordinates((e.getRow()), (e.getCol()), (e.getRow())-rowOrigin, (e.getCol())-colOrigin, (e.getRow())-rowOrigin, (e.getCol())-colOrigin );
                        System.out.println(" SightBlock detected!"+c.getRow()+" "+c.getCol()+" setze Vrow auf: "+c.getVrow()+" und Vcol auf: "+c.getVcol()+" und Nrow auf: "+c.getNrow()+" und Ncol auf: "+c.getNcol());
//                        map[c.getRow()][c.getCol()].setVisible(false);
                    }
                    else
                    {
//                        c = new SightCoordinates( (e.getRow()+x), (e.getCol()+y) );
                        c = new SightCoordinates( (e.getRow()), (e.getCol()) );
                    }
                    tempList.add(c);
//                    System.out.println(c.getRow()+" "+c.getCol()+" in checkListAdd erstellt und zu tempList hinzugef.");
                }
//            if( map[e.getRow()+x][e.getCol()+y].isSightBlock() )
//            {
//                SightCoordinates c = new SightCoordinates((e.getRow()+x), (e.getCol()+y), (e.getRow()+x)-rowOrigin, (e.getCol()+y)-colOrigin );
//                
//                
//            
////            SightCoordinates c = new SightCoordinates((e.getRow()+(x)), (e.getCol()+(y)));
////            System.out.println("Prüfung: "+c.getRow()+" "+c.getCol()+" "+c.getMoveCost()+" "+c.isParent());
//            
//            
//                if( CoordinatesCompare( c, tempList)  )
//                {
//
//                    if( CoordinatesCompare(c, closedList) )
//                    {
//                            tempList.add(c);
//                            System.out.println(c.getRow()+" "+c.getCol()+" in checkListAdd erstellt und zu tempList hinzugef.");
//                    }
//                    
//
//
//                }
//            }
//            else
//            {
//                
//                SightCoordinates c = new SightCoordinates( (e.getRow()+x), (e.getCol()+y) );
//                
//                if( CoordinatesCompare( c, tempList) )
//                {
//                    tempList.add(c);
//                    System.out.println(c.getRow()+" "+c.getCol()+" in checkListAdd erstellt und zu tempList hinzugef.");
//                }
//                
//            }
            }
        }
        e.setRow(e.getRow()+(-x));
        e.setCol(e.getCol()+(-y));
        
    }

    /**
     * @return the closedList
     */
    public List<SightCoordinates> getClosedList() {
        return closedList;
    }

    /**
     * @return the map
     */
    public Tile[][] getMap() {
        return map;
    }

    /**
     * @param map the map to set
     */
    public void setMap(Tile[][] map) {
        this.map = map;
    }
}
