/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.pages;

import com.mycompany.methotels.entities.Hotel;
import com.mycompany.methotels.services.SobaHotelDao;
import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Veljko
 */
public class DodavanjeHotela {
    
    @Property
    private Hotel hotel;
    
    @Property
    private Hotel onehotel;
    
    @Inject
    private SobaHotelDao hotelDao;
    
    @Property
    private List<Hotel> hoteli;

    void onActivate(){
        if (hoteli == null){
            hoteli = new ArrayList<Hotel>();
        }
        
        hoteli = hotelDao.getListaSvihHotela();
    }
    
    @CommitAfter
    Object onSuccess() {
        // persist metoda ?uva objekatu bazi podataka
        hotelDao.dodajHotel(hotel);
        return this;
    }

    @CommitAfter
    Object onActionFromDelete(int hotelId) {
        hotelDao.obrisiHotel(hotelId);
        return this;
    }

}


