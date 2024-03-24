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
    basePackages = "com.learn.java.multidb.repository.mysql.db2",
    entityManagerFactoryRef = "entityManagerFactory2",
    transactionManagerRef = "transactionManager2"
)
public class DataSourceConfig2 {

    @Bean
    @ConfigurationProperties(prefix = "datasource2")
    public DataSourceProperties dataSourceProperties2() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "datasource2")
    public DataSource dataSource2() {
        return dataSourceProperties2().initializeDataSourceBuilder().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory2() {
        LocalContainerEntityManagerFactoryBean em
          = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource2());
        em.setPackagesToScan("com.learn.java.multidb.entity.mysql.db2");
        em.setPersistenceProviderClass(org.hibernate.jpa.HibernatePersistenceProvider.class); // Specify Hibernate as the PersistenceProvider
        // Other configurations
//        em.setPersistenceUnitRootLocation
        // configure other entity manager properties
        return em;
    }

    @Bean
    public JpaTransactionManager transactionManager2(
        @Qualifier("entityManagerFactory2") LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        JpaTransactionManager transactionManager
          = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
          entityManagerFactory.getObject());
        return transactionManager;
    }
}
