/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fproject;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mohamed
 */
@Stateless
public class UserEntityFacade extends AbstractFacade<UserEntity> {
    @PersistenceContext(unitName = "FProjectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserEntityFacade() {
        super(UserEntity.class);
    }
    
    
    public boolean createUser(String login, String password){
        UserEntity u = new UserEntity();
        u.setLogin(login);
        u.setPassword(password);
        em.persist(u);
        em.flush();
        return true;
    }
    
}
