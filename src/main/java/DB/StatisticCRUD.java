package DB;

import org.hibernate.Session;

public class StatisticCRUD {

    public void save(Statistic statistic) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(statistic);
        session.flush();
        session.close();
    }
}
