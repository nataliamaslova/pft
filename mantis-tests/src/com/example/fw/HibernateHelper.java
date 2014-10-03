package com.example.fw;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateHelper extends HelperBase {

	public HibernateHelper(ApplicationManager manager) {
	  super(manager);
	}

    public List<User> listUsers() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            return (List<User>) session.createQuery("from User").list();
        } finally {
            trans.commit();
        }
    }

}
