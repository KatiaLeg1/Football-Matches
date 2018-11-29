/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author domitille
 */
@Entity
public class Equipe extends Personne implements Serializable {

    @OneToMany(mappedBy = "equipeJoueur")
    private List<HistoriqueJoueur> historiqueJoueurs;

    @OneToMany(mappedBy = "equipeEntraineur")
    private List<HistoriqueEntraineur> historiqueEntraineurs;

    @OneToMany(mappedBy = "EquipeDeux")
    private List<Match> matchs2;

    public List<Match> getMatchs2() {
        return matchs2;
    }

    public void setMatchs2(List<Match> matchs2) {
        this.matchs2 = matchs2;
    }

    public List<Match> getMatchs1() {
        return matchs1;
    }

    public void setMatchs1(List<Match> matchs1) {
        this.matchs1 = matchs1;
    }

    @OneToMany(mappedBy = "equipeUn")
    private List<Match> matchs1;

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
        if (!(object instanceof Equipe)) {
            return false;
        }
        Equipe other = (Equipe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Equipes[ id=" + id + " ]";
    }
    
    


    
        @Column (unique=true, nullable=false)
        private String nomequipe;

    /**
     * Get the value of nomequipe
     *
     * @return the value of nomequipe
     */
    public String getNomequipe() {
        return nomequipe;
    }

    /**
     * Set the value of nomequipe
     *
     * @param nomequipe new value of nomequipe
     */
    public void setNomequipe(String nomequipe) {
        this.nomequipe = nomequipe;
    }

    
        private int pointEquipe;

    /**
     * Get the value of pointEquipe
     *
     * @return the value of pointEquipe
     */
    public int getPointEquipe() {
        return pointEquipe;
    }

    /**
     * Set the value of pointEquipe
     *
     * @param pointEquipe new value of pointEquipe
     */
    public void setPointEquipe(int pointEquipe) {
        this.pointEquipe = pointEquipe;
    }

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

    
}
