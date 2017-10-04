/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import classes.return_items;
import DBConnect.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author jayabahu
 */
public class return_damage_history extends javax.swing.JFrame {
    
    //database connection
    Connection con=null;
    Statement stm=null;
    
    //load table
    ResultSet rs=null;
    PreparedStatement cmb=null;  
     
    //load selected id to table
    ResultSet rs1=null;
    PreparedStatement cmb1=null;
    
     //get the value if money return
    ResultSet rs2=null;
    PreparedStatement cmb2=null;
    int x=0;
    String ret_mny;
    
    //update data
    PreparedStatement pst;
    
    //update delete
    PreparedStatement pst1;
    
    
    
   
    /**
     * Creates new form return_damage_history
     */
    public return_damage_history() {
        initComponents();
            con=DBconnect.connect();
     
            //calling methoda to load data to table
                tableload();
                
               
                           
                
                
                
    }
    
    //method to load all data into the table
     public void tableload()
    {
        try {
             String sql="SELECT Item_ID,Product_Name ,unit_Price,Qty,Total ,Reason,money_Returns FROM returns  WHERE status='return'";
             cmb=con.prepareStatement(sql);
             rs=cmb.executeQuery();
             
             //loading data to table from database
             return_tbl.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
             
        } catch (Exception e) {
        }
    }
     
     
     //method to load all data into the table
     public void select_return()
    {
        try {
             String sql="SELECT Item_ID,Product_Name ,unit_Price,Qty,Total ,Reason,money_Returns FROM returns WHERE return_ID='"+src_item_id.getText()+"'";
             cmb1=con.prepareStatement(sql);
             rs1=cmb1.executeQuery();
             
             //loading data to table from database
             return_tbl.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs1));
             
        } catch (Exception e) {
        }
    }
     
     
     
      public void load_values_frm_table()
    {
        
        //getting database value for money return
        try {
             String sql1="SELECT money_Returns  FROM returns WHERE Item_ID='"+src_item_id.getText()+"'";
             cmb2=con.prepareStatement(sql1);
             rs2=cmb2.executeQuery();
             
            
             
             
        } catch (Exception e) {
        }


        //when mouse clicked on selected raw data will be loaded to relavent text fields
              //getting selected raw data
        int r=return_tbl.getSelectedRow();
        
        //assign data to variables
        String item_id=return_tbl.getValueAt(r,0).toString();
        String item_name=return_tbl.getValueAt(r,1).toString();
        String unit_prc=return_tbl.getValueAt(r,2).toString();
        String qty=return_tbl.getValueAt(r,3).toString();
        String tot_amount=return_tbl.getValueAt(r,4).toString();
        String reason=return_tbl.getValueAt(r,5).toString();
        String mny_rtn=return_tbl.getValueAt(r,6).toString();
        
        
        //assigning data to textfields and combo box
        item_id_txt.setText(item_id);
        item_name_txt.setText(item_name);
        item_unit_price_txt.setText(unit_prc);
        qty_txt.setText(qty);
        total_amount_txt.setText(tot_amount);
        reason_txt.setText(reason);
        money_return_chk.setText(mny_rtn);
        
    }
     
    
    //method to update return data
     public void edit_return()
    {
        int x=JOptionPane.showConfirmDialog(null,"Do you want to update");
                if(x==0){
                    String item_id=item_id_txt.getText();
                    String item_name=item_name_txt.getText();
                    String unit_prc=item_unit_price_txt.getText();
                    String qty=qty_txt.getText();
                    String total=total_amount_txt.getText();
                    String reason=reason_txt.getText();
                    String mny_return=money_return_chk.getText();
                    
                    String sql="UPDATE returns SET Item_ID='"+item_id+"',Product_Name='"+item_name+"',unit_Price='"+unit_prc+"',Qty='"+qty+"',Total='"+total+"',Reason='"+reason+"',money_Returns='"+mny_return+"' WHERE return_ID='"+src_item_id.getText()+"'";
                    try {
                        pst=con.prepareStatement(sql);
                        pst.execute();
                    } catch (Exception e) {
                    }
                    
                    //message after data edit
            JOptionPane.showMessageDialog(rootPane,"Data been updated");
            
                    //clear text fields and combo box
                    item_id_txt.setText("");
                    item_name_txt.setText("");
                    item_unit_price_txt.setText("");
                    qty_txt.setText("");
                    total_amount_txt.setText("");
                    reason_txt.setText("");
                    money_return_chk.setText("");
                    src_item_id.setText("");
      
      
               }
              
    //load data to table
        tableload();
    }
    
     
     //method to update return data
     public void delete_return()
    {
        int x=JOptionPane.showConfirmDialog(null,"Do you want to delete");
                if(x==0){
                    String sql="DELETE FROM returns WHERE return_ID='"+src_item_id.getText()+"'";
                        try {
                        pst1=con.prepareStatement(sql);
                        pst1.execute();
                    } catch (Exception e) {
                    }
                    
                    //message after data edit
            JOptionPane.showMessageDialog(rootPane,"Data been updated");
                    
                    //clear text fields and combo box
                    item_id_txt.setText("");
                    item_name_txt.setText("");
                    item_unit_price_txt.setText("");
                    qty_txt.setText("");
                    total_amount_txt.setText("");
                    reason_txt.setText("");
                    money_return_chk.setText("");
                    src_item_id.setText("");
               }
              
    //load data to table
        tableload();
    }
     
     
     
     
     
     
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        return_damage_history_btn = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        src_item_id = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        return_tbl = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        item_id_txt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        item_name_txt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        item_unit_price_txt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        qty_txt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        total_amount_txt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        reason_txt = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        money_return_chk = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Return History");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 180, 50));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ID Number:");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        return_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item Name", "Unit Price", "Qty", "Total Amount", "Reason", "Money Return"
            }
        ));
        return_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                return_tblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(return_tbl);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1211, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(src_item_id, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(src_item_id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 87, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Item ID :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 384, -1, -1));
        jPanel1.add(item_id_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 382, 125, 25));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Item Name:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 433, -1, -1));
        jPanel1.add(item_name_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 431, 125, 25));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Unit Price:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 476, -1, -1));
        jPanel1.add(item_unit_price_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 474, 123, 25));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Quntity: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 519, -1, -1));
        jPanel1.add(qty_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 517, 123, 25));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Total Amount: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 562, -1, -1));
        jPanel1.add(total_amount_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 560, 123, 25));

        reason_txt.setColumns(20);
        reason_txt.setRows(5);
        jScrollPane2.setViewportView(reason_txt);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(839, 405, 408, 76));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Reason For Return:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(839, 382, -1, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 23, 130, 42));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1024, 23, 130, 36));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Report");
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 23, 130, 36));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgrnd1.png"))); // NOI18N
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 740));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 1235, 80));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Money Return :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(839, 538, -1, -1));
        jPanel1.add(money_return_chk, new org.netbeans.lib.awtextra.AbsoluteConstraints(982, 536, 119, 25));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgrnd1.png"))); // NOI18N
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 740));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgrnd1.png"))); // NOI18N
        jLabel29.setMaximumSize(new java.awt.Dimension(100, 100));
        jLabel29.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 1240, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgrnd1.png"))); // NOI18N
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // delete database data for return
        delete_return();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // update database data for return
        edit_return();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void return_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_return_tblMouseClicked
        //call method to load data from table to fields
        load_values_frm_table();

    }//GEN-LAST:event_return_tblMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //calling method to load selected id
        select_return();
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
            java.util.logging.Logger.getLogger(return_damage_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(return_damage_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(return_damage_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(return_damage_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new return_damage_history().setVisible(true);
            }
        });
    }
    
    
    
    
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField item_id_txt;
    private javax.swing.JTextField item_name_txt;
    private javax.swing.JTextField item_unit_price_txt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField money_return_chk;
    private javax.swing.JTextField qty_txt;
    private javax.swing.JTextArea reason_txt;
    private javax.swing.ButtonGroup return_damage_history_btn;
    private javax.swing.JTable return_tbl;
    private javax.swing.JTextField src_item_id;
    private javax.swing.JTextField total_amount_txt;
    // End of variables declaration//GEN-END:variables
}
