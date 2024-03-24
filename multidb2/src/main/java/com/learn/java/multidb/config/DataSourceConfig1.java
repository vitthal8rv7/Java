package com.learn.java.multidb.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.learn.java.multidb.repository.mysql.db1",
    entityManagerFactoryRef = "entityManagerFactory1",
    transactionManagerRef = "transactionManager1"
)
public class DataSourceConfig1 {

    @Bean
    @ConfigurationProperties(prefix = "datasource1")
    public DataSourceProperties dataSourceProperties1() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "datasource1")
    public DataSource dataSource1() {
        return dataSourceProperties1().initializeDataSourceBuilder().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory1() {
        LocalContainerEntityManagerFactoryBean em
          = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource1());
        em.setPackagesToScan("com.learn.java.multidb.entity.mysql.db1");
        em.setPersistenceProviderClass(org.hibernate.jpa.HibernatePersistenceProvider.class); // Specify Hibernate as the PersistenceProvider
        // Other configurations
//        em.setPersistenceUnitRootLocation
        // configure other entity manager properties
        return em;
    }

    @Bean
    public JpaTransactionManager transactionManager1(
        @Qualifier("entityManagerFactory1") LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        JpaTransactionManager transactionManager
          = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
          entityManagerFactory.getObject());
        return transactionManager;
    }
}
