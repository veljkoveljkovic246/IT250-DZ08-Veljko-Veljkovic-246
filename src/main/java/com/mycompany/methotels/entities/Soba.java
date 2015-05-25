/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Veljko
 */
@Entity
@Table(name = "soba")
@NamedQueries({
    @NamedQuery(name = "Soba.findAll", query = "SELECT s FROM Soba s")})
public class Soba implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sobaId")
    private List<Rezervacija> rezervacijaList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SOBA_ID")
    private Integer sobaId;
    @Validate("required")
    @Column(name = "SOBA_IME")
    private String sobaIme;
    @Validate("required")
    @Column(name = "SOBA_SPRAT")
    private String sobaSprat;
    @Column(name = "SOBA_TV")
    private Boolean sobaTv;
    @Column(name = "SOBA_INTERNET")
    private Boolean sobaInternet;
    @Column(name = "SOBA_DJAKUZI")
    private Boolean sobaDjakuzi;
    @JoinColumn(name = "HOTEL_ID", referencedColumnName = "HOTEL_ID")
    @ManyToOne(optional = false)
    private Hotel hotelId;

    @Inject
    public Soba() {
    }

    public Soba(Integer sobaId) {
        this.sobaId = sobaId;
    }

    public Integer getSobaId() {
        return sobaId;
    }

    public void setSobaId(Integer sobaId) {
        this.sobaId = sobaId;
    }

    public String getSobaIme() {
        return sobaIme;
    }

    public void setSobaIme(String sobaIme) {
        this.sobaIme = sobaIme;
    }

    public String getSobaSprat() {
        return sobaSprat;
    }

    public void setSobaSprat(String sobaSprat) {
        this.sobaSprat = sobaSprat;
    }

    public Boolean getSobaTv() {
        return sobaTv;
    }

    public void setSobaTv(Boolean sobaTv) {
        this.sobaTv = sobaTv;
    }

    public Boolean getSobaInternet() {
        return sobaInternet;
    }

    public void setSobaInternet(Boolean sobaInternet) {
        this.sobaInternet = sobaInternet;
    }

    public Boolean getSobaDjakuzi() {
        return sobaDjakuzi;
    }

    public void setSobaDjakuzi(Boolean sobaDjakuzi) {
        this.sobaDjakuzi = sobaDjakuzi;
    }

    public Hotel getHotelId() {
        return hotelId;
    }

    public void setHotelId(Hotel hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sobaId != null ? sobaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Soba)) {
            return false;
        }
        Soba other = (Soba) object;
        if ((this.sobaId == null && other.sobaId != null) || (this.sobaId != null && !this.sobaId.equals(other.sobaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ID = " + sobaId + ", " + sobaIme;
    }

    public List<Rezervacija> getRezervacijaList() {
        return rezervacijaList;
    }

    public void setRezervacijaList(List<Rezervacija> rezervacijaList) {
        this.rezervacijaList = rezervacijaList;
    }
    
}
