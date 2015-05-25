/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.services;

import com.mycompany.methotels.entities.Korisnik;
import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Veljko
 */
public class KorisnikDaoImpl implements KorisnikDao{
    
    @Inject
    private Session session;


    
    @Override
    public List<Korisnik> getListaSvihKorisnika() {
        return session.createCriteria(Korisnik.class).list();
    }

    @Override
    public Korisnik getKorisnikById(Integer korisnikId) {
        System.out.println("Integer je " + korisnikId);
        return (Korisnik) session.createCriteria(Korisnik.class).add(Restrictions.eq("id",
                korisnikId)).uniqueResult();
    }

    @Override
    public void dodajKorisnika(Korisnik korisnik) {
        session.persist(korisnik);
    }

    @Override
    public void obrisiKorisnika(Integer korisnikId) {
        Korisnik korisnik = (Korisnik) session.createCriteria(Korisnik.class).add(Restrictions.eq("id",
                korisnikId)).uniqueResult();
        session.delete(korisnik);
    }
}
