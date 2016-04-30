/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fproject;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lamya
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
    
    public UserEntity getUser(String login,String password){
        List<UserEntity> liste=em.createQuery("SELECT u FROM UserEntity u WHERE u.login= :login and u.password= :password")
    .setParameter("login", login).setParameter("password", password).getResultList();
        return liste.get(0);
    }
    
}
