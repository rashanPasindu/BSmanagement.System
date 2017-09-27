/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces_hard;

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

/**
 *
 * @author DUL
 */
@Entity
@Table(name = "rolroq", catalog = "businessmanagementsystem", schema = "")
@NamedQueries({
    @NamedQuery(name = "Rolroq.findAll", query = "SELECT r FROM Rolroq r"),
    @NamedQuery(name = "Rolroq.findByProductID", query = "SELECT r FROM Rolroq r WHERE r.productID = :productID"),
    @NamedQuery(name = "Rolroq.findByProductName", query = "SELECT r FROM Rolroq r WHERE r.productName = :productName"),
    @NamedQuery(name = "Rolroq.findByRoq", query = "SELECT r FROM Rolroq r WHERE r.roq = :roq"),
    @NamedQuery(name = "Rolroq.findByDate", query = "SELECT r FROM Rolroq r WHERE r.date = :date")})
public class Rolroq implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Product_ID")
    private String productID;
    @Basic(optional = false)
    @Column(name = "Product_Name")
    private String productName;
    @Basic(optional = false)
    @Column(name = "ROQ")
    private String roq;
    @Basic(optional = false)
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;

    public Rolroq() {
    }

    public Rolroq(String productID) {
        this.productID = productID;
    }

    public Rolroq(String productID, String productName, String roq, Date date) {
        this.productID = productID;
        this.productName = productName;
        this.roq = roq;
        this.date = date;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        String oldProductID = this.productID;
        this.productID = productID;
        changeSupport.firePropertyChange("productID", oldProductID, productID);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        String oldProductName = this.productName;
        this.productName = productName;
        changeSupport.firePropertyChange("productName", oldProductName, productName);
    }

    public String getRoq() {
        return roq;
    }

    public void setRoq(String roq) {
        String oldRoq = this.roq;
        this.roq = roq;
        changeSupport.firePropertyChange("roq", oldRoq, roq);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        Date oldDate = this.date;
        this.date = date;
        changeSupport.firePropertyChange("date", oldDate, date);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productID != null ? productID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rolroq)) {
            return false;
        }
        Rolroq other = (Rolroq) object;
        if ((this.productID == null && other.productID != null) || (this.productID != null && !this.productID.equals(other.productID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "interfaces_hard.Rolroq[ productID=" + productID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
