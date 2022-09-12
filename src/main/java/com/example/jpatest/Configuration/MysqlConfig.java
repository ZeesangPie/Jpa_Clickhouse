package com.example.jpatest.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.example.jpatest.Repository.MySQL",
        entityManagerFactoryRef = "mysqlEntityManagerFactory",
        transactionManagerRef = "mysqlTransactionManager")
public class MysqlConfig {
    @Autowired
    @Qualifier("mysqlDataSource")
    private DataSource mysqlDataSource;

    @Autowired
    @Qualifier("vendorProperties")
    private Map<String, Object> vendorProperties;

    @Bean(name = "mysqlEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(mysqlDataSource)
                .properties(vendorProperties)
                .packages("com.example.jpatest.Entity.MySQL")
                .persistenceUnit("mysql")
                .build();
    }

    @Bean(name = "mysqlEntityManager")
//    @Primary
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return mysqlEntityManagerFactory(builder).getObject().createEntityManager();
    }

    @Bean(name = "mysqlTransactionManager")
//    @Primary
    PlatformTransactionManager mysqlTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(mysqlEntityManagerFactory(builder).getObject());
    }


}
