package  de.etherapists.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BasicDAO {

    private final Logger logger = LoggerFactory.getLogger(BasicDAO.class);

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * get current session
     *
     * @return current session
     */
    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * get session factory
     *
     * @return session factory
     */
    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
