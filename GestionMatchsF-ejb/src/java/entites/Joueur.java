/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author domitille
 */
@Entity
public class Joueur extends SuperPersonne implements Serializable {

    @OneToMany(mappedBy = "joueur")
    private List<HistoriqueJoueur> historiqueJoueurs;

    @OneToMany(mappedBy = "joueurF")
    private List<Faute> fautes;

    public List<HistoriqueJoueur> getHistoriqueJoueurs() {
        return historiqueJoueurs;
    }

    public void setHistoriqueJoueurs(List<HistoriqueJoueur> historiqueJoueurs) {
        this.historiqueJoueurs = historiqueJoueurs;
    }

    public List<Faute> getFautes() {
        return fautes;
    }

    public void setFautes(List<Faute> fautes) {
        this.fautes = fautes;
    }

    @ManyToMany(mappedBy = "composition2")
    private List<Matchs> matchsJoueur2;

    public List<Matchs> getMatchsJoueur2() {
        return matchsJoueur2;
    }

    public void setMatchsJoueur2(List<Matchs> matchsJoueur2) {
        this.matchsJoueur2 = matchsJoueur2;
    }

    public List<Matchs> getMatchsJoueur1() {
        return matchsJoueur1;
    }

    public void setMatchsJoueur1(List<Matchs> matchsJoueur1) {
        this.matchsJoueur1 = matchsJoueur1;
    }

    @ManyToMany(mappedBy = "Composition1")
    private List<Matchs> matchsJoueur1;

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
        if (!(object instanceof Joueur)) {
            return false;
        }
        Joueur other = (Joueur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Joueurs[ id=" + id + " ]";
    }
    
    
    


    
    private Date dateInterdiction;

    /**
     * Get the value of dateInterdiction
     *
     * @return the value of dateInterdiction
     */
    public Date getDateInterdiction() {
        return dateInterdiction;
    }

    /**
     * Set the value of dateInterdiction
     *
     * @param dateInterdiction new value of dateInterdiction
     */
    public void setDateInterdiction(Date dateInterdiction) {
        this.dateInterdiction = dateInterdiction;
    }


}
