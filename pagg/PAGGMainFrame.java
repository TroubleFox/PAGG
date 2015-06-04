package pagg;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import sun.swing.ImageIconUIResource;

/**
 *
 * @author troublefox
 */
public class PAGGMainFrame extends javax.swing.JFrame {

    private FieldTableModel fieldTableModel;
//    private int s1row;
//    private int s1col;
//    private int s2row;
//    private int s2col;
    private List<Coordinates> sm = new ArrayList<>();
    private boolean toggleGrid = false;
    private boolean startButton= false;
    private boolean playerSet=false;
    /**
     * Creates new form PAGGMainFrame
     */
    public PAGGMainFrame() {
        
        fieldTableModel = new FieldTableModel();
        
//        ImageCellRenderer renderer = new ImageCellRenderer();
        initComponents();
        jTable1.setGridColor(Color.black);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        movementbutton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuMain = new javax.swing.JMenu();
        menuStartPlayer = new javax.swing.JMenuItem();
        jMenuMap = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuToggleGrid = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(fieldTableModel);
        for (int i = 0; i < 32; i++) {

            int colIndex = i;  // show image at (row 1, col 1)
            TableColumn col = jTable1.getColumnModel().getColumn(colIndex);
            ImageCellRenderer renderer = new ImageCellRenderer();
            col.setCellRenderer(renderer);

            setForeground(Color.BLUE);
            setBackground(Color.BLACK);

            //            col.setPreferredWidth(renderer.image.getWidth(null));
            col.setMaxWidth(32);
            jTable1.setRowHeight(32);
            //            jTable1.add(renderer.getLbl());

        }
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        movementbutton.setText("display movement");
        movementbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                movementbuttonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(444, 444, 444)
                .addComponent(movementbutton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(movementbutton)
                .addContainerGap())
        );

        jMenuMain.setText("Main");

        menuStartPlayer.setText("start player");
        menuStartPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuStartPlayerActionPerformed(evt);
            }
        });
        jMenuMain.add(menuStartPlayer);

        jMenuMap.setText("load map");

        jMenuItem1.setText("ForestTemple");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuMap.add(jMenuItem1);

        jMenuItem2.setText("BreezyPlain");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuMap.add(jMenuItem2);

        jMenuItem3.setText("TestPlain");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenuMap.add(jMenuItem3);

        jMenuMain.add(jMenuMap);

        jMenuBar1.add(jMenuMain);

        jMenu2.setText("Settings");

        menuToggleGrid.setText("toggle grid");
        menuToggleGrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuToggleGridActionPerformed(evt);
            }
        });
        jMenu2.add(menuToggleGrid);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1034, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        
//        fieldTableModel.setValueAt(this, jTable1.getSelectedRow(), jTable1.getSelectedColumn());
        
