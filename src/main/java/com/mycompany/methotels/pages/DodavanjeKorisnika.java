/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.pages;

import com.mycompany.methotels.entities.Korisnik;
import com.mycompany.methotels.entities.User;
import com.mycompany.methotels.services.KorisnikDao;
import com.mycompany.methotels.services.ProtectedPage;
import com.mycompany.methotels.services.UserDao;
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
public class DodavanjeKorisnika {
    
    
    @Property
    private Korisnik korisnik;
    
    @Property
    private Korisnik onekorisnik;
    
    @Inject
    private Messages messages;
    
    @Inject
    private UserDao userDao;
    
    @Inject
    private KorisnikDao korisnikDao;
    
    @Property
    private User usrId;
    
    
    @Property
    @Persist
    private List<User> useri;
    
    
    public ValueEncoder getEncoder(){
        return new ValueEncoder<User>(){
        
        @Override
        public String toClient(User u){
            return String.valueOf(u.getUserId());
        }
        @Override
        public User toValue(String string){
            User us = userDao.getUserById(Integer.parseInt(string));
            return us;
        }
    };
        
       
        
    }
    
    @Property
    private List<Korisnik> korisnici;
    void onActivate(){
        korisnik = new Korisnik();
        if (korisnici == null){
            korisnici = new ArrayList<Korisnik>();
        }
        
        
        korisnici = korisnikDao.getListaSvihKorisnika();
        useri = userDao.getListaSvihUsera();
    }
    
    @CommitAfter
    Object onSuccess() {
        korisnik.setUserId(usrId);
        korisnikDao.dodajKorisnika(korisnik);
       
        return this;
    }
    
    //vraca User u t:grid
    public User getUser(){
        if (onekorisnik.getUserId() != null){
            return onekorisnik.getUserId();
        }else {
            
        }
        return null;
    }
    
 
    @CommitAfter
    Object onActionFromDelete(int korisnikId){
        korisnikDao.obrisiKorisnika(korisnikId);
        return this;
    }
 
     
}