/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author katia
 */
@Entity
@Inheritance
(strategy=InheritanceType.TABLE_PER_CLASS)

public class SuperPersonne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof SuperPersonne)) {
            return false;
        }
        SuperPersonne other = (SuperPersonne) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

  
       @Column (nullable=false)
    private String nomPersonne;

    /**
     * Get the value of nomPersonne
     *
     * @return the value of nomPersonne
     */
    public String getNomPersonne() {
        return nomPersonne;
    }

    /**
     * Set the value of nomPersonne
     *
     * @param nomPersonne new value of nomPersonne
     */
    public void setNomPersonne(String nomPersonne) {
        this.nomPersonne = nomPersonne;
    }

    @Column (nullable=false)
    private String prenomPersonne;

    /**
     * Get the value of prenomPersonne
     *
     * @return the value of prenomPersonne
     */
    public String getPrenomPersonne() {
        return prenomPersonne;
    }

    /**
     * Set the value of prenomPersonne
     *
     * @param prenomPersonne new value of prenomPersonne
     */
    public void setPrenomPersonne(String prenomPersonne) {
        this.prenomPersonne = prenomPersonne;
    }
}
