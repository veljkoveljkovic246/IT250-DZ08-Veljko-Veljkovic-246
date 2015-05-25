/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.services;

import com.mycompany.methotels.entities.Rezervacija;
import java.util.List;

/**
 *
 * @author Veljko
 */
public interface RezervacijaDao {


    public List<Rezervacija> getListaSvihRezervacija();

    public Rezervacija getRezervacijaById(Integer rezervacijaId);

    public void dodajRezervaciju(Rezervacija rezervacija);

    public void obrisiRezervaciju(Integer rezervacijaId);
}