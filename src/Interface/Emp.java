/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;


import database.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author user
 */
public class Emp extends javax.swing.JFrame {

    Connection con =null;
    PreparedStatement pst =null;
    ResultSet rs=null;
    
    public Emp() {
        initComponents();
        
        //connect to DB
        con =DBconnect.connect();
        
        //load table
        tableload();
    }
    
    public void tableload()
    {
        try 
        {
        String sql="select Emp_ID,Emp_Name,Age,Address,Tel_number from employee";
        pst=con.prepareStatement(sql);
        rs= pst.executeQuery();
        
        employee.setModel(DbUtils.resultSetToTableModel(rs));
        
        }
        catch(Exception e)
        {
        }
    }
    
      private void clearfields()
     {
        Name.setText("");
        Age.setText("");
        Id.setText("");
        Mobile.setText("");
        Address.setText("");
        search.setText("");
     }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        employee = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        Id = new javax.swing.JTextField();
        Name = new javax.swing.JTextField();
        Age = new javax.swing.JTextField();
        Mobile = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        Address = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        employee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Age", "Mobile", "Address"
            }
        ));
        employee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(employee);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 239, 954, 287));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 281, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Age");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 321, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Mobile");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 361, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Emp ID");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 241, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Add Record");
        jButton2.setMaximumSize(new java.awt.Dimension(130, 36));
        jButton2.setMinimumSize(new java.awt.Dimension(130, 36));
        jButton2.setPreferredSize(new java.awt.Dimension(130, 36));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(706, 594, -1, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Update Record");
        jButton3.setMaximumSize(new java.awt.Dimension(130, 36));
        jButton3.setMinimumSize(new java.awt.Dimension(130, 36));
        jButton3.setPreferredSize(new java.awt.Dimension(130, 36));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(854, 594, 140, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Delete Record ");
        jButton4.setMaximumSize(new java.awt.Dimension(130, 36));
        jButton4.setMinimumSize(new java.awt.Dimension(130, 36));
        jButton4.setPreferredSize(new java.awt.Dimension(130, 36));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1027, 594, 145, -1));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton6.setText("Back");
        jButton6.setMaximumSize(new java.awt.Dimension(130, 36));
        jButton6.setMinimumSize(new java.awt.Dimension(130, 36));
        jButton6.setPreferredSize(new java.awt.Dimension(130, 36));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 43, -1, 45));
        getContentPane().add(Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 239, 177, -1));

        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });
        getContentPane().add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 279, 177, -1));
        getContentPane().add(Age, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 319, 177, -1));
        getContentPane().add(Mobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 359, 177, -1));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setText("Search By Name");
        jButton7.setMaximumSize(new java.awt.Dimension(130, 36));
        jButton7.setMinimumSize(new java.awt.Dimension(130, 36));
        jButton7.setPreferredSize(new java.awt.Dimension(130, 36));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 144, 158, -1));
        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(583, 145, 195, 36));
        getContentPane().add(Address, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 399, 177, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Address");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 401, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Employeee Details");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 43, -1, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Clear Fields");
        jButton5.setMaximumSize(new java.awt.Dimension(130, 36));
        jButton5.setMinimumSize(new java.awt.Dimension(130, 36));
        jButton5.setPreferredSize(new java.awt.Dimension(130, 36));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 594, 145, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bill/backgrnd1.png"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //Delete records
          int x=JOptionPane.showConfirmDialog(null,"Do you want to delete?");
       if(x==0)
       {
           String id=Id.getText();
           
         
           try{
           String sql="delete from employee where Emp_ID='"+id+"' ";
           pst=con.prepareStatement(sql);
           pst.execute();
           
           tableload();
           clearfields();
                   
           }
        catch(Exception e)
        {
        }
       }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        //add records
        
        String a=Id.getText();       
        String b=Name.getText();
        String c=Age.getText();
        String d=Address.getText();
        String e=Mobile.getText();
        
        
      try
      {  
        String q="insert into employee(Emp_ID,Emp_Name,Age,Address,Tel_number) values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"')";
         pst=con.prepareStatement(q);
         pst.execute();
       
          
        String k="insert into salary_level(Emp_ID) values('"+a+"')";
         pst=con.prepareStatement(k);
         pst.execute();
         
        String t="insert into salary(Emp_ID) values('"+a+"')";
         pst=con.prepareStatement(t);
         pst.execute();
         
        String g="insert into loans(Emp_ID) values('"+a+"')";
         pst=con.prepareStatement(g);
         pst.execute();
         
        String h="insert into salary_reduction(Emp_ID) values('"+a+"')";
         pst=con.prepareStatement(h);
         pst.execute();
         
        String i="insert into attendance(Emp_ID) values('"+a+"')";
         pst=con.prepareStatement(i);
         pst.execute();
         
          
         
        int result=pst.executeUpdate();
        tableload();
        if(result == 1){
            JOptionPane.showMessageDialog(this,"Succusfully added");
            clearfields();
        }
        }
      catch(Exception ex)
      {
      }
         //load table
        tableload();
        clearfields();
       
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Update records
        
        int x=JOptionPane.showConfirmDialog(null,"Do you want to Update?");
       if(x==0)
       {
           String id=Id.getText();
           String name=Name.getText();
           String age=Age.getText();
           String mobile=Mobile.getText();
           String address=Address.getText();
         
          String sql="update employee set Emp_ID='"+id+"', Emp_Name='"+name+"', Age='"+age+"', Tel_number='"+mobile+"' ,Address='"+address+"' where Emp_ID='"+id+"' ";
       try{
        pst=con.prepareStatement(sql);
       
        int result=pst.executeUpdate();
        tableload();
        if(result == 1){
            JOptionPane.showMessageDialog(this,"Succusfully updated");
            clearfields();
        }
        }
        catch(Exception e)
        {}
        
    }//GEN-LAST:event_jButton3ActionPerformed
    }
    
   
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // back button
        HRM l=new HRM();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void employeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeMouseClicked
       
        int r=employee.getSelectedRow();
        String id=employee.getValueAt(r, 0).toString();
        String name=employee.getValueAt(r, 1).toString();
        String age=employee.getValueAt(r, 2).toString();
        String address=employee.getValueAt(r, 3).toString();
        String mobile=employee.getValueAt(r, 4).toString();
        
        Id.setText(id);
        Name.setText(name);
        Age.setText(age);
        Mobile.setText(mobile);
        Address.setText(address);
        
    }//GEN-LAST:event_employeeMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // search button
        String name=search.getText();  
       
        String sql="select Emp_ID,Emp_Name,Age,Address,Tel_number from employee where Emp_Name like '%"+name+"%'";
        
        try
        {
        pst=con.prepareStatement(sql);
        rs=pst.executeQuery();
        
        employee.setModel(DbUtils.resultSetToTableModel(rs));
        
        clearfields();
        }
        catch(Exception e)
        {}
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //clear fields
         clearfields();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Emp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Emp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Emp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Emp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Emp().setVisible(true);
            }
        });
    }

     
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Address;
    private javax.swing.JTextField Age;
    private javax.swing.JTextField Id;
    private javax.swing.JTextField Mobile;
    private javax.swing.JTextField Name;
    private javax.swing.JTable employee;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}