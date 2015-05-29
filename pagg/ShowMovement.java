package pagg;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author troublefox
 */
public class ShowMovement {
    private List<Coordinates> closedList = new ArrayList<>();
    private List<Coordinates> openList = new ArrayList<>();
    private List<Coordinates> tempList = new ArrayList<>();
    private int maxMovementSpeed;
    int totalMoveCost = 0;
    int dl=1;
    PAGGMainFrame paggMainFrame = new PAGGMainFrame();
//    FieldTableModel fieldTableModel = new FieldTableModel();
    
//  holt Playerkoordinaten und Bewegungsweite  
    public ShowMovement(int x, int y, int move)      
    {
        openList.add(new Coordinates(x, y, 0));
        maxMovementSpeed = move;
        openList.get(0).setParent(true);
        
    }
    
    public void newNodes() throws IndexOutOfBoundsException
    {    
        System.out.println("Durchlauf "+dl+". openList wird gelesen: ");
        for ( Coordinates e : openList ) 
        {
            System.out.println("Element: "+e.getRow()+" "+e.getCol()+" aus openList gezogen");
            totalMoveCost = e.getMoveCost();

            if ( e.isParent() && (totalMoveCost<=maxMovementSpeed) == true )
            {
                System.out.println("Erzeuge neue Kinder von "+e.getRow()+" "+e.getCol());
                checkListAdd(e, 0, +1);         //Feld O
                checkListAdd(e, +1, 0);         //Feld S
                checkListAdd(e, 0, -1);         //Feld W
                checkListAdd(e, -1, 0);         //Feld N
                System.out.println("Neue Kinder für "+e.getRow()+" "+e.getCol()+" angelegt");
            }
            
//            
//            System.out.println(e.getRow()+" "+e.getCol()+" "+e.getMoveCost()+" "+e.isParent());
        }      
        dl++;
        for( int i = 0; i < openList.size(); i++ )
        {
            if (openList.get(i).isParent());
            {
                System.out.println(openList.get(i).getRow()+" "+openList.get(i).getCol()+" von openList zu ClosedList");
                openList.get(i).setParent(false);
                closedList.add(openList.get(i));
                openList.remove(i);
            }
        }
        
        for (Coordinates o : tempList) {
            System.out.println("TempList aktuell: "+o.getRow()+" "+o.getCol()+" "+o.getMoveCost()+" "+o.isParent());
        }
        
//        openList = tempList;
        openList = new ArrayList<>(tempList);
//        for (int i = 0; i < tempList.size(); i++) {
//            
//        System.arraycopy(tempList[i], 0, openList[i], 0, tempList[i].length);                      //kopiert 2D.Array ohne Referenz
//        
//        }
        
        for (Coordinates o : openList) {
            System.out.println("in openList übernommen: "+o.getRow()+" "+o.getCol()+" "+o.getMoveCost()+" "+o.isParent());
        }
        
//        System.out.println(openList.get(0).getMoveCost());
//        System.out.println("Parentumstellung");
        for (Coordinates e : openList ) {
            e.setParent(true);
        }

                
        
        if( openList.size() > 0 ) 
        {
            tempList.clear();
            newNodes();
        }
       
        
        
        
        
    }
    
    public boolean CoordinatesCompare(Coordinates c,List<Coordinates> list)
    {
        for (Coordinates cl : list) {
            if(cl.getRow()==c.getRow() && cl.getCol()==c.getCol())
            {
                return false;
            }
            
        }
        return true;
    }
    
    public void checkListAdd(Coordinates e, int x, int y)
    {
        Coordinates c = new Coordinates((e.getRow()+(x)), (e.getCol()+(y)));
        System.out.println("Prüfung: "+c.getRow()+" "+c.getCol()+" "+c.getMoveCost()+" "+c.isParent());
        if( CoordinatesCompare(c, closedList)  )
        {
            if( CoordinatesCompare(c, tempList) )
            {
                if( paggMainFrame.getFieldTableModel().getTileTable()[c.getRow()][c.getCol()].isWalkable() 
                &&  !paggMainFrame.getFieldTableModel().getTileTable()[c.getRow()][c.getCol()].isOccupied() == true)
                {
                    if ( paggMainFrame.getFieldTableModel().getTileTable()[c.getRow()][c.getCol()].isObstacle() == true )
                    {
                            c.setMoveCost(totalMoveCost+2);
                    }
                    else
                    {
                            c.setMoveCost(totalMoveCost+1);
                    }
                    tempList.add(c);
                    System.out.println(c.getRow()+" "+c.getCol()+" "+c.getMoveCost()+" "+c.isParent()+" in checkListAdd erstellt und zu tempList hinzugef.");
                }
                
            }
            else
            {       //hat noch keine Movekosten -------------------------------------------------------überprüfung später
                System.out.println("größe von TempList: "+tempList.size()+" "+c.getMoveCost());
                if ( tempList.get(tempList.indexOf(c)).getMoveCost() > c.getMoveCost() )        //überprüfe movementGröße von c und objekt in tempList mit gleichen Koordinaten und nehme den kleineren Wert 
                {
                    tempList.get(tempList.indexOf(c)).setMoveCost(c.getMoveCost());
                }     
            }
            
        }
        
    }

    /**
     * @return the closedList
     */
    public List<Coordinates> getClosedList() {
        return closedList;
    }

    /**
     * @param closedList the closedList to set
     */
    public void setClosedList(List<Coordinates> closedList) {
        this.closedList = closedList;
    }
}
//                for ( Coordinates e : openList ) 
//                { 
//                    if ( !(e element von closedList) || !e.isParent() == true ) 
//                    {
//                        
//                        if( paggMainFrame.getFieldTableModel().getTileTable()[e.getCol()][e.getRow()].isWalkable() 
//                        &&  !paggMainFrame.getFieldTableModel().getTileTable()[e.getCol()][e.getRow()].isOccupied() == true)
//                        {
//                            if ( paggMainFrame.getFieldTableModel().getTileTable()[e.getCol()][e.getRow()].isObstacle() == true )
//                                    e.setMoveCost(totalMoveCost+2);
//                            else
//                                    e.setMoveCost(totalMoveCost+1); 
//                        }
//                        else
//                        {
//                            openList.remove(e);
//                        }
//                    }
//                }
    

