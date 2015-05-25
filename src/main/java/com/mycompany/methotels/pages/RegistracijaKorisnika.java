/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.pages;

import com.mycompany.methotels.data.Role;
import com.mycompany.methotels.entities.User;
import com.mycompany.methotels.services.UserDao;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Veljko
 */

public class RegistracijaKorisnika {

    @Property
    private User userReg;
    @SessionState
    private User loggedInUser;
    @Inject
    private UserDao userDao;
    @Component
    private BeanEditForm form;

    public String getMD5Hash(String yourString) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(yourString.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }

    @CommitAfter
    Object onSuccess() {
        if (!userDao.checkIfEmailExists(userReg.getUserEmail())) {
            String unhashPassword = userReg.getUserSifra();
            userReg.setUserSifra(getMD5Hash(unhashPassword));
            userReg.setUserRola(Role.Korisnik);
            User u = userDao.registerUsera(userReg);
            loggedInUser = u;
            return Index.class;
        } else {
            form.recordError("Email koji ste uneli vec postoji");
            return null;
        }
    }
}