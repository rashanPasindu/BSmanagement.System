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
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author user
 */
public class calsal extends javax.swing.JInternalFrame {
    Connection con =null;
    PreparedStatement pst =null;
    ResultSet rs=null;
    /**
     * Creates new form calculate salary
     */
    public calsal() {
        initComponents();     
          //connect to DB
        con =DBconnect.connect();
        
        //load table
        tableload();
        tableloadfnl();
    }
    
     public void tableloadfnl()
    {
        try 
        {
        String sql="select s.Emp_ID,e.Emp_Name,l.Salary,l.Loan_Amount,s.To_Be_Paid,s.Final_Pay,s.Num_Of_Days_Absent,r.Reason,s.Date_Paid from salary s,employee e,loans l,salary_reduction r where s.Emp_ID=e.Emp_ID AND e.Emp_ID=l.Emp_ID AND l.Emp_ID=r.Emp_ID ";
        pst=con.prepareStatement(sql);
        rs= pst.executeQuery();
        
        y.setModel(DbUtils.resultSetToTableModel(rs));
        
        }
        catch(Exception e)
        {
        }
    }
    
     public void tableload()
    {
        try 
        {
     
        String sql="select a.Emp_ID,e.Emp_Name,s.Salary,count(a.Ab_Dates)as No_Of_Absent_Days from attendance a,employee e,salary_level s where s.Emp_ID=e.Emp_ID AND e.Emp_ID=a.Emp_ID group by a.Emp_ID";
        pst=con.prepareStatement(sql);
        rs= pst.executeQuery();
        
        x.setModel(DbUtils.resultSetToTableModel(rs));
        
        }
        catch(Exception e)
        {
        }
    }
     public void clearfields()
     {
       a.setText("");
       b.setText("");
       c.setText("");
       d.setText("");
       f.setText("");
       g.setText("");
       h.setText("");
       i.setText("");
       j.setText("");
       reduced.setText("");
       datebox.setDate(null);
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        a = new javax.swing.JTextField();
        c = new javax.swing.JTextField();
        d = new javax.swing.JTextField();
        g = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        h = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        y = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        j = new javax.swing.JTextArea();
        datebox = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        i = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        b = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        x = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        f = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        reduced = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1329, 649));
        setMinimumSize(new java.awt.Dimension(1329, 649));
        setPreferredSize(new java.awt.Dimension(1329, 649));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("ID");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 41, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Salary ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 101, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("No Of Absent Days");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 130, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Loan Amount");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, -1, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Calculate to be Paid");
        jButton3.setMaximumSize(new java.awt.Dimension(130, 36));
        jButton3.setMinimumSize(new java.awt.Dimension(130, 36));
        jButton3.setPreferredSize(new java.awt.Dimension(130, 36));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 175, -1));
        getContentPane().add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 41, 104, -1));
        getContentPane().add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 99, 104, -1));
        getContentPane().add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 128, 104, -1));
        getContentPane().add(g, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 242, 104, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("To be Paid Amount");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 349, -1, -1));
        getContentPane().add(h, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 347, 104, -1));

        y.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Salary Level", "To be Paid Amount", "Finalized Salary", "Reason", "Assigned Date"
            }
        ));
        y.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                yMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(y);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 743, 180));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Reason for Reduction");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Finalized Amount");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 380, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Assign");
        jButton1.setMaximumSize(new java.awt.Dimension(130, 36));
        jButton1.setMinimumSize(new java.awt.Dimension(130, 36));
        jButton1.setPreferredSize(new java.awt.Dimension(130, 36));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 175, -1));

        j.setColumns(20);
        j.setRows(5);
        jScrollPane3.setViewportView(j);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 162, 73));

        datebox.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(datebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 415, 125, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Date");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 415, -1, -1));
        getContentPane().add(i, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 380, 103, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Name");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 72, -1, -1));
        getContentPane().add(b, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 70, 104, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 377, -1, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Cal_Salary");
        jButton4.setMaximumSize(new java.awt.Dimension(130, 36));
        jButton4.setMinimumSize(new java.awt.Dimension(130, 36));
        jButton4.setPreferredSize(new java.awt.Dimension(130, 36));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 177, -1));

        x.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Salary", "no of days", "non approved"
            }
        ));
        x.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(x);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 743, 163));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Rs");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, -1, -1));
        getContentPane().add(f, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 192, 104, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Amount Reduced");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 570, -1, -1));
        getContentPane().add(reduced, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 570, 104, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Clear Fields");
        jButton2.setMaximumSize(new java.awt.Dimension(130, 36));
        jButton2.setMinimumSize(new java.awt.Dimension(130, 36));
        jButton2.setPreferredSize(new java.awt.Dimension(130, 36));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 320, 175, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Employee Final Salary");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, 220, 40));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bill/backgrnd1.png"))); // NOI18N
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //cal to be paid 
        float x1=new Float(f.getText());
        float x2=new Float(g.getText());
        
        float G=x1-x2;
        
        h.setText(String.valueOf(G));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //cal sal temp
        try
        {
         int no= Integer.parseInt(d.getText());
         String sal=c.getText();
         if(no>3)
         {
        int x=(no-3);
        float s=new Float(c.getText());
        
        float G=(s/30)*(30-x);
        
        f.setText(String.valueOf(G));
         }
          
         else
           f.setText(sal);  
             
        }
        catch(Exception e)
        {}
            
    }//GEN-LAST:event_jButton4ActionPerformed

    private void xMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xMouseClicked
       //mouse click 1st table
        int r=x.getSelectedRow();
        String id=x.getValueAt(r, 0).toString();
        String name=x.getValueAt(r, 1).toString();
        String sal=x.getValueAt(r, 2).toString();
        String dt=x.getValueAt(r, 3).toString();
        
        
        a.setText(id);
        b.setText(name);
        c.setText(sal);
        d.setText(dt);
       
    }//GEN-LAST:event_xMouseClicked

    private void yMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yMouseClicked
       int r=y.getSelectedRow();
       String amt=y.getValueAt(r, 3).toString();
       g.setText(amt);
    }//GEN-LAST:event_yMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Assign button
        String id=a.getText();
        String ab=d.getText();
        String tbp=h.getText();
        String fnl=i.getText();
        String rsn=j.getText();
        String date;
        date = ((JTextField)datebox.getDateEditor().getUiComponent()).getText();
       
        float sal=new Float(c.getText());
        float fnll=new Float(i.getText());
        float G=sal-fnll;
        
        reduced.setText(String.valueOf(G));
        String red=reduced.getText();
        
        
        try
        {
        String q="Update salary set To_Be_Paid='"+tbp+"',Final_Pay='"+fnl+"',Date_Paid='"+date+"',Num_Of_Days_Absent='"+ab+"' where Emp_ID='"+id+"' ";
        pst=con.prepareStatement(q);
        pst.execute();
        
        String q2="Update salary_reduction set Reason='"+rsn+"',Amount='"+red+"' where Emp_ID='"+id+"' ";
        pst=con.prepareStatement(q2);
        pst.execute();
        
        //load table
        tableloadfnl();
       
        }
        catch(Exception ex)
        {
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // clear fields
        clearfields();
        
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a;
    private javax.swing.JTextField b;
    private javax.swing.JTextField c;
    private javax.swing.JTextField d;
    private com.toedter.calendar.JDateChooser datebox;
    private javax.swing.JTextField f;
    private javax.swing.JTextField g;
    private javax.swing.JTextField h;
    private javax.swing.JTextField i;
    private javax.swing.JTextArea j;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField reduced;
    private javax.swing.JTable x;
    private javax.swing.JTable y;
    // End of variables declaration//GEN-END:variables
}