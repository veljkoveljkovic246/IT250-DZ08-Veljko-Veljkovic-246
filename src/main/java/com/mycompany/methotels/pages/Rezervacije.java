/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.pages;

import com.mycompany.methotels.entities.Korisnik;
import com.mycompany.methotels.entities.Rezervacija;
import com.mycompany.methotels.entities.Soba;
import com.mycompany.methotels.services.KorisnikDao;
import com.mycompany.methotels.services.ProtectedPage;
import com.mycompany.methotels.services.RezervacijaDao;
import com.mycompany.methotels.services.SobaHotelDao;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Veljko
 */


@ProtectedPage
@RolesAllowed(value={"Admin"})
public class Rezervacije {
    
    @Property
    private Rezervacija rezervacija;
    
    @Property
    private Rezervacija onerezervacija;
    
    @Inject
    private Messages messages;
    
    @Inject
    private KorisnikDao korisnikDao;
    
    @Inject
    private RezervacijaDao rezervacijaDao;
    
    @Property
    private Korisnik korisId;
    
    
    @Property
    @Persist
    private List<Korisnik> korisnici;
    
    
    public ValueEncoder getEncoder(){
        return new ValueEncoder<Korisnik>(){
        
        @Override
        public String toClient(Korisnik k){
            return String.valueOf(k.getKorisnikId());
        }
        @Override
        public Korisnik toValue(String string){
            Korisnik kor = korisnikDao.getKorisnikById(Integer.parseInt(string));
            return kor;
        }
    };
        
       
        
    }
    
    @Property
    private List<Rezervacija> rezervacije;
    void onActivate(){
        rezervacija = new Rezervacija();
        if (rezervacije == null){
            rezervacije = new ArrayList<Rezervacija>();
        }
        
        rezervacije = rezervacijaDao.getListaSvihRezervacija();
        korisnici = korisnikDao.getListaSvihKorisnika();
        sobe = sobaDao.getListaSvihSoba();
    }
    
    @CommitAfter
    Object onSuccess() {
        rezervacija.setKorisnikId(korisId);
        rezervacija.setSobaId(sobId);
        sobaDao.dodajSobu(sobId);
        rezervacijaDao.dodajRezervaciju(rezervacija);
        return this;
    }
    
    //vraca korisnika u t:grid
    public Korisnik getKorisnik(){
        if (onerezervacija.getKorisnikId() != null){
            return onerezervacija.getKorisnikId();
        }else {
            
        }
        return null;
    }
    
    //vraca sobu u t:grid
    public Soba getSoba(){
        if (onerezervacija.getSobaId() != null){
            return onerezervacija.getSobaId();
        }else {
            
        }
        return null;
    }
    @CommitAfter
    Object onActionFromDelete(int rezervacijaId){
        rezervacijaDao.obrisiRezervaciju(rezervacijaId);
        return this;
    }
 
    
    
    
    
    // SLEDICI KOD SLUZI ZA POLJE SOBA ID
    
    
    @Inject
    private SobaHotelDao sobaDao;
    
    @Property
    private Soba sobId;
    
    @Property
    @Persist
    private List<Soba> sobe;


    public ValueEncoder getEncoder2(){
        return new ValueEncoder<Soba>(){
        
        @Override
        public String toClient(Soba s){
            return String.valueOf(s.getSobaId());
        }
        @Override
        public Soba toValue(String string){
            Soba sob = sobaDao.getSobaById(Integer.parseInt(string));
            return sob;
        }
    };
        
       
        
    }








}
