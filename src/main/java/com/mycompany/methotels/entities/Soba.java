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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Validate("required")
    @Column(name = "IME")
    private String ime;
    @Validate("required")
    @Column(name = "SPRAT")
    private String sprat;
    @Column(name = "TV")
    private Boolean tv;
    @Column(name = "INTERNET")
    private Boolean internet;
    @Column(name = "DJAKUZI")
    private Boolean djakuzi;

    @Inject
    public Soba() {
    }

    public Soba(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getSprat() {
        return sprat;
    }

    public void setSprat(String sprat) {
        this.sprat = sprat;
    }

    public Boolean getTv() {
        return tv;
    }

    public void setTv(Boolean tv) {
        this.tv = tv;
    }

    public Boolean getInternet() {
        return internet;
    }

    public void setInternet(Boolean internet) {
        this.internet = internet;
    }

    public Boolean getDjakuzi() {
        return djakuzi;
    }

    public void setDjakuzi(Boolean djakuzi) {
        this.djakuzi = djakuzi;
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
        if (!(object instanceof Soba)) {
            return false;
        }
        Soba other = (Soba) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.methotels.entities.Soba[ id=" + id + " ]";
    }
    
}
