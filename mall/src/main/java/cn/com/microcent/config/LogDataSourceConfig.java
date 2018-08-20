package cn.com.microcent.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import static cn.com.microcent.config.LogDataSourceConfig.ENTITY_MANAGER_FACTORY;
import static cn.com.microcent.config.LogDataSourceConfig.PACKAGE;
import static cn.com.microcent.config.LogDataSourceConfig.PLATFORM_TX_MANAGER;

/**
 * Created by xingwen on 2018/8/17.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = ENTITY_MANAGER_FACTORY,
        transactionManagerRef = PLATFORM_TX_MANAGER,
        basePackages = PACKAGE
)
public class LogDataSourceConfig {

    public static final String SIGN = "log"; // 唯一标识

    public static final String DATASOURCE = SIGN + "Datasource";
    public static final String DATASOURCE_PREFIX = SIGN + ".datasource";
    public static final String PERSISTENCE_UNIT = SIGN + "PersistenceUnit";
    public static final String ENTITY_MANAGER = SIGN + "EntityManager";
    public static final String ENTITY_MANAGER_FACTORY = SIGN + "EntityManagerFactory";
    public static final String PLATFORM_TX_MANAGER = SIGN + "PlatformTransactionManager";
    public static final String PACKAGE = "cn.com.microcent.repository." + SIGN;

    @Autowired
    private JpaProperties jpaProperties;

    @Bean(name = DATASOURCE)
    @ConfigurationProperties(prefix = DATASOURCE_PREFIX)
    public DataSource logDataSource() {
        return new DruidDataSource();
    }

    @Bean(name = ENTITY_MANAGER)
    public EntityManager logEntityManager(@Qualifier(ENTITY_MANAGER_FACTORY) EntityManagerFactory
                                                  entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

    @Bean(name = ENTITY_MANAGER_FACTORY)
    public LocalContainerEntityManagerFactoryBean logEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(logDataSource())
                .packages("cn.com.microcent.model." + SIGN)
                .persistenceUnit(PERSISTENCE_UNIT)
                .properties(jpaProperties.getProperties())
                .build();
    }

    @Bean(name = PLATFORM_TX_MANAGER)
    public PlatformTransactionManager logPlatformTransactionManager(@Qualifier(ENTITY_MANAGER_FACTORY)
                                                                            EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
