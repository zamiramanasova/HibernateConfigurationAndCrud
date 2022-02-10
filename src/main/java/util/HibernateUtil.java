package util;

import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

        private static final SessionFactory session = buildSession();

        private static SessionFactory buildSession(){
            try {
                return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            }catch (Throwable ex){
                System.out.println("Session not created");
                throw new ExceptionInInitializerError(ex);
            }
        }

        public static SessionFactory getSession() {
            return session;
        }

        public static void shutdown() {
            getSession().close();
        }


}
