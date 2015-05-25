/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.services;

import com.mycompany.methotels.entities.Rezervacija;
import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Veljko
 */
public class RezervacijaDaoImpl implements RezervacijaDao{
   
    
    @Inject
    private Session session;


    
    @Override
    public List<Rezervacija> getListaSvihRezervacija() {
        return session.createCriteria(Rezervacija.class).list();
    }

    @Override
    public Rezervacija getRezervacijaById(Integer rezervacijaId) {
        System.out.println("Integer je " + rezervacijaId);
        return (Rezervacija) session.createCriteria(Rezervacija.class).add(Restrictions.eq("id", rezervacijaId)).uniqueResult();
    }

    @Override
    public void dodajRezervaciju(Rezervacija rezervacija) {
        session.persist(rezervacija);
    }

    @Override
    public void obrisiRezervaciju(Integer rezervacijaId) {
        Rezervacija rezervacija = (Rezervacija) session.createCriteria(Rezervacija.class).add(Restrictions.eq("id",
                rezervacijaId)).uniqueResult();
        session.delete(rezervacija);
    }

}
