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
public class Faute implements Serializable {

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
        if (!(object instanceof Faute)) {
            return false;
        }
        Faute other = (Faute) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Fautes[ id=" + id + " ]";
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

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFaute;

    /**
     * Get the value of dateFaute
     *
     * @return the value of dateFaute
     */
    public Date getDateFaute() {
        return dateFaute;
    }

    /**
     * Set the value of dateFaute
     *
     * @param dateFaute new value of dateFaute
     */
    public void setDateFaute(Date dateFaute) {
        this.dateFaute = dateFaute;
    }
    
    @Column (nullable = false)
    private carton typeFaute;

    /**
     * Get the value of faute
     *
     * @return the value of faute
     */
    public carton getTypeFaute() {
        return typeFaute;
    }

    /**
     * Set the value of faute
     *
     * @param typeFaute new value of faute
     */
    public void setTypeFaute(carton typeFaute) {
        this.typeFaute = typeFaute;
    }
    
    @ManyToOne
    private Match match;

    /**
     * Get the value of match
     *
     * @return the value of match
     */
    public Match getMatch() {
        return match;
    }

    /**
     * Set the value of match
     *
     * @param match new value of match
     */
    public void setMatch(Match match) {
        this.match = match;
    }
    
   


}
