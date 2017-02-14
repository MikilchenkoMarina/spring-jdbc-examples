package inspoDataBase.hibernateUsageDataBase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by mmikilchenko on 14.02.2017.
 */
@Configuration
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
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
        sfb.setDataSource(dataSource());
        sfb.setPackagesToScan(new String[]{"inspoDataBase"});
        Properties props= new Properties();
        props.setProperty("dialect","org.hibernate.dialect.H2Dialect");
        sfb.setHibernateProperties(props);
        return sfb;
   }




}
