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
@Table(name = "korisnik")
@NamedQueries({
    @NamedQuery(name = "Korisnik.findAll", query = "SELECT k FROM Korisnik k")})
public class Korisnik implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "KORISNIK_ID")
    private Integer korisnikId;
    @Validate("required")
    @Column(name = "KORISNIK_IME")
    private String korisnikIme;
    @Validate("required")
    @Column(name = "KORISNIK_PREZIME")
    private String korisnikPrezime;
    @Validate("required")
    @Column(name = "KORISNIK_ADRESA")
    private String korisnikAdresa;
    @Validate("required")
    @Column(name = "KORISNIK_TELEFON")
    private String korisnikTelefon;
    @Validate("required, maxLength=13, minLength=13")
    @Column(name = "KORISNIK_JMBG")
    private String korisnikJmbg;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private User userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "korisnikId")
    private List<Rezervacija> rezervacijaList;

    @Inject
    public Korisnik() {
    }

    public Korisnik(Integer korisnikId) {
        this.korisnikId = korisnikId;
    }

    public Integer getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Integer korisnikId) {
        this.korisnikId = korisnikId;
    }

    public String getKorisnikIme() {
        return korisnikIme;
    }

    public void setKorisnikIme(String korisnikIme) {
        this.korisnikIme = korisnikIme;
    }

    public String getKorisnikPrezime() {
        return korisnikPrezime;
    }

    public void setKorisnikPrezime(String korisnikPrezime) {
        this.korisnikPrezime = korisnikPrezime;
    }

    public String getKorisnikAdresa() {
        return korisnikAdresa;
    }

    public void setKorisnikAdresa(String korisnikAdresa) {
        this.korisnikAdresa = korisnikAdresa;
    }

    public String getKorisnikTelefon() {
        return korisnikTelefon;
    }

    public void setKorisnikTelefon(String korisnikTelefon) {
        this.korisnikTelefon = korisnikTelefon;
    }

    public String getKorisnikJmbg() {
        return korisnikJmbg;
    }

    public void setKorisnikJmbg(String korisnikJmbg) {
        this.korisnikJmbg = korisnikJmbg;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public List<Rezervacija> getRezervacijaList() {
        return rezervacijaList;
    }

    public void setRezervacijaList(List<Rezervacija> rezervacijaList) {
        this.rezervacijaList = rezervacijaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (korisnikId != null ? korisnikId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Korisnik)) {
            return false;
        }
        Korisnik other = (Korisnik) object;
        if ((this.korisnikId == null && other.korisnikId != null) || (this.korisnikId != null && !this.korisnikId.equals(other.korisnikId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ID = " + korisnikId + ", " + korisnikIme + " " + korisnikPrezime;
    }
    
}
