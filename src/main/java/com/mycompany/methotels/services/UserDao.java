/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.services;

import com.mycompany.methotels.entities.User;
import java.util.List;

/**
 *
 * @author Veljko
 */
public interface UserDao {
   

    public List<User> getListaSvihUsera();

    public User getUserById(Integer userId);

    public User registerUsera(User user);

    public void obrisiUsera(Integer userId); 

    public User checkUser(String email, String password);

    public boolean checkIfEmailExists(String email);


}
