/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author katia
 */
@Entity
public class HistoriqueEntraineur implements Serializable {

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
        if (!(object instanceof HistoriqueEntraineur)) {
            return false;
        }
        HistoriqueEntraineur other = (HistoriqueEntraineur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.HistoriqueEntraineur[ id=" + id + " ]";
    }
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebutEnt;

    /**
     * Get the value of dateDebutEnt
     *
     * @return the value of dateDebutEnt
     */
    public Date getDateDebutEnt() {
        return dateDebutEnt;
    }

    /**
     * Set the value of dateDebutEnt
     *
     * @param dateDebutEnt new value of dateDebutEnt
     */
    public void setDateDebutEnt(Date dateDebutEnt) {
        this.dateDebutEnt = dateDebutEnt;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFinEnt;

    /**
     * Get the value of dateFinEnt
     *
     * @return the value of dateFinEnt
     */
    public Date getDateFinEnt() {
        return dateFinEnt;
    }

    /**
     * Set the value of dateFinEnt
     *
     * @param dateFinEnt new value of dateFinEnt
     */
    public void setDateFinEnt(Date dateFinEnt) {
        this.dateFinEnt = dateFinEnt;
    }

    @ManyToOne
    private Entraineur entraineur;

    /**
     * Get the value of entraineur
     *
     * @return the value of entraineur
     */
    public Entraineur getEntraineur() {
        return entraineur;
    }

    /**
     * Set the value of entraineur
     *
     * @param entraineur new value of entraineur
     */
    public void setEntraineur(Entraineur entraineur) {
        this.entraineur = entraineur;
    }

    @ManyToOne
    private Equipe equipeEntraineur;

    /**
     * Get the value of equipeEntraineur
     *
     * @return the value of equipeEntraineur
     */
    public Equipe getEquipeEntraineur() {
        return equipeEntraineur;
    }

    /**
     * Set the value of equipeEntraineur
     *
     * @param equipeEntraineur new value of equipeEntraineur
     */
    public void setEquipeEntraineur(Equipe equipeEntraineur) {
        this.equipeEntraineur = equipeEntraineur;
    }

}
