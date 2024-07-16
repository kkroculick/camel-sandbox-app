package org.keith.camelsandboxapp.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("AppBean")
public class CamelSandboxBean {
    private int counter;

    @Value("${greeting}")
    private String say;

    public String saySomething(String body) {
        return String.format("%s I am invoked %d times", say, ++counter);
    }
}
