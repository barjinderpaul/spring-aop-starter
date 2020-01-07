package com.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {

    public void addAccount() {
        System.out.println(getClass() + "  " + " :: Adding account ::");
    }

    public String addUser(String firstName){
        System.out.println(getClass() + " " + firstName);
        return firstName;
    }

    public void throwingException() {
        throw new IllegalArgumentException("Threw some exception");
    }

}
