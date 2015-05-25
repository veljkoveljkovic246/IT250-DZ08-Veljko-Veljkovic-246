/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Veljko
 */
@Entity
@Table(name = "rezervacija")
@NamedQueries({
    @NamedQuery(name = "Rezervacija.findAll", query = "SELECT r FROM Rezervacija r")})
public class Rezervacija implements Serializable {
    @JoinColumn(name = "KORISNIK_ID", referencedColumnName = "KORISNIK_ID")
    @ManyToOne(optional = false)
    private Korisnik korisnikId;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "REZERVACIJA_ID")
    private Integer rezervacijaId;
    @JoinColumn(name = "SOBA_ID", referencedColumnName = "SOBA_ID")
    @ManyToOne(optional = false)
    private Soba sobaId;


    @Inject
    public Rezervacija() {
    }

    public Rezervacija(Integer rezervacijaId) {
        this.rezervacijaId = rezervacijaId;
    }

    public Integer getRezervacijaId() {
        return rezervacijaId;
    }

    public void setRezervacijaId(Integer rezervacijaId) {
        this.rezervacijaId = rezervacijaId;
    }

    public Soba getSobaId() {
        return sobaId;
    }

    public void setSobaId(Soba sobaId) {
        this.sobaId = sobaId;
    }

    public Korisnik getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Korisnik korisnikId) {
        this.korisnikId = korisnikId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rezervacijaId != null ? rezervacijaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rezervacija)) {
            return false;
        }
        Rezervacija other = (Rezervacija) object;
        if ((this.rezervacijaId == null && other.rezervacijaId != null) || (this.rezervacijaId != null && !this.rezervacijaId.equals(other.rezervacijaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.methotels.entities.Rezervacija[ rezervacijaId=" + rezervacijaId + " ]";
    }

}
