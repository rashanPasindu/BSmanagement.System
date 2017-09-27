/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hard1;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DUL
 */
@Entity
@Table(name = "rorders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rorders.findAll", query = "SELECT r FROM Rorders r"),
    @NamedQuery(name = "Rorders.findByPOrderID", query = "SELECT r FROM Rorders r WHERE r.pOrderID = :pOrderID"),
    @NamedQuery(name = "Rorders.findBySuplier", query = "SELECT r FROM Rorders r WHERE r.suplier = :suplier"),
    @NamedQuery(name = "Rorders.findByRdate", query = "SELECT r FROM Rorders r WHERE r.rdate = :rdate"),
    @NamedQuery(name = "Rorders.findByDiscription", query = "SELECT r FROM Rorders r WHERE r.discription = :discription"),
    @NamedQuery(name = "Rorders.findByRmarks", query = "SELECT r FROM Rorders r WHERE r.rmarks = :rmarks"),
    @NamedQuery(name = "Rorders.findByBillnum", query = "SELECT r FROM Rorders r WHERE r.billnum = :billnum"),
    @NamedQuery(name = "Rorders.findByPayment", query = "SELECT r FROM Rorders r WHERE r.payment = :payment"),
    @NamedQuery(name = "Rorders.findByItem", query = "SELECT r FROM Rorders r WHERE r.item = :item")})
public class Rorders implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "POrderID")
    private Integer pOrderID;
    @Basic(optional = false)
    @Column(name = "suplier")
    private String suplier;
    @Basic(optional = false)
    @Column(name = "rdate")
    @Temporal(TemporalType.DATE)
    private Date rdate;
    @Basic(optional = false)
    @Column(name = "Discription")
    private String discription;
    @Basic(optional = false)
    @Column(name = "rmarks")
    private String rmarks;
    @Basic(optional = false)
    @Column(name = "billnum")
    private int billnum;
    @Basic(optional = false)
    @Column(name = "payment")
    private int payment;
    @Basic(optional = false)
    @Column(name = "Item")
    private String item;

    public Rorders() {
    }

    public Rorders(Integer pOrderID) {
        this.pOrderID = pOrderID;
    }

    public Rorders(Integer pOrderID, String suplier, Date rdate, String discription, String rmarks, int billnum, int payment, String item) {
        this.pOrderID = pOrderID;
        this.suplier = suplier;
        this.rdate = rdate;
        this.discription = discription;
        this.rmarks = rmarks;
        this.billnum = billnum;
        this.payment = payment;
        this.item = item;
    }

    public Integer getPOrderID() {
        return pOrderID;
    }

    public void setPOrderID(Integer pOrderID) {
        Integer oldPOrderID = this.pOrderID;
        this.pOrderID = pOrderID;
        changeSupport.firePropertyChange("POrderID", oldPOrderID, pOrderID);
    }

    public String getSuplier() {
        return suplier;
    }

    public void setSuplier(String suplier) {
        String oldSuplier = this.suplier;
        this.suplier = suplier;
        changeSupport.firePropertyChange("suplier", oldSuplier, suplier);
    }

    public Date getRdate() {
        return rdate;
    }

    public void setRdate(Date rdate) {
        Date oldRdate = this.rdate;
        this.rdate = rdate;
        changeSupport.firePropertyChange("rdate", oldRdate, rdate);
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        String oldDiscription = this.discription;
        this.discription = discription;
        changeSupport.firePropertyChange("discription", oldDiscription, discription);
    }

    public String getRmarks() {
        return rmarks;
    }

    public void setRmarks(String rmarks) {
        String oldRmarks = this.rmarks;
        this.rmarks = rmarks;
        changeSupport.firePropertyChange("rmarks", oldRmarks, rmarks);
    }

    public int getBillnum() {
        return billnum;
    }

    public void setBillnum(int billnum) {
        int oldBillnum = this.billnum;
        this.billnum = billnum;
        changeSupport.firePropertyChange("billnum", oldBillnum, billnum);
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        int oldPayment = this.payment;
        this.payment = payment;
        changeSupport.firePropertyChange("payment", oldPayment, payment);
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        String oldItem = this.item;
        this.item = item;
        changeSupport.firePropertyChange("item", oldItem, item);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pOrderID != null ? pOrderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rorders)) {
            return false;
        }
        Rorders other = (Rorders) object;
        if ((this.pOrderID == null && other.pOrderID != null) || (this.pOrderID != null && !this.pOrderID.equals(other.pOrderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hard1.Rorders[ pOrderID=" + pOrderID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
