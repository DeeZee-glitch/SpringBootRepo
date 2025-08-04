package com.example.DemoZain.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.DemoZain.repository.caapp",
        entityManagerFactoryRef = "caappEntityManagerFactory",
        transactionManagerRef = "caappTransactionManager"
)
public class CAAppDbConfig {

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.caapp")
    public DataSource caappDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean caappEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("caappDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.DemoZain.model.caapp")
                .persistenceUnit("caapp")
                .build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager caappTransactionManager(
            @Qualifier("caappEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
