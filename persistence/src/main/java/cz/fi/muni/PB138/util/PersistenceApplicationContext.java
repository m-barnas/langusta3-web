package cz.fi.muni.PB138.util;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Erik Macej 433744, on 25.05.17.
 * @author Erik Macej 433744
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
@ComponentScan("cz.fi.muni.PB138.dao")
public class PersistenceApplicationContext {

    /**
     * Enables automatic translation of exceptions to DataAccessExceptions.
     */
    @Bean
    public PersistenceExceptionTranslationPostProcessor postProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

    /**
     * Starts up a container that emulates behavior prescribed in JPA spec for container-managed EntityManager
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean jpaFactoryBean = new LocalContainerEntityManagerFactoryBean();
        jpaFactoryBean.setDataSource(db());
        jpaFactoryBean.setLoadTimeWeaver(instrumentationLoadTimeWeaver());

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        jpaFactoryBean.setJpaVendorAdapter(vendorAdapter);
        jpaFactoryBean.setJpaProperties(additionalProperties());

        return jpaFactoryBean;
    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public LoadTimeWeaver instrumentationLoadTimeWeaver() {
        return new InstrumentationLoadTimeWeaver();
    }

    @Bean
    public DataSource db() {
        DriverManagerDataSource driver = new DriverManagerDataSource();
        driver.setDriverClassName("org.postgresql.Driver");
        driver.setUrl("jdbc:postgresql://localhost:5432/langusta3db");
        driver.setUsername("langusta3user");
        driver.setPassword("langusta3passwd");

        return driver;
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.getProperty("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
        properties.setProperty("hibernate.hbm2ddl.auto", "validate");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");

        return properties;
    }
}
