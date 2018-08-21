package cn.com.microcent.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
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

import java.sql.SQLException;

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
    public static final String DATASOURCE_PREFIX = SIGN + ".datasource.";
    public static final String PERSISTENCE_UNIT = SIGN + "PersistenceUnit";
    public static final String ENTITY_MANAGER = SIGN + "EntityManager";
    public static final String ENTITY_MANAGER_FACTORY = SIGN + "EntityManagerFactory";
    public static final String PLATFORM_TX_MANAGER = SIGN + "PlatformTransactionManager";
    public static final String PACKAGE = "cn.com.microcent.repository." + SIGN;

    @Value("${" + DATASOURCE_PREFIX + "driver-class-name}")
    private String driverClassName;

    @Value("${" + DATASOURCE_PREFIX + "url}")
    private String url;

    @Value("${" + DATASOURCE_PREFIX + "username}")
    private String username;

    @Value("${" + DATASOURCE_PREFIX + "password}")
    private String password;

    @Value("${" + "spring.datasource.type}")
    private String type;

    @Value("${" + "spring.datasource.initialSize}")
    private int initialSize;

    @Value("${" + "spring.datasource.minIdle}")
    private int minIdle;

    @Value("${" + "spring.datasource.maxActive}")
    private int maxActive;

    @Value("${" + "spring.datasource.maxWait}")
    private int maxWait;

    @Value("${" + "spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${" + "spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${" + "spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${" + "spring.datasource.validationQuery}")
    private String validationQuery;

    @Value("${" + "spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${" + "spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${" + "spring.datasource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${" + "spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${" + "spring.datasource.filters}")
    private String filters;

    @Autowired
    private JpaProperties jpaProperties;

    @Bean(name = DATASOURCE)
    public DataSource logDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        dataSource.setTimeBetweenConnectErrorMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        try {
            dataSource.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataSource;
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
                .packages("cn.com.microcent.domain." + SIGN)
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
