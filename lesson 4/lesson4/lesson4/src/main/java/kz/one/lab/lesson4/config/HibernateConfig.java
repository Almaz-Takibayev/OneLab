package kz.one.lab.lesson4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;
//
//@Configuration
//@EnableTransactionManagement
//public class HibernateConfig {
//
//    @Bean
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
//        factory.setPackagesToScan("kz.one.lab.lesson4.entity");
//        factory.setHibernateProperties(hibernateProperties());
//        factory.setDataSource(dataSource());
//        return factory;
//    }
//
//    @Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/lesson4_onelab?useUnicode=true&serverTimezone=UTC");
//        dataSource.setUsername("root");
//        dataSource.setPassword("");
//
//        return dataSource;
//    }
//
//    private final Properties hibernateProperties(){
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.hbm2ddl.auto", "update"); //"create-drop or update"
//        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
//        properties.setProperty("hibernate.show_sql","true");
//        return properties;
//    }
//
//}