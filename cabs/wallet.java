import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class wallet extends javax.swing.JFrame {
    

    Connection connect= null;
    String runame;
    String rname;
    int rbalance;
     PreparedStatement st1=null,smt=null,pst1=null,ps=null,pstmt=null,pst2=null;
    ResultSet rs1,rs,rs2,rs3;
    public wallet(String user_id) {
        initComponents();
        runame=user_id;
        this.setLocationRelativeTo(null);
        this.getRootPane().setDefaultButton(proceed);
        connect=dbm.dbconnect();
         String query2="select * from cust where user_id=?";
        PreparedStatement ps1=null;
        try {
            ps1 = connect.prepareStatement(query2);
            ps1.setString(1, user_id);
            rs3=ps1.executeQuery();
             while(rs3.next()) {
                rname = rs3.getString("name");
                rbalance = rs3.getInt("wallet_bal");
            }
            //rname=rs3.getString("name");
            hi_name.setText("Hi, "+rname);
            curr_bal.setText("RS."+rbalance);}
         catch (SQLException ex) {
           // System.out.println("Entered");
            System.out.println(ex.getMessage());                    // DOubt??//
        }    
        try {
            Thread.sleep(400);
        } catch (InterruptedException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     public wallet(String user_id,int wallet_bal) {
        initComponents();
        runame=user_id;
        this.setLocationRelativeTo(null);
        this.getRootPane().setDefaultButton(proceed);
        connect=dbm.dbconnect();
        try{
            String query="update cust set wallet_bal = ? where user_id = ?";
            ps=connect.prepareStatement(query);
            ps.setInt(1, wallet_bal);
            ps.setString(2, user_id);
            ps.execute();
        }
         catch(Exception e){
         JOptionPane.showMessageDialog(null ,e);}
                                            
         String query2="select * from cust where user_id=?";
        PreparedStatement ps1=null;
        try {
            ps1 = connect.prepareStatement(query2);
            ps1.setString(1, user_id);
            rs3=ps1.executeQuery();
             while(rs3.next()) {
                rname = rs3.getString("name");
                rbalance = rs3.getInt("wallet_bal");
            }
            //rname=rs3.getString("name");
            hi_name.setText("Hi, "+rname);
            curr_bal.setText("RS."+rbalance);}
         catch (SQLException ex) {
           // System.out.println("Entered");
            System.out.println(ex.getMessage());                    // DOubt??//
        }    
        try {
            Thread.sleep(400);
        } catch (InterruptedException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hi_name = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        int_add = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        proceed = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        curr_bal = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(938, 540));
        setMinimumSize(new java.awt.Dimension(938, 540));
        setPreferredSize(new java.awt.Dimension(938, 540));
        getContentPane().setLayout(null);

        hi_name.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        hi_name.setForeground(new java.awt.Color(255, 255, 255));
        hi_name.setText("Hello XYZ!");
        getContentPane().add(hi_name);
        hi_name.setBounds(790, 30, 109, 29);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton4.setText("Logout");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(150, 40, 110, 38);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("Rides");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(40, 40, 101, 38);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Current Balance");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(320, 170, 200, 29);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Add money to your wallet*");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(240, 240, 286, 29);
        getContentPane().add(int_add);
        int_add.setBounds(580, 240, 38, 26);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("RS.");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(540, 240, 35, 29);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("*Note:-you are required to maintain a  minimum balance of 300Rs to book a ride");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(110, 440, 764, 20);

        proceed.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        proceed.setText("Proceed");
        proceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedActionPerformed(evt);
            }
        });
        getContentPane().add(proceed);
        proceed.setBounds(310, 361, 120, 40);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(517, 360, 130, 41);

        curr_bal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        curr_bal.setForeground(new java.awt.Color(255, 255, 255));
        curr_bal.setText("320 RS");
        getContentPane().add(curr_bal);
        curr_bal.setBounds(560, 170, 75, 29);

        jLabel9.setFont(new java.awt.Font("Gotham Medium", 1, 36)); // NOI18N
        jLabel9.setText("Book My Cab 2.0");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(320, 10, 360, 90);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\garvit soni\\Desktop\\images\\driver_blur.png")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -30, 1080, 590);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
        new login().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        new rides(runame).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
        new booking(runame).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void proceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedActionPerformed
        try{
            int add_mon;
        add_mon=Integer.parseInt(int_add.getText());
        if(add_mon<=0)
        {
            JOptionPane.showMessageDialog(null ,"Please enter valid amount");
        }
        else
        {
           this.setVisible(false);
        new wallet(runame,(rbalance+add_mon)).setVisible(true); 
        JOptionPane.showMessageDialog(null ,"Transaction Successful");
        }    
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null, "Please enter valid amount");
        }
        
    }//GEN-LAST:event_proceedActionPerformed

   
   /* public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new wallet().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel curr_bal;
    private javax.swing.JLabel hi_name;
    private javax.swing.JTextField int_add;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton proceed;
    // End of variables declaration//GEN-END:variables
}
