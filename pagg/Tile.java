package pagg;


import javax.swing.ImageIcon;

/**
 *
 * @author troublefox
 */
public class Tile {
   
//    private ImageIcon image = "images/schwarz";
    private ImageIcon image;
    
    //Attribute die beim erzeugen geladen werden müsssen
    private int tileNum;
    private int moveDirection;
    private boolean walkable;
    private boolean obstacle;
    private boolean sightBlock;
    
    //Attribute Standardwert vom Spielanfang false
    private boolean visible  = false;
    private boolean known    = false;
    private boolean occupied = false;

    
    
//    private ImageIcon tileIcon;
    
    public Tile(int tileNum, int moveDirection, boolean walkable, boolean obstacle, boolean sightBlock)
    {
        this.tileNum = tileNum;
        this.moveDirection = moveDirection;
        this.walkable = walkable;
        this.obstacle = obstacle;
        this.sightBlock = sightBlock;
        this.image = new ImageIcon("src/images/"+tileNum+".jpg");
    }

//    private void loadImage(int tileNum)
//    {
//        image = new ImageIcon("images/"+tileNum+".jpg");
//    }
    
    //setVisibility überprüft die boolwerte des TabellenFeldes auf Sichtbarkeit/Bekanntheit
    //und setzt das image entsprechend auf "images/"+tileNum+".jpg"-ausgegraut
    //für visible=false oder -normal für visible=true. Zu Spielbeginn ist image auf "images/schwarz.jpg" 
//    public void setVisibility()
//    {
//        if(isVisible()!=true)
//        {
//            if(isKnown()==true)
//            {
////                fieldTableModel.loadImageGrau();
//            }
//            else
//            {
//            loadImage(this.getTileNum()); 
//            }
//        }
//        
//    }

    /**
     * @return the image
     */
    public ImageIcon getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(ImageIcon image) {
        this.image = image;
    }

    /**
     * @return the tileNum
     */
    public int getTileNum() {
        return tileNum;
    }

    /**
     * @param tileNum the tileNum to set
     */
    public void setTileNum(int tileNum) {
        this.tileNum = tileNum;
    }

    /**
     * @return the moveDirection
     */
    public int getMoveDirection() {
        return moveDirection;
    }

    /**
     * @param moveDirection the moveDirection to set
     */
    public void setMoveDirection(int moveDirection) {
        this.moveDirection = moveDirection;
    }

    /**
     * @return the walkable
     */
    public boolean isWalkable() {
        return walkable;
    }

    /**
     * @param walkable the walkable to set
     */
    public void setWalkable(boolean walkable) {
        this.walkable = walkable;
    }

    /**
     * @return the obstacle
     */
    public boolean isObstacle() {
        return obstacle;
    }

    /**
     * @param obstacle the obstacle to set
     */
    public void setObstacle(boolean obstacle) {
        this.obstacle = obstacle;
    }

    /**
     * @return the sightBlock
     */
    public boolean isSightBlock() {
        return sightBlock;
    }

    /**
     * @param sightBlock the sightBlock to set
     */
    public void setSightBlock(boolean sightBlock) {
        this.sightBlock = sightBlock;
    }

    /**
     * @return the visible
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * @return the known
     */
    public boolean isKnown() {
        return known;
    }

    /**
     * @param known the known to set
     */
    public void setKnown(boolean known) {
        this.known = known;
    }

    /**
     * @return the occupied
     */
    public boolean isOccupied() {
        return occupied;
    }

    /**
     * @param occupied the occupied to set
     */
    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
    
}
