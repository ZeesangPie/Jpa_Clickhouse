package com.example.jpatest.Configuration;

import com.example.jpatest.Base.BaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EntityScan(basePackages = "com.example.jpatest.Entity.Clickhouse")
@EnableJpaRepositories(
        basePackages = "com.example.jpatest.Repository.Clickhouse",
        entityManagerFactoryRef = "clickhouseEntityManagerFactory",
        transactionManagerRef = "clickhouseTransactionManager",
        repositoryBaseClass = BaseRepositoryImpl.class)
//        enableDefaultTransactions = false)
@EnableTransactionManagement
public class ClickhouseConfig {
    @Autowired
    @Qualifier("clickhouseDataSource")
    private DataSource dataSource;

    @Autowired
    @Qualifier("vendorClickhouseProperties")
    private Map<String, Object> vendorProperties;

    @Bean(name = "clickhouseEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean clickhouseEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .properties(vendorProperties)
                .packages("com.example.jpatest.Entity.Clickhouse")
                .persistenceUnit("clickhousePersistenceUnit")
                .build();
    }

    @Bean(name = "clickhouseEntityManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return clickhouseEntityManagerFactory(builder).getObject().createEntityManager();
    }

    @Bean(name = "clickhouseTransactionManager")
    PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(clickhouseEntityManagerFactory(builder).getObject());
    }

}
