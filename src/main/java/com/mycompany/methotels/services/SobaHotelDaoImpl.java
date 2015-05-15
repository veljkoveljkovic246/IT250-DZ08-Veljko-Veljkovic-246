/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.services;

import com.mycompany.methotels.entities.Hotel;
import com.mycompany.methotels.entities.Soba;
import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Veljko
 */
public class SobaHotelDaoImpl implements SobaHotelDao {

    @Inject
    private Session session;


    
    @Override
    public List<Hotel> getListaSvihHotela() {
        return session.createCriteria(Hotel.class).list();
    }

    @Override
    public Hotel getHotelById(Integer hotelId) {
        System.out.println("Integer je " + hotelId);
        return (Hotel) session.createCriteria(Hotel.class).add(Restrictions.eq("id", hotelId)).uniqueResult();
    }

    @Override
    public void dodajHotel(Hotel hotel) {
        session.persist(hotel);
    }

    @Override
    public void obrisiHotel(Integer hotelId) {
        Hotel hotel = (Hotel) session.createCriteria(Hotel.class).add(Restrictions.eq("id",
                hotelId)).uniqueResult();
        session.delete(hotel);
    }

    @Override
    public List<Soba> getListaSvihSoba() {
        return session.createCriteria(Soba.class).list();
    }

    @Override
    public Soba getSobaById(Integer sobaId) {
        return (Soba) session.createCriteria(Soba.class).add(Restrictions.eq("id", sobaId)).uniqueResult();
    }

    @Override
    public void dodajSobu(Soba soba) {
        session.persist(soba);
    }

    @Override
    public void obrisiSobu(Integer sobaId) {
        Soba soba = (Soba) session.createCriteria(Soba.class).add(Restrictions.eq("id", sobaId)).uniqueResult();
        session.delete(soba);
    }

 
}