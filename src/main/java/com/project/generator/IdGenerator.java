package com.project.generator;

import java.io.Serializable;
import java.util.Random;
import java.util.logging.Logger;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.SequenceGenerator;
import org.springframework.session.Session;

public class IdGenerator extends SequenceGenerator{

    Random r = new Random();
    private org.jboss.logging.Logger log = LoggerFactory.logger(IdGenerator.class);
    Session session;

    int attempt = 0;
    
    public int generate6DigitNumber()
    {
        int aNumber = (int) ((Math.random() * 600000000) + 100000); 
        return aNumber;
    }
    
    public Serializable generate(SessionImplementor sessionImplementor, Object obj)
    {
        session = (Session) sessionImplementor;
        Integer id = generateRandomIndex();
        return id;
    }
    
    public Integer generateRandomIndex()
    {
        for (int i = 0; i < 3; i++){
             log.info("attempt: "+i);
             Integer a = generate6DigitNumber();
             log.info("index: " + String.valueOf(a));
             return a;
        }
        
        for (int i = 100000; i < 9999999;i++) {
        	return i;
        }
        return null;
}
}
