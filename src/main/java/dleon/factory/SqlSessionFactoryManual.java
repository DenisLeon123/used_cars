package dleon.factory;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryManual {
    private static SqlSessionFactory sessionFactory = null;
    private static String CONFIGURATION_FILE = "mybatis-config.xml";

    public static SqlSessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
            return sessionFactory;
        }

        return sessionFactory;
    }

    private static SqlSessionFactory buildSessionFactory() {
        try {
            Reader reader = Resources.getResourceAsReader(CONFIGURATION_FILE);
            return sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception exception) {
            System.out.printf(exception.getMessage());
        }

        return null;
    }
}
