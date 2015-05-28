package pagg;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author troublefox
 */
public class ShowMovement {
    private List<Coordinates> closedList;
    private List<Coordinates> openList;
    private int maxMovementSpeed;
    int totalMoveCost = 0;
    
    PAGGMainFrame paggMainFrame = new PAGGMainFrame();
//    FieldTableModel fieldTableModel = new FieldTableModel();
    
//  holt Playerkoordinaten und Bewegungsweite  
    public ShowMovement()      
    {
        System.out.println(paggMainFrame.getFieldTableModel().getPlayer1().getRow()+""+paggMainFrame.getFieldTableModel().getPlayer1().getCol());
        openList.add(new Coordinates(paggMainFrame.getFieldTableModel().getPlayer1().getRow(), paggMainFrame.getFieldTableModel().getPlayer1().getCol(), 0));
        maxMovementSpeed = paggMainFrame.getFieldTableModel().getPlayer1().getMovementSpeed();
        openList.get(0).setParent(true);
        newNodes();
    }
    
    public void newNodes() throws IndexOutOfBoundsException
    {    
        for ( Coordinates e : openList ) 
        {
            totalMoveCost = e.getMoveCost();
            if ( e.isParent() && (totalMoveCost<=maxMovementSpeed) == true )
            {
                checkListAdd(e, 0, +1);         //Feld O
                checkListAdd(e, +1, 0);         //Feld S
                checkListAdd(e, 0, -1);         //Feld W
                checkListAdd(e, -1, 0);         //Feld N
            }
            getClosedList().add(e);
            openList.remove(e);  
        }          

        for (Coordinates e : openList ) {
            e.setParent(true);
        }

        if( openList.size() > 0 ) 
        {
            newNodes();
        }
       
        
        
        
        
    }
    
    public void checkListAdd(Coordinates e, int x, int y)
    {
        Coordinates c = new Coordinates(e.getRow()+x, e.getCol()+y);
        if( !closedList.contains(c) )
        {
            if( !openList.contains(c) )
            {
                if( paggMainFrame.getFieldTableModel().getTileTable()[c.getCol()][c.getRow()].isWalkable() 
                &&  !paggMainFrame.getFieldTableModel().getTileTable()[c.getCol()][c.getRow()].isOccupied() == true)
                {
                    if ( paggMainFrame.getFieldTableModel().getTileTable()[c.getCol()][c.getRow()].isObstacle() == true )
                    {
                            c.setMoveCost(totalMoveCost+2);
                    }
                    else
                    {
                            c.setMoveCost(totalMoveCost+1);
                    }
                    openList.add(c);        
                }
                
            }
            else
            {
                if ( openList.get(openList.indexOf(c)).getMoveCost() > c.getMoveCost() )
                {
                    openList.get(openList.indexOf(c)).setMoveCost(c.getMoveCost());
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
    

