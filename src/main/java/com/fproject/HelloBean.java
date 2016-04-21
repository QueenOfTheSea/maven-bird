/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fproject;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author mohamed
 */
@Stateless
public class HelloBean {

    @EJB
    private UserEntityFacade userEntityFacade;

    public List<UserEntity> getAll() {
        return userEntityFacade.findAll();
    }

    public void createUser(String login, String password) {
        userEntityFacade.createUser(login, password);
    }

}
