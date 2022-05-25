/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.voting.system;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ADMIN
 */
public class Dashboard extends javax.swing.JFrame {

    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs =null;
    Statement st=null;
    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        EDisplay();
       // GetWinnerData();
       // GetWinner();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    int WinnerId, votes, percentage;
    private void GetWinner(){
    
    try{
    
     Class.forName("org.mariadb.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/E_Voting","root", "Eldinah8703");
    st=con.createStatement();
    rs=st.executeQuery("select candidateId, count(candidateId)from votes where electId="+key+" GROUP BY candidateId ORDER BY candidateId DESC LIMIT 1");
    while(rs.next()){
    
    //JOptionPane.showMessageDialog(this, ""+rs.getInt(1));
    
   WinnerId=rs.getInt(1);
    }
    
    }
    catch(Exception e){
    
    JOptionPane.showMessageDialog(this, e);
    
    
    }
    }
    
     private Icon ResizePhoto(String imgpath, byte [] pic){
     
      ImageIcon MyImage=null;
      if (imgpath!=null){
      
      MyImage=new ImageIcon(imgpath); 
      
      }else{
      
        MyImage=new ImageIcon(pic);  
      
      }
      Image img =MyImage.getImage();
      Image newImg=img.getScaledInstance(VPhoto3.getWidth(),VPhoto3.getHeight() , Image.SCALE_SMOOTH);
      ImageIcon image=new ImageIcon(newImg);
      
      return image;
     }
    
 
    private void GetWinnerData(){
    
     String query="select CPhoto, CName from candidatetbl  where CId="+WinnerId;
    Statement st;
    ResultSet rs;
     try{
     
      Class.forName("org.mariadb.jdbc.Driver");
      con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/E_Voting","root", "Eldinah8703");
       st=con.createStatement();
       rs=st.executeQuery(query);
       if(rs.next()){
       
       VPhoto3.setIcon(ResizePhoto(null, rs.getBytes("CPhoto")));
       RName.setText(rs.getString("CName"));
       
       
       }
     }
     catch(Exception e){
     
     
     }
    
    }
    
    private void GetVotes(){
    
     try{
    
     Class.forName("org.mariadb.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/E_Voting","root", "Eldinah8703");
    st=con.createStatement();
    String query="select count(candidateId)from votes where candidateId="+WinnerId;
    rs=st.executeQuery(query);
    while(rs.next()){
    
         votes=rs.getInt(1);
    JOptionPane.showMessageDialog(this, "  " +votes);
    
     Bravo2.setText(votes +    "   votes");
    }
    
    }
    catch(Exception e){
    
    JOptionPane.showMessageDialog(this, e);
    
    }
    
    }
    
     private void GetPercentage(){
         int TotalVotes;
       double  winPercentage;
    
     try{
    
     Class.forName("org.mariadb.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/E_Voting","root", "Eldinah8703");
    st=con.createStatement();
    rs=st.executeQuery("select count(*)from votes where electId="+key );
    while(rs.next()){
    
    TotalVotes=rs.getInt(1);
   //JOptionPane.showMessageDialog(this, TotalVotes);
    
   winPercentage=(votes*100)/TotalVotes;
   
    Percentage.setText(new DecimalFormat ("##.##").format (winPercentage) +" % ");
    }
    
    }
    catch(Exception e){
    
    JOptionPane.showMessageDialog(this, e);
    
    }
    
    }
    
    private void EDisplay(){
    
    try{
         Class.forName("org.mariadb.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/E_Voting","root", "Eldinah8703");
         st =con.createStatement();
         rs=st.executeQuery("select *from electiontbl");
         ElectionTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
        
        JOptionPane.showMessageDialog(null, e);
        }
        }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Percentage = new javax.swing.JLabel();
        VPhoto2 = new javax.swing.JLabel();
        VPhoto3 = new javax.swing.JLabel();
        VPhoto4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        RName = new javax.swing.JLabel();
        VotingName1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ElectionTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        Bravo1 = new javax.swing.JLabel();
        Bravo2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setForeground(new java.awt.Color(0, 51, 204));

        jLabel2.setBackground(new java.awt.Color(51, 0, 204));
        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("E-VOTING  SYSTEM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(202, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, -1));

        Percentage.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Percentage.setForeground(new java.awt.Color(204, 0, 204));
        Percentage.setText("Percentage");
        getContentPane().add(Percentage, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, -1, -1));

        VPhoto2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(VPhoto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        VPhoto3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(VPhoto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 150, 160));

        VPhoto4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(VPhoto4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 150, 140));

        RName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        RName.setText("Name");
        getContentPane().add(RName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 392, 170, 30));

        VotingName1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        VotingName1.setText("Election list");
        getContentPane().add(VotingName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, -1, -1));

        ElectionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ElectionTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ElectionTableMouseClicked(evt);
            }
        });
        ElectionTable.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                ElectionTableComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(ElectionTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 810, 130));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 590, 180, -1));

        Bravo1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Bravo1.setText("Winner");
        getContentPane().add(Bravo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        Bravo2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Bravo2.setForeground(new java.awt.Color(255, 0, 0));
        Bravo2.setText("Votes");
        getContentPane().add(Bravo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, -1, -1));

        jLabel4.setBackground(new java.awt.Color(51, 0, 204));
        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 0));
        jLabel4.setText("Welcome in mycodespace voting application");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   int key=-1;
    private void ElectionTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ElectionTableMouseClicked
        // TODO add your handling code here:

        DefaultTableModel df=(DefaultTableModel)ElectionTable.getModel();
        int selectedIndex=ElectionTable.getSelectedRow();
         key=Integer.valueOf(df.getValueAt(selectedIndex, 0).toString());
          
       GetWinner();
       GetWinnerData();
        
        GetVotes();
        GetPercentage();
        
       
    }//GEN-LAST:event_ElectionTableMouseClicked

    private void ElectionTableComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ElectionTableComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_ElectionTableComponentShown

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new MainDashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bravo1;
    private javax.swing.JLabel Bravo2;
    private javax.swing.JTable ElectionTable;
    private javax.swing.JLabel Percentage;
    private javax.swing.JLabel RName;
    private javax.swing.JLabel VPhoto2;
    private javax.swing.JLabel VPhoto3;
    private javax.swing.JLabel VPhoto4;
    private javax.swing.JLabel VotingName1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
