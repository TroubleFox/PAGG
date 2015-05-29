package pagg;

import javax.swing.ImageIcon;

/**
 *
 * @author troublefox
 */
public class Player extends Tile {
    
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
    private boolean occupied = true;
    
    //Spieler Eigenschaften als neue Attribute
    private int movementSpeed;
    private int row;
    private int col;
    
    
    Player(int tileNum, int moveDirection, boolean walkable, boolean obstacle, boolean sightBlock, int movementSpeed)
    {
        
        super(tileNum,moveDirection,walkable,obstacle,sightBlock);   

        this.tileNum = tileNum;
        this.moveDirection = 0;
        this.walkable = false;
        this.obstacle = false;
        this.sightBlock = false;
        this.occupied = true;
        this.movementSpeed = movementSpeed;
//        this.image = new ImageIcon("src/images/spieler"+tileNum+".jpg");
        this.image = new ImageIcon("src/images/"+tileNum+".jpg");
        
         
//        System.out.println("test" +image);
//        System.out.println(this.tileNum);
        
    }
    
    
//    @Override
//    public void setImage(ImageIcon img)
//    {
//        System.out.println("setImage" +image);
//        this.image = new ImageIcon("src/images/spieler"+tileNum+".jpg");
//    }
    
//    public void setPlayerImage()
//    {
//        System.out.println("setImage" +image);
//        this.image = new ImageIcon("src/images/spieler"+tileNum+".jpg");
//    }

    /**
     * @return the movementSpeed
     */
    public int getMovementSpeed() {
        return movementSpeed;
    }

    /**
     * @param movement the movementSpeed to set
     */
    public void setMovementSpeed(int movement) {
        this.movementSpeed = movement;
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
}
