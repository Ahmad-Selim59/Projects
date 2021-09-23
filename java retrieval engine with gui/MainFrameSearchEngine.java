/*
 * Author Ahmad Selim
 * OS windows 
 * last updated 14/04/2021
 * program is a search engine which allows the user to search for a word in documents
 */
package searchengine;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrameSearchEngine extends javax.swing.JFrame {
    //file chooser for choosing the file
     static JFileChooser myFileChooser;
     //boolean variable to check if file has been chosen
     boolean fileChoosen;
     //file variable for holding text file
     File textFile;
     
     //docs array to hold all docs as Strings
     String[] docs;
     //array for counting search term in each document
     int[] docTermCount;
     //search term given by user to search
     static String searchTerm;
     
     //method for counting words
     static int countWords(String document){
         //removing punctuation like comma, full stop . and other from words
         document = document.replaceAll("\\p{Punct}", "");
         //replacing new line with space in entire document to correctly split words
         document = document.replaceAll("\\n", " ");
         //array for holding words, I am spliting document with space
         String[] words = document.split(" ");
         //variable for counting words
         int count = 0;
         
         for(int i=0; i<words.length; i++){
           
             //comparing words if they equal to search term
             if(words[i].toLowerCase().equals(searchTerm)){
                 count++;
                 
             }
         }
        
         
         
         return count;
     }
     

    /**
     * Creates new form MainScreen
     */
    public MainFrameSearchEngine() {
        fileChoosen = false;
       
        //setting frame as it should open on centre of screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        setSize(width/2, height/2);
        setLocationRelativeTo(null);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        MainPanel = new javax.swing.JPanel();
        ControlsPanel = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        searchBox = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));

        ControlsPanel.setBackground(new java.awt.Color(255, 255, 255));

        searchButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        searchButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchButtonKeyPressed(evt);
            }
        });

        searchBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        searchBox.setToolTipText("Search Bar");
        searchBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchBoxKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout ControlsPanelLayout = new javax.swing.GroupLayout(ControlsPanel);
        ControlsPanel.setLayout(ControlsPanelLayout);
        ControlsPanelLayout.setHorizontalGroup(
            ControlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ControlsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        ControlsPanelLayout.setVerticalGroup(
            ControlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ControlsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ControlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton)
                    .addComponent(searchBox))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ControlsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(ControlsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu1.setBackground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Choose File");
        jMenu1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //method for searching search term in all docs and counting them 
    void  search(){
        
        searchTerm = ""+searchBox.getText().toLowerCase();
        
        int max = 0; int maxIndex = 0;
        
        
        Scanner myReader = null;
        String txt="";
        if(fileChoosen){
            textFile= myFileChooser.getSelectedFile();
             
            try{
                //reading whole file using Scanner in one string
                 myReader = new Scanner(textFile);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
       txt+=data+"\n";
      
      }
     
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
             myReader.close();
             //spliting documents using this regular expressions
             docs = txt.split("<NEW DOCUMENT>");
            //creating array for counting words
             docTermCount = new int[docs.length];
             
            //counting search terms in all docs
             for(int i=1; i<docs.length; i++){
                 
                 int countWords = countWords(docs[i]);
               
                  docTermCount[i] = countWords;
                 if(countWords>max){
                     //finding doc with max search term occurence
                     max = countWords;
                     //noting index for max
                     maxIndex = i;
                 }
                
             }
             
             //if max index is same then it means the word searched doesnt exist in the file
             if(maxIndex==0){
                 JOptionPane.showMessageDialog(this, "No any document contains this word in this file");
             }
             else{
                 textArea.setText("Here is your result: \n\n"+docs[maxIndex]);
             }
           
              
      }
         
        
        else{
            JOptionPane.showMessageDialog(this, "Please choose file first for searching");
        }
    }
    
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        
        //if search box is empty
        if(searchBox.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please write something in search box to search");
        }
       
            search();
      
        
    }//GEN-LAST:event_searchButtonActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        
    }//GEN-LAST:event_jMenu1ActionPerformed

    //method for choosing file from file system
    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        
        // TODO add your handling code here:
        
         // TODO add your handling code here:
        
         myFileChooser = new JFileChooser();
       int r=  myFileChooser.showOpenDialog(this);
         
           
            if (r == JFileChooser.APPROVE_OPTION)
  
            {
              //if file is chosen
              fileChoosen = true;
               
                
               
                
                    
              
            }
           
            else
            {
                //if no file is chosen
                JOptionPane.showMessageDialog(this, "Please a choose a file!");
                
            }
    }//GEN-LAST:event_jMenu1MouseClicked

    private void searchButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchButtonKeyPressed
        // TODO add your handling code here:
        
        //if enter is pressed on search button
        if(evt.getKeyCode()==KeyEvent.VK_ENTER && !searchBox.equals("")){
            search();
        }
        else{
            JOptionPane.showMessageDialog(this, "Please write something in search box to search");
        }
    }//GEN-LAST:event_searchButtonKeyPressed

    private void searchBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBoxKeyPressed
        // TODO add your handling code here:
        
        //if box is empty
        if(searchBox.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please write something in search box to search");
        }
        if(evt.getKeyCode()==KeyEvent.VK_ENTER && !searchBox.equals("")){
            search();
        }
        
    }//GEN-LAST:event_searchBoxKeyPressed

    

   
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MainFrameSearchEngine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrameSearchEngine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrameSearchEngine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrameSearchEngine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrameSearchEngine().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ControlsPanel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchBox;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}