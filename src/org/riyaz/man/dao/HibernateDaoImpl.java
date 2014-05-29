package org.riyaz.man.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.riyaz.man.model.Drive_geotag_history;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class HibernateDaoImpl {
	
	@Autowired
	private SessionFactory sessionFactory;

	public int getDriveGeotagHistoryCount()
	{
		String hql="select count(*) from Drive_geotag_history";
		Query query = getSessionFactory().openSession().createQuery(hql);
		int result = ((Long) query.uniqueResult()).intValue();
		return result;
	}
	
	public Drive_geotag_history getDriveGeotagHistory(int Id)
	{
		Session a = getSessionFactory().openSession();
		Drive_geotag_history result = (Drive_geotag_history)(a.get(Drive_geotag_history.class, Id));
		a.close();
		return result;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessoinFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
