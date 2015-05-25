/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.pages;

import com.mycompany.methotels.entities.Hotel;
import com.mycompany.methotels.entities.Soba;
import com.mycompany.methotels.services.ProtectedPage;
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
public class DodavanjeSoba {
    
    @Property
    private Soba soba;
    
    @Property
    private Soba onesoba;
    
    @Inject
    private Messages messages;
    
    @Inject
    private SobaHotelDao hotelDao;
    
    @Property
    private Hotel hotId;
    
    
    @Property
    @Persist
    private List<Hotel> hoteli;
    public ValueEncoder getEncoder(){
        return new ValueEncoder<Hotel>(){
        
        @Override
        public String toClient(Hotel h){
            return String.valueOf(h.getHotelId());
        }
        @Override
        public Hotel toValue(String string){
            Hotel hot = hotelDao.getHotelById(Integer.parseInt(string));
            return hot;
        }
    };
    }
    
    @Property
    private List<Soba> sobe;
    void onActivate(){
        soba = new Soba();
        if (sobe == null){
            sobe = new ArrayList<Soba>();
        }
        sobe = hotelDao.getListaSvihSoba();
        hoteli = hotelDao.getListaSvihHotela();
    }
    
    @CommitAfter
    Object onSuccess() {
        soba.setHotelId(hotId);
        hotelDao.dodajSobu(soba);
        return this;
    }
    
    public String getHotel(){
        if (onesoba.getHotelId() != null){
            return onesoba.getHotelId().getHotelIme();
        }else {
            return "";
        }
    }
    
    @CommitAfter
    Object onActionFromDelete(int sobaId){
        hotelDao.obrisiSobu(sobaId);
        return this;
    }
    
}
