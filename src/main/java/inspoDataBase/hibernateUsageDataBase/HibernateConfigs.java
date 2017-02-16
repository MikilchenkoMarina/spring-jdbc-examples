package inspoDataBase.hibernateUsageDataBase;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by mmikilchenko on 14.02.2017.
 */
@Configuration
@ComponentScan
public class HibernateConfigs {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/inspominder");
        ds.setUsername("root");
        ds.setPassword("admin");
        return ds;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
        sfb.setDataSource(dataSource());
        sfb.setPackagesToScan(new String[]{"inspoDataBase.hibernateUsageDataBase.entity"});
        Properties props = new Properties();
        props.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
        sfb.setHibernateProperties(props);
        return sfb;
    }

    @Bean
    public HibernateTransactionManager txManager(SessionFactory sessionFactory) {
        HibernateTransactionManager htxm = new HibernateTransactionManager(sessionFactory);
        return htxm;
    }

}
