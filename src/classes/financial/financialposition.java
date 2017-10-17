/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.financial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rashan
 */
 

public class financialposition {
    
    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    
    float intangibleTotal = 0;
    float cashTotal = 0;
    float InventroyTOT = 0;
    float debtorsTot = 0;
    
    float currAssestsTot = 0;
    float fixdAssestsTot = 0;
    float assetsTot = 0;
    
    float equity = 0;
    float creditorsTotal = 0;
    float accruedPaymentsTot = 0;
    float loansTotal =0;
    
    float liablilitiesTotal = 0;

private void setValues(String start,String end){
    
    cashTotal = cashTotal(start,end);
    InventroyTOT = inventoryTot(getStartDateFormat(start),getEndDateFormat(end));
    debtorsTot = getDebtors(start,end);
    
    currAssestsTot=cashTotal+InventroyTOT+debtorsTot;
    fixdAssestsTot=fixdAssestsTot();
    
    assetsTot=currAssestsTot+fixdAssestsTot;
    
    creditorsTotal=getTotCreditors(start,end);
}

private float fixdAssestsTot(){
    float tot=0.0f;
    
    tot=calcBuilding()+calcMV()+calcEquip();
    
    return tot;
}
private float cashTotal(String start,String end){
    
    float cashTOT=0.0f;
    
    return cashTOT;        
}    

private float inventoryTot(String start,String end){
    float invTot=0.0f;
    //String array[];
    
    con=DBConnect.DBconnect.connect();
    try{
    String sql = "SELECT `ProductID`,`Date`,`Quantity`,`CostPerUnit` FROM products WHERE `Date` >= any (SELECT `Date` FROM `products` WHERE `Date` >= '"+start+"') AND `Date` <= any (SELECT `Date` FROM `products` WHERE `Date` <= '"+end+"')";
    pst=con.prepareStatement(sql);
    rs=pst.executeQuery();
    
    int nCol = rs.getMetaData().getColumnCount();
    System.out.print(nCol);
    
    List<String[]> table = new ArrayList<>();
    String[] row = new String[nCol];
    
    while(rs.next()){
  
        for(int iCol=1;iCol<=nCol;iCol++){
            Object obj = rs.getObject(iCol);
            row[iCol-1]=(obj == null)?null:obj.toString();
        }
        table.add(row);
    }
    
    if (table.isEmpty()){
        System.out.println("No data to get details");
    }
    else{
        int rowCount = table.size();
        
        String qaty[];
        int qty,i=1;
        float value,valueF;
        
        while(i<=rowCount){
            qaty=table.get(i);
            System.out.println(qaty.length);
            
            qty   = Integer.parseInt(qaty[2]);
            value = Float.parseFloat(qaty[3]);
            valueF = qty*value;
            System.out.println(valueF);
            
            invTot += valueF;
            i++;
        }
        
    }
    
    return invTot;
    }
    catch(Exception e){
        System.out.println(e);
        return invTot=0.0f;
    }
}

private float getDebtors(String start,String end){
    float debtTot=0.0f;
    
    con = DBConnect.DBconnect.connect();
    
    try{
        String sql = "SELECT SUM(`Net_Amount`) FROM creditsales WHERE `Date` >= any (SELECT `Date` FROM `creditsales` WHERE `Date` >= '"+start+"') AND `Date` <= any (SELECT `Date` FROM `creditsales` WHERE `Date` <= '"+end+"')";
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        
        String tot = rs.getString(sql);
        
        debtTot=Float.parseFloat(tot);
        return debtTot;
    }
    catch(Exception e){
        System.out.println(e);
        return debtTot;
    }
     
}

private float calcBuilding(){
    float builvalF=0.0f;
    float originalBuildingValue=0.0f;
    float perc=0.0f;
    
    con = DBConnect.DBconnect.connect();
    
    try{
     String sql = "SELECT SUM(`cost`) FROM `other_resources`";    
     pst = con.prepareStatement(sql);
     rs = pst.executeQuery();
     
      originalBuildingValue= Float.parseFloat(rs.getString(sql));
    }
    catch (Exception e){
        System.out.println(e);
    }
    
    try{
      
     String sql0 = "SELECT SUM(`value`) FROM `other_resources`";    
     pst = con.prepareStatement(sql0);
     rs = pst.executeQuery();
     
     builvalF= Float.parseFloat(rs.getString(sql0));
    }
    catch (Exception e){
        System.out.println(e);
    }
    
    try{
      
     String sql1 = "SELECT `percentage` FROM `policy_update` WHERE `policyType`='Depreciation for Land & Building'";    
     pst = con.prepareStatement(sql1);
     rs = pst.executeQuery();
     
     perc = Float.parseFloat(rs.getString(sql1));
    }
    catch (Exception e){
        System.out.println(e);
    }
    
    if(builvalF != 0.0f && perc != 0.0f){
      
        builvalF = builvalF-((builvalF*(perc/100.0f))/4);
      return builvalF;
    }
    else{
    System.out.println("No depreciation calculated");
    return builvalF;
    }
}

private float calcMV(){
    float MVvalF=0.0f;
    float originalMvValue=0.0f;
    float perc=0.0f;
    
    con = DBConnect.DBconnect.connect();
    
    try{
     String sql = "SELECT SUM(`vehicle_cost`) FROM `vehicle`";    
     pst = con.prepareStatement(sql);
     rs = pst.executeQuery();
     
      originalMvValue= Float.parseFloat(rs.getString(sql));
    }
    catch (Exception e){
        System.out.println(e);
    }
    
    try{
      
     String sql0 = "SELECT SUM(`vehicle_cost`) FROM `vehicle`";    
     pst = con.prepareStatement(sql0);
     rs = pst.executeQuery();
     
     MVvalF= Float.parseFloat(rs.getString(sql0));
    }
    catch (Exception e){
        System.out.println(e);
    }
    
    try{
      
     String sql1 = "SELECT `percentage` FROM `policy_update` WHERE `policyType`='Depreciation for MotorVehicles'";    
     pst = con.prepareStatement(sql1);
     rs = pst.executeQuery();
     
     perc = Float.parseFloat(rs.getString(sql1));
    }
    catch (Exception e){
        System.out.println(e);
    }
    
    if(MVvalF != 0.0f && perc != 0.0f){
      
        MVvalF = MVvalF-((MVvalF*(perc/100.0f))/4);
      return MVvalF;
    }
    else{
    System.out.println("No depreciation calculated");
    return MVvalF;
    }
}

private float calcEquip(){
    float EquipvalF=0.0f;
    float originalEquipValue=0.0f;
    float perc=0.0f;
    
    con = DBConnect.DBconnect.connect();
    
    try{
     String sql = "SELECT SUM(`Value`) FROM `equipment`";    
     pst = con.prepareStatement(sql);
     rs = pst.executeQuery();
     
      originalEquipValue= Float.parseFloat(rs.getString(sql));
    }
    catch (Exception e){
        System.out.println(e);
    }
    
    try{
      
     String sql0 = "SELECT SUM(`Value`) FROM `equipment`";    
     pst = con.prepareStatement(sql0);
     rs = pst.executeQuery();
     
     EquipvalF= Float.parseFloat(rs.getString(sql0));
    }
    catch (Exception e){
        System.out.println(e);
    }
    
    try{
      
     String sql1 = "SELECT `percentage` FROM `policy_update` WHERE `policyType`='Depreciation for Equip'";    
     pst = con.prepareStatement(sql1);
     rs = pst.executeQuery();
     
     perc = Float.parseFloat(rs.getString(sql1));
    }
    catch (Exception e){
        System.out.println(e);
    }
    
    if(EquipvalF != 0.0f && perc != 0.0f){
      
        EquipvalF = EquipvalF-((EquipvalF*(perc/100.0f))/4);
      return EquipvalF;
    }
    else{
    System.out.println("No depreciation calculated");
    return EquipvalF;
    }
}

private float getTotCreditors(String start,String end){
    float cTot=0.0f;
    
    con = DBConnect.DBconnect.connect();
    
    try{
        String sql="SELECT SUM(`payment`) FROM rorders WHERE `payType`='Credit' AND `rdate` >= any (SELECT `rdate` FROM `rorders` WHERE `rdate` >= '"+start+"') AND `rdate` <= any (SELECT `rdate` FROM `rorders` WHERE `rdate` <= '"+end+"')";
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        
        cTot = Float.parseFloat(rs.getString(sql));
        return cTot;
    }
    catch (Exception e){
        System.out.println(e);
        return cTot;
    }
    
}
private String getStartDateFormat(String start){
     
     //String SDate = this.jDateChooser1.getDate().toString();
     
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
     
     String date1 = sdf.format(start);
     
     System.out.println(date1);
     
     return date1;
 }

 private String getEndDateFormat(String end){
     //String EDate = this.jDateChooser2.getDate();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
     
     String date1 = sdf.format(end);
     
     System.out.println(date1);
      
     return date1;
 }
 
}