//        if( (fieldTableModel.getTileTable()[jTable1.getSelectedRow()][jTable1.getSelectedColumn()].isWalkable() 
//         && !(fieldTableModel.getTileTable()[jTable1.getSelectedRow()][jTable1.getSelectedColumn()].isOccupied())) == true)
//        {
//            fieldTableModel.setValueAt(fieldTableModel.getPlayer1(), jTable1.getSelectedRow(), jTable1.getSelectedColumn());
////            System.out.println("von Zeile "+getS1row()+" und Spalte "+getS1col());
////            System.out.println("nach Zeile "+jTable1.getSelectedRow()+" und Spalte "+jTable1.getSelectedColumn());
////            System.out.println("originalTile: "+fieldTableModel.getTileTableOrigin()[getS1row()][getS1col()].getImage());
////            System.out.println("SpielfeldTile: "+fieldTableModel.getTileTable()[getS1row()][getS1col()].getImage());
////            fieldTableModel.setValueAt(fieldTableModel.getTileTableOrigin()[getS1row()][getS1col()], getS1row(), getS1col());
//            fieldTableModel.setValueAt(fieldTableModel.getTileTableOrigin()[fieldTableModel.getPlayer1().getRow()][fieldTableModel.getPlayer1().getCol()], fieldTableModel.getPlayer1().getRow(),fieldTableModel.getPlayer1().getCol());
//            fieldTableModel.getPlayer1().setRow(jTable1.getSelectedRow());
//            fieldTableModel.getPlayer1().setCol(jTable1.getSelectedColumn());
//            
//        }
//        else
//        {
////            System.out.println("Bewegung nicht möglich");
////            System.out.println("Zielort begehbar: "+fieldTableModel.getTileTable()[jTable1.getSelectedRow()][jTable1.getSelectedColumn()].isWalkable()
////            +";  besetzt: "+fieldTableModel.getTileTable()[jTable1.getSelectedRow()][jTable1.getSelectedColumn()].isOccupied());
//        }

        if( fieldTableModel.getTileTable()[jTable1.getSelectedRow()][jTable1.getSelectedColumn()].isPath() )
        {   
            for (Coordinates e : sm ) {
            System.out.println("x: "+e.getRow()+" y: "+e.getCol());
            fieldTableModel.getTileTable()[e.getRow()][e.getCol()].setPath(false);
            
            }
//            fieldTableModel.setTileTable(fieldTableModel.getTileTableOrigin());
            
//            System.arraycopy(fieldTableModel.getTileTableOrigin()[], jTable1.getSelectedColumn(), fieldTableModel.setTileTable, jTable1.getSelectedColumn(), 1); 
            
            fieldTableModel.copyTileTable(fieldTableModel.getPlayer1().getRow(), fieldTableModel.getPlayer1().getCol(), jTable1.getSelectedRow(), jTable1.getSelectedColumn(), fieldTableModel.getTileTable());
//            fieldTableModel.setValueAt(fieldTableModel.getPlayer1(), jTable1.getSelectedRow(), jTable1.getSelectedColumn());
            fieldTableModel.copyTileTable(fieldTableModel.getPlayer1().getRow(), fieldTableModel.getPlayer1().getCol(), fieldTableModel.getTileTableOrigin());
//            fieldTableModel.setValueAt(fieldTableModel.getTileTableOrigin()[getS1row()][getS1col()], getS1row(), getS1col());
//            fieldTableModel.setValueAt(fieldTableModel.getTileTableOrigin()[fieldTableModel.getPlayer1().getRow()][fieldTableModel.getPlayer1().getCol()], fieldTableModel.getPlayer1().getRow(),fieldTableModel.getPlayer1().getCol());
            fieldTableModel.getPlayer1().setRow(jTable1.getSelectedRow());
            fieldTableModel.getPlayer1().setCol(jTable1.getSelectedColumn());
       
       
        fieldTableModel.fireTableDataChanged();
        }
      
    }                                    

    private void movementbuttonMouseClicked(java.awt.event.MouseEvent evt) {                                            
        
        if( playerSet==true)
        {
            System.out.println("Ausgabe Koordinaten in MainFrame aus fieldTableModel: "+fieldTableModel.getPlayer1().getRow()+" "+fieldTableModel.getPlayer1().getCol());

            ShowMovement sm = new ShowMovement(fieldTableModel.getPlayer1().getRow(), fieldTableModel.getPlayer1().getCol(), fieldTableModel.getPlayer1().getMovementSpeed(), fieldTableModel.getTileTable());
            sm.newNodes();
            System.out.println("kurz vor Listenausgabe");
            sm.getClosedList().remove(0);
            this.sm = sm.getClosedList();
            for (Coordinates e : sm.getClosedList() ) {
                System.out.println("x: "+e.getRow()+" y: "+e.getCol());
                fieldTableModel.getTileTable()[e.getRow()][e.getCol()].setPath(true);

            }
            fieldTableModel.fireTableDataChanged();
        }
        
        
    }                                           

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        startButton=false;
        playerSet=false;
        fieldTableModel.changeMap("ForestTemple");
        fieldTableModel.fireTableDataChanged();
    }                                          

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        startButton=false;
        playerSet=false;
        fieldTableModel.changeMap("BreezyPlain");
        fieldTableModel.fireTableDataChanged();
    }                                          

    private void menuToggleGridActionPerformed(java.awt.event.ActionEvent evt) {                                               
        if( toggleGrid == false)
        {
            jTable1.setShowGrid(true);
            toggleGrid=true;
        }
        else
        {
            jTable1.setShowGrid(false);
            toggleGrid=false;
        }
        
        
        // TODO add your handling code here:
    }                                              

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        startButton=false;
        playerSet=false;
        fieldTableModel.changeMap("TestPlain");
        fieldTableModel.fireTableDataChanged();
    }                                          

    private void menuStartPlayerActionPerformed(java.awt.event.ActionEvent evt) {                                                
        //        System.out.println("originalTile: "+fieldTableModel.getTileTableOrigin()[11][3].getImage());
        if( startButton==false )
        {
            startButton=true;
            playerSet=true;
            fieldTableModel.getPlayer1().setOccupied(true);
        //        fieldTableModel.getPlayer2().setOccupied(true);
            fieldTableModel.getPlayer1().setRow(11);
            fieldTableModel.getPlayer1().setCol(10);

        //        s2row = 10;
        //        s2col = 28;

            fieldTableModel.getTileTable()[11][10] = fieldTableModel.getPlayer1();
        //        fieldTableModel.getTileTable()[10][28] = fieldTableModel.getPlayer2();
            fieldTableModel.fireTableDataChanged();
        }
        
//        System.out.println("originalTile: "+fieldTableModel.getTileTableOrigin()[11][3].getImage());
                
//        fieldTableModel.getSpieler().setOccupied(true);
//        System.out.println(fieldTableModel.getTileTable()[0][0].getImage());
//        fieldTableModel.getTileTable()[1][1].setImage(new ImageIcon("src/images/0.jpg"));       //ersetzt ein Tileobjekt im TileTable
//        fieldTableModel.setValueAt(this, WIDTH, WIDTH);                                         //ersetzt ein Objekt in der Anzeige = neuer Spielstand
//        fieldTableModel.getSpieler().setImage(new ImageIcon("src/images/spieler1.jpg"));
    }                                               

    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PAGGMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PAGGMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PAGGMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PAGGMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PAGGMainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenu jMenuMain;
    private javax.swing.JMenu jMenuMap;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem menuStartPlayer;
    private javax.swing.JMenuItem menuToggleGrid;
    private javax.swing.JButton movementbutton;
    // End of variables declaration                   

    
    
    public FieldTableModel getFieldTableModel()
    {
        return fieldTableModel;
    }
    
