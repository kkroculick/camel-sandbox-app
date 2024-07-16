package org.keith.camelsandboxapp.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    // inject props

    // @ConfigurationProperties("spring.datasource.emp")
    // put in config props to make autowireable
    @Bean
    public DataSourceConfigProp dataSourceConfigProperties() {
        return new DataSourceConfigProp();
    }

    /*
     * // old way
     * 
     * @Value("${db.url}")
     * private String URL;
     * 
     * @Value("${db.username}")
     * private String USERNAME;
     * 
     * @Value("${db.password}")
     * private String PASSWORD;
     * 
     * @Value("${hibernate.hbm2ddl.auto}")
     * private String HBM2DDL;
     * 
     * @Value("${hibernate.show_sql}")
     * private String SHOW_SQL;
     * 
     * @Value("${hibernate.dialect}")
     * private String DIALECT;
     * 
     * @Value("${spring.entitymanager.packagestoscan}")
     * private String packagesToscan;
     */

    /*
     * @Bean(name = "empDataSource")
     * 
     * @Primary
     * public DataSource dataSource() {
     * // return DataSourceBuilder.create().type(BasicDataSource.class).build();
     * 
     * //return DataSourceBuilder.create().build();
     * /*
     * DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
     * dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
     * dataSourceBuilder.url("jdbc:mysql://localhost:3306/employees");
     * dataSourceBuilder.username("keith");
     * dataSourceBuilder.password("Password1");
     * return dataSourceBuilder.build();
     */

    // }*/

    @Bean(name = "empDataSource")
    @Primary
    //@ConfigurationProperties("spring.datasource.emp")
    public DataSource dataSource(DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    /*
     * public HikariDataSource dataSource() {
     * return DataSourceBuilder.create().type(HikariDataSource.class).build();
     * }
     */
}