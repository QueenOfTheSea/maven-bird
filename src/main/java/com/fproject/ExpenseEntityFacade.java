/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fproject;

import java.time.LocalDate;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lamya
 */
@Stateless
public class ExpenseEntityFacade extends AbstractFacade<ExpenseEntity> {
    @PersistenceContext(unitName = "FProjectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExpenseEntityFacade() {
        super(ExpenseEntity.class);
    }
    
    public boolean createExpense(String name,LocalDate date,Double amount, UserEntity user, String type, Boolean important){
        ExpenseEntity ee=new ExpenseEntity();
        ee.setName(name);
        ee.setAmount(amount);
        ee.setExpenseDate(date);
        ee.setUser(user);
        ee.setImportant(important);
        ee.setType(type);
        em.persist(ee);
        em.flush();
        return true;
    }
    
}
