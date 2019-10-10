package com.srpago.gasws.rest.core.persistence.operation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.srpago.gasws.rest.core.persistence.entities.DatosVenta;
public class DbOperations {
 

    public static SessionFactory getSessionFactory() {
        Configuration configObj = new Configuration();
        configObj.configure("/hibernate.cfg.xml");
 
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 
 
        SessionFactory factoryObj = configObj.buildSessionFactory(serviceRegistryObj);      
        return factoryObj;
    }
 
   
    public static Integer saveData(DatosVenta datosVenta) {
        Session sessionObj = getSessionFactory().openSession();
 
        Transaction transObj = sessionObj.beginTransaction();
        sessionObj.save(datosVenta);
 
        transObj.commit();
 
        sessionObj.close();
       
        return datosVenta.getId();
    }
    
    public static void main(String[]args) {
    	 Configuration configObj = new Configuration();
         configObj.configure("/hibernate.cfg.xml");
  
         ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 
  
         SessionFactory factoryObj = configObj.buildSessionFactory(serviceRegistryObj);  
    }
 
}