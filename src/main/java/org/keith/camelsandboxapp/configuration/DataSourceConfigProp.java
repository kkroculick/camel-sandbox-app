package org.keith.camelsandboxapp.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

//@PropertySource("classpath:YourName.properties")
//keeperProperties with both @Component and @ConfigurationProperties(prefix="zookeeper"). This will make ZookeeperProperties autowire-able.
@Component
@ConfigurationProperties(prefix = "spring.datasource.emp")
@Data
@Validated
public class DataSourceConfigProp {

    // @NotBlank(message = "Name field cannot be Blank!")
    // private String name;

    @NotBlank(message = "URL field cannot be Blank!")
    private String jdbcUrl;

    @NotBlank(message = "You should specify the appropriate driver class!")
    private String driverClassName;

    @NotBlank(message = "Username field cannot be Blank!")
    private String username;

    @NotBlank(message = "Password field can not be Blank!")
    private String password;

}
