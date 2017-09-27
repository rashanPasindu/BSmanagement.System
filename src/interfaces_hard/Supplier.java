/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces_hard;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rashan
 */
@Entity
@Table(name = "supplier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Supplier.findAll", query = "SELECT s FROM Supplier s")
    , @NamedQuery(name = "Supplier.findBySupplierId", query = "SELECT s FROM Supplier s WHERE s.supplierId = :supplierId")
    , @NamedQuery(name = "Supplier.findBySupplierName", query = "SELECT s FROM Supplier s WHERE s.supplierName = :supplierName")
    , @NamedQuery(name = "Supplier.findBySupplierEmail", query = "SELECT s FROM Supplier s WHERE s.supplierEmail = :supplierEmail")
    , @NamedQuery(name = "Supplier.findByContactPerspn", query = "SELECT s FROM Supplier s WHERE s.contactPerspn = :contactPerspn")
    , @NamedQuery(name = "Supplier.findByContactTelNumber", query = "SELECT s FROM Supplier s WHERE s.contactTelNumber = :contactTelNumber")
    , @NamedQuery(name = "Supplier.findByCompanyName", query = "SELECT s FROM Supplier s WHERE s.companyName = :companyName")
    , @NamedQuery(name = "Supplier.findBySupNIC", query = "SELECT s FROM Supplier s WHERE s.supNIC = :supNIC")})
public class Supplier implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "supplier_Id")
    private Integer supplierId;
    @Basic(optional = false)
    @Column(name = "supplier_Name")
    private String supplierName;
    @Basic(optional = false)
    @Column(name = "supplier_email")
    private String supplierEmail;
    @Basic(optional = false)
    @Column(name = "contact_perspn")
    private String contactPerspn;
    @Basic(optional = false)
    @Column(name = "contact_tel_number")
    private int contactTelNumber;
    @Basic(optional = false)
    @Column(name = "CompanyName")
    private String companyName;
    @Basic(optional = false)
    @Column(name = "SupNIC")
    private String supNIC;

    public Supplier() {
    }

    public Supplier(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Supplier(Integer supplierId, String supplierName, String supplierEmail, String contactPerspn, int contactTelNumber, String companyName, String supNIC) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierEmail = supplierEmail;
        this.contactPerspn = contactPerspn;
        this.contactTelNumber = contactTelNumber;
        this.companyName = companyName;
        this.supNIC = supNIC;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        Integer oldSupplierId = this.supplierId;
        this.supplierId = supplierId;
        changeSupport.firePropertyChange("supplierId", oldSupplierId, supplierId);
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        String oldSupplierName = this.supplierName;
        this.supplierName = supplierName;
        changeSupport.firePropertyChange("supplierName", oldSupplierName, supplierName);
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        String oldSupplierEmail = this.supplierEmail;
        this.supplierEmail = supplierEmail;
        changeSupport.firePropertyChange("supplierEmail", oldSupplierEmail, supplierEmail);
    }

    public String getContactPerspn() {
        return contactPerspn;
    }

    public void setContactPerspn(String contactPerspn) {
        String oldContactPerspn = this.contactPerspn;
        this.contactPerspn = contactPerspn;
        changeSupport.firePropertyChange("contactPerspn", oldContactPerspn, contactPerspn);
    }

    public int getContactTelNumber() {
        return contactTelNumber;
    }

    public void setContactTelNumber(int contactTelNumber) {
        int oldContactTelNumber = this.contactTelNumber;
        this.contactTelNumber = contactTelNumber;
        changeSupport.firePropertyChange("contactTelNumber", oldContactTelNumber, contactTelNumber);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        String oldCompanyName = this.companyName;
        this.companyName = companyName;
        changeSupport.firePropertyChange("companyName", oldCompanyName, companyName);
    }

    public String getSupNIC() {
        return supNIC;
    }

    public void setSupNIC(String supNIC) {
        String oldSupNIC = this.supNIC;
        this.supNIC = supNIC;
        changeSupport.firePropertyChange("supNIC", oldSupNIC, supNIC);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supplierId != null ? supplierId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supplier)) {
            return false;
        }
        Supplier other = (Supplier) object;
        if ((this.supplierId == null && other.supplierId != null) || (this.supplierId != null && !this.supplierId.equals(other.supplierId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "interfaces_hard.Supplier[ supplierId=" + supplierId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
