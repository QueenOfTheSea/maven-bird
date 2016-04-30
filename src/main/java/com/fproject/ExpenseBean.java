/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fproject;

import java.time.LocalDate;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author lamya
 */
@Stateless
public class ExpenseBean {
    @EJB
    private ExpenseEntityFacade expenseEntityFacade;

    public void createExpense(String name,LocalDate date,Double amount){
        expenseEntityFacade.createExpense(name, date, amount);
    }
}
