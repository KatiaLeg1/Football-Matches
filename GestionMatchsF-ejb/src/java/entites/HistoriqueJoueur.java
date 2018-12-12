/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
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
public class HistoriqueJoueur implements Serializable {

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
        if (!(object instanceof HistoriqueJoueur)) {
            return false;
        }
        HistoriqueJoueur other = (HistoriqueJoueur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.HistoriqueJoueur[ id=" + id + " ]";
    }
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebutEq;

    /**
     * Get the value of dateDebutEq
     *
     * @return the value of dateDebutEq
     */
    public Date getDateDebutEq() {
        return dateDebutEq;
    }

    /**
     * Set the value of dateDebutEq
     *
     * @param dateDebutEq new value of dateDebutEq
     */
    public void setDateDebutEq(Date dateDebutEq) {
        this.dateDebutEq = dateDebutEq;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(nullable = true)
    private Date dateFinEq;

    /**
     * Get the value of dateFinEq
     *
     * @return the value of dateFinEq
     */
    public Date getDateFinEq() {
        return dateFinEq;
    }

    /**
     * Set the value of dateFinEq
     *
     * @param dateFinEq new value of dateFinEq
     */
    public void setDateFinEq(Date dateFinEq) {
        this.dateFinEq = dateFinEq;
    }
    
    @ManyToOne
        private Joueur joueur;

    /**
     * Get the value of joueur
     *
     * @return the value of joueur
     */
    public Joueur getJoueur() {
        return joueur;
    }

    /**
     * Set the value of joueur
     *
     * @param joueur new value of joueur
     */
    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    @ManyToOne
    private Equipe equipeJoueur;

    /**
     * Get the value of equipeJoueur
     *
     * @return the value of equipeJoueur
     */
    public Equipe getEquipeJoueur() {
        return equipeJoueur;
    }

    /**
     * Set the value of equipeJoueur
     *
     * @param equipeJoueur new value of equipeJoueur
     */
    public void setEquipeJoueur(Equipe equipeJoueur) {
        this.equipeJoueur = equipeJoueur;
    }

}