//    public BufferedImage makeTranslucent(BufferedImage source, float alpha)
//            {
//               
//               Graphics2D g2d = source.createGraphics();
//               g2d.setComposite(AlphaComposite.SRC, alpha);
//               g2d.drawImage(source,0,0,null);
//               g2d.dispose();
//               return source;
//            }
    
//    public Image makeTranslucentImages(Image src) {
//            Image transImage = new Image() {
//
//                @Override
//                public int getWidth(ImageObserver observer) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//
//                @Override
//                public int getHeight(ImageObserver observer) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//
//                @Override
//                public ImageProducer getSource() {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//
//                @Override
//                public Graphics getGraphics() {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//
//                @Override
//                public Object getProperty(String name, ImageObserver observer) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//            };
//            int width = src.getWidth(null);
//            int height = src.getHeight(null);
//           
//                  int[] pixels = new int[width * height];
//                  PixelGrabber pg = new PixelGrabber(src, 0, 0, width, height, pixels, 0, width);
//                  try {
//                        pg.grabPixels();
//                  }
//                  catch (InterruptedException e) {
//                        System.out.println("Error grabbing pixels.");
//                  }
//
//                  for (int k = 0; k < pixels.length; k++) {
//                        int alpha = (pixels[k] >> 24) & 0xff;
//                        if (alpha != 0)
//                              pixels[k] = 0x4F000000 | (pixels[k] & 0x00FFFFFF);
//                  }
//                  transImage = Toolkit.getDefaultToolkit().createImage(new MemoryImageSource(width, height, pixels, 0, width));
//            
//            return transImage;
//      }

    class ImageCellRenderer extends JLabel implements TableCellRenderer
    {
        private JLabel lbl = new JLabel();
        private JLabel lbl2 = new JLabel("test");
        private MyLabel lbl4 = new MyLabel();
        
//        private ImageIcon image = null;
       
//        public ImageCellRenderer()
//                
//        {
////            setOpaque(true);
//                    lbl2.setOpaque(true);
//            lbl2 = new JLabel();
//            lbl2.setBackground(Color.BLUE);
//            lbl2.setForeground(Color.BLUE);
//            add(lbl2);
//        }
        
        public void fillColor(JTable t, JLabel l, boolean isSelected )
        {
            if(isSelected)
            {
                l.setBackground(t.getSelectionBackground());
                l.setForeground(t.getSelectionForeground());
            }
            else
            {
                l.setBackground(l.getBackground());
                l.setForeground(l.getForeground());
            }
        }
        
        
        
       
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected,
                                                       boolean hasFocus,
                                                       int rowIndex, int colIndex)
        {
            setOpaque(true);
            setText("");
//            setIcon(fieldTableModel.getTileTable()[rowIndex][colIndex].getImage());
//            setIcon(((Tile) value).getImage());                                      //alternativ auch möglich
            ImageIcon image = new ImageIcon("src/images/blue.png");
            ImageIcon image1 = fieldTableModel.getTileTable()[rowIndex][colIndex].getImage();
              
//            ImageIcon image = new ImageIcon();
//            if( fieldTableModel.getTileTable()[rowIndex][colIndex].isPath() )
//            {
//                ImageIcon image2 = new ImageIcon("src/images/blues/"+fieldTableModel.getTileTable()[rowIndex][colIndex].getTileNum()+"b.jpg");
//                image = image2;
//            }
//            else
//            {
//                image = fieldTableModel.getTileTable()[rowIndex][colIndex].getImage();
//            }
            lbl.setIcon(image1);
            
            if( fieldTableModel.getTileTable()[rowIndex][colIndex].isPath() )
            {
//                lbl2.setOpaque(true);
//                lbl2.setBackground(Color.red);
//                lbl2.setForeground(Color.blue);
//                lbl2.setFont(lbl2.getFont().deriveFont(Font.BOLD, 48));
//
//                lbl2.setIcon(image);
//                lbl2.setText("hi");
//                
                  lbl.setIcon(new ImageIcon("src/images/blues/"+fieldTableModel.getTileTable()[rowIndex][colIndex].getTileNum()+"b.jpg"));
//                lbl.add(lbl2);
//                return lbl2;
            }
            else
            {
//                image = fieldTableModel.getTileTable()[rowIndex][colIndex].getImage();
            
            
//            if(hasFocus)
//            {
//                setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
//            }
//            else
//            {
//                setBorder(null);
//            }
//            if(isSelected)
//            {
//                lbl.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
//            }
//            else
//            {
//                lbl.setBorder(null);
//            }
//            lbl.setBackground(Color.blue);
//            if( fieldTableModel.getTileTable()[rowIndex][colIndex].isPath())
//            {
//                lbl.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLUE.brighter()));
//            }
//            lbl.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLUE.brighter()));

//            fillColor(jTable1,lbl4,isSelected);

//            return lbl;
            }
            return lbl;
        }   


    }
}
