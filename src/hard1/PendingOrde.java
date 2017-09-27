/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hard1;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DUL
 */
@Entity
@Table(name = "pending orde")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PendingOrde.findAll", query = "SELECT p FROM PendingOrde p"),
    @NamedQuery(name = "PendingOrde.findByPOrderID", query = "SELECT p FROM PendingOrde p WHERE p.pOrderID = :pOrderID"),
    @NamedQuery(name = "PendingOrde.findBySuplier", query = "SELECT p FROM PendingOrde p WHERE p.suplier = :suplier"),
    @NamedQuery(name = "PendingOrde.findByItem", query = "SELECT p FROM PendingOrde p WHERE p.item = :item"),
    @NamedQuery(name = "PendingOrde.findByDescription", query = "SELECT p FROM PendingOrde p WHERE p.description = :description")})
public class PendingOrde implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "POrderID")
    private Integer pOrderID;
    @Basic(optional = false)
    @Column(name = "Suplier")
    private String suplier;
    @Basic(optional = false)
    @Column(name = "Item")
    private String item;
    @Basic(optional = false)
    @Column(name = "Description")
    private String description;

    public PendingOrde() {
    }

    public PendingOrde(Integer pOrderID) {
        this.pOrderID = pOrderID;
    }

    public PendingOrde(Integer pOrderID, String suplier, String item, String description) {
        this.pOrderID = pOrderID;
        this.suplier = suplier;
        this.item = item;
        this.description = description;
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

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        String oldItem = this.item;
        this.item = item;
        changeSupport.firePropertyChange("item", oldItem, item);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        String oldDescription = this.description;
        this.description = description;
        changeSupport.firePropertyChange("description", oldDescription, description);
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
        if (!(object instanceof PendingOrde)) {
            return false;
        }
        PendingOrde other = (PendingOrde) object;
        if ((this.pOrderID == null && other.pOrderID != null) || (this.pOrderID != null && !this.pOrderID.equals(other.pOrderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hard1.PendingOrde[ pOrderID=" + pOrderID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
