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
        basePackages = "com.example.DemoZain.repository.zain",
        entityManagerFactoryRef = "zainEntityManagerFactory",
        transactionManagerRef = "zainTransactionManager"
)
public class ZainDbConfig {

    @Bean
    @ConfigurationProperties(prefix = "zain.datasource")
    public DataSource zainDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean zainEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("zainDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.DemoZain.model.zain")
                .persistenceUnit("zain")
                .build();
    }

    @Bean
    public PlatformTransactionManager zainTransactionManager(
            @Qualifier("zainEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
