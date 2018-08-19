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
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import java.sql.SQLException;

import static cn.com.microcent.config.CoreDataSourceConfig.ENTITY_MANAGER_FACTORY;
import static cn.com.microcent.config.CoreDataSourceConfig.PACKAGE;
import static cn.com.microcent.config.CoreDataSourceConfig.PLATFORM_TX_MANAGER;

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
public class CoreDataSourceConfig {

    public static final String SIGN = "core"; // 唯一标识

    public static final String DATASOURCE = SIGN + "Datasource";
    public static final String DATASOURCE_PREFIX = SIGN + ".datasource";
    public static final String PERSISTENCE_UNIT = SIGN + "PersistenceUnit";
    public static final String ENTITY_MANAGER = SIGN + "EntityManager";
    public static final String ENTITY_MANAGER_FACTORY = SIGN + "EntityManagerFactory";
    public static final String PLATFORM_TX_MANAGER = SIGN + "PlatformTransactionManager";
    public static final String PACKAGE = "cn.com.microcent.repository." + SIGN;

    @Value("${" + SIGN + ".datasource.driver-class-name}")
    private String driverClassName;

    @Value("${" + SIGN + ".datasource.url}")
    private String url;

    @Value("${" + SIGN + ".datasource.username}")
    private String username;

    @Value("${" + SIGN + ".datasource.password}")
    private String password;

    @Value("${" + SIGN + ".datasource.type}")
    private String type;

    @Value("${" + SIGN + ".datasource.initialSize}")
    private int initialSize;

    @Value("${" + SIGN + ".datasource.minIdle}")
    private int minIdle;

    @Value("${" + SIGN + ".datasource.maxActive}")
    private int maxActive;

    @Value("${" + SIGN + ".datasource.maxWait}")
    private int maxWait;

    @Value("${" + SIGN + ".datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${" + SIGN + ".datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${" + SIGN + ".datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${" + SIGN + ".datasource.validationQuery}")
    private String validationQuery;

    @Value("${" + SIGN + ".datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${" + SIGN + ".datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${" + SIGN + ".datasource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${" + SIGN + ".datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${" + SIGN + ".datasource.filters}")
    private String filters;

    @Autowired
    private JpaProperties jpaProperties;

    @Bean(name = DATASOURCE)
    @Primary
//    @ConfigurationProperties(prefix = DATASOURCE_PREFIX)
    public DataSource coreDataSource() {
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
    @Primary
    public EntityManager coreEntityManager(@Qualifier(ENTITY_MANAGER_FACTORY) EntityManagerFactory
                                                   entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

    @Bean(name = ENTITY_MANAGER_FACTORY)
    @Primary
    public LocalContainerEntityManagerFactoryBean coreEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(coreDataSource())
                .packages("cn.com.microcent.model." + SIGN)
                .persistenceUnit(PERSISTENCE_UNIT)
                .properties(jpaProperties.getProperties())
                .build();
    }

    @Bean(name = PLATFORM_TX_MANAGER)
    @Primary
    public PlatformTransactionManager corePlatformTransactionManager(@Qualifier(ENTITY_MANAGER_FACTORY)
                                                                             EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
