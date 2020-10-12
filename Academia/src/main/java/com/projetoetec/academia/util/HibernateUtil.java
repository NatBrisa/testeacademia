/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetoetec.academia.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author natal
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory = createSessionFactory();
    
    public static SessionFactory getSessionFactory() {
            return sessionFactory;
    }
    
    private static SessionFactory createSessionFactory () {
        try {
            Configuration config = new Configuration().configure();
            ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
            SessionFactory factory = config.buildSessionFactory(registry);
            return factory; 
        } catch (HibernateException ex) {
            System.err.println("A fábrica de sessões não pode ser criada." + ex);
            throw new ExceptionInInitializerError(ex);
        }		
    }
}
