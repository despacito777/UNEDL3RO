/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastmenu;

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

/**
 *
 * @author maike
 */
@Entity
@Table(name = "postres", catalog = "fastmenu", schema = "")
@NamedQueries({
    @NamedQuery(name = "Postres.findAll", query = "SELECT p FROM Postres p")
    , @NamedQuery(name = "Postres.findById", query = "SELECT p FROM Postres p WHERE p.id = :id")
    , @NamedQuery(name = "Postres.findByPostre", query = "SELECT p FROM Postres p WHERE p.postre = :postre")
    , @NamedQuery(name = "Postres.findByPrecio", query = "SELECT p FROM Postres p WHERE p.precio = :precio")})
public class Postres implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "postre")
    private String postre;
    @Basic(optional = false)
    @Column(name = "precio")
    private int precio;

    public Postres() {
    }

    public Postres(Integer id) {
        this.id = id;
    }

    public Postres(Integer id, String postre, int precio) {
        this.id = id;
        this.postre = postre;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getPostre() {
        return postre;
    }

    public void setPostre(String postre) {
        String oldPostre = this.postre;
        this.postre = postre;
        changeSupport.firePropertyChange("postre", oldPostre, postre);
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        int oldPrecio = this.precio;
        this.precio = precio;
        changeSupport.firePropertyChange("precio", oldPrecio, precio);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Postres)) {
            return false;
        }
        Postres other = (Postres) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fastmenu.Postres[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
