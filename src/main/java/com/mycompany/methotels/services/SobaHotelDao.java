/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.services;

import com.mycompany.methotels.entities.Hotel;
import java.util.List;
import com.mycompany.methotels.entities.Soba;

/**
 *
 * @author Veljko
 */
public interface SobaHotelDao {


    public List<Hotel> getListaSvihHotela();

    public Hotel getHotelById(Integer hotelId);

    public void dodajHotel(Hotel hotel);

    public void obrisiHotel(Integer hotelId);

    public List<Soba> getListaSvihSoba();

    public Soba getSobaById(Integer sobaId);

    public void dodajSobu(Soba soba);

    public void obrisiSobu(Integer sobaId);
}