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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author katia
 */
@Entity
public class Match implements Serializable {

    @OneToMany(mappedBy = "match")
    private List<Faute> fautes;

    public List<Faute> getFautes() {
        return fautes;
    }

    public void setFautes(List<Faute> fautes) {
        this.fautes = fautes;
    }

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
        if (!(object instanceof Match)) {
            return false;
        }
        Match other = (Match) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Match[ id=" + id + " ]";
    }
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateMatch;

    /**
     * Get the value of dateMatch
     *
     * @return the value of dateMatch
     */
    public Date getDateMatch() {
        return dateMatch;
    }

    /**
     * Set the value of dateMatch
     *
     * @param dateMatch new value of dateMatch
     */
    public void setDateMatch(Date dateMatch) {
        this.dateMatch = dateMatch;
    }

    @Column (nullable = false)
    private String heure;

    /**
     * Get the value of heure
     *
     * @return the value of heure
     */
    public String getHeure() {
        return heure;
    }

    /**
     * Set the value of heure
     *
     * @param heure new value of heure
     */
    public void setHeure(String heure) {
        this.heure = heure;
    }

    
    private int butEquipeUn;

    /**
     * Get the value of butEquipeUn
     *
     * @return the value of butEquipeUn
     */
    public int getButEquipeUn() {
        return butEquipeUn;
    }

    /**
     * Set the value of butEquipeUn
     *
     * @param butEquipeUn new value of butEquipeUn
     */
    public void setButEquipeUn(int butEquipeUn) {
        this.butEquipeUn = butEquipeUn;
    }

    private int butEquipeDeux;

    /**
     * Get the value of butEquipeDeux
     *
     * @return the value of butEquipeDeux
     */
    public int getButEquipeDeux() {
        return butEquipeDeux;
    }

    /**
     * Set the value of butEquipeDeux
     *
     * @param butEquipeDeux new value of butEquipeDeux
     */
    public void setButEquipeDeux(int butEquipeDeux) {
        this.butEquipeDeux = butEquipeDeux;
    }

    @ManyToOne
    private Equipe equipeUn;

    /**
     * Get the value of equipeUn
     *
     * @return the value of equipeUn
     */
    public Equipe getEquipeUn() {
        return equipeUn;
    }

    /**
     * Set the value of equipeUn
     *
     * @param equipeUn new value of equipeUn
     */
    public void setEquipeUn(Equipe equipeUn) {
        this.equipeUn = equipeUn;
    }
    
    @ManyToOne
    private Equipe EquipeDeux;

    /**
     * Get the value of EquipeDeux
     *
     * @return the value of EquipeDeux
     */
    public Equipe getEquipeDeux() {
        return EquipeDeux;
    }

    /**
     * Set the value of EquipeDeux
     *
     * @param EquipeDeux new value of EquipeDeux
     */
    public void setEquipeDeux(Equipe EquipeDeux) {
        this.EquipeDeux = EquipeDeux;
    }
    
    @ManyToOne
    private Arbitre arbitre;

    /**
     * Get the value of arbitre
     *
     * @return the value of arbitre
     */
    public Arbitre getArbitre() {
        return arbitre;
    }

    /**
     * Set the value of arbitre
     *
     * @param arbitre new value of arbitre
     */
    public void setArbitre(Arbitre arbitre) {
        this.arbitre = arbitre;
    }
    
    @ManyToMany
    private List<Joueur> Composition1;

    /**
     * Get the value of Composition1
     *
     * @return the value of Composition1
     */
    public List<Joueur> getComposition1() {
        return Composition1;
    }

    /**
     * Set the value of Composition1
     *
     * @param Composition1 new value of Composition1
     */
    public void setComposition1(List<Joueur> Composition1) {
        this.Composition1 = Composition1;
    }

    @ManyToMany
    private List<Joueur> composition2;

    /**
     * Get the value of composition2
     *
     * @return the value of composition2
     */
    public List<Joueur> getComposition2() {
        return composition2;
    }

    /**
     * Set the value of composition2
     *
     * @param composition2 new value of composition2
     */
    public void setComposition2(List<Joueur> composition2) {
        this.composition2 = composition2;
    }


}
