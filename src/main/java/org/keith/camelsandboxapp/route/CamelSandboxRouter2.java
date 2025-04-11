package org.keith.camelsandboxapp.route;

import org.keith.camelsandboxapp.model.CamelSandboxBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.camel.builder.endpoint.EndpointRouteBuilder;

@Component
public class CamelSandboxRouter2 extends EndpointRouteBuilder {

    @Autowired
    CamelSandboxBean AppBean;

    @Override
    public void configure() throws Exception {

        System.out.println("route2");
        //getContext().addRoutes(new RouteBuilderA());
       //getContext().addRoutes(new RouteBuilderB());
     /*   from("timer:hello?period={{myPeriod}}").routeId("hello2")

                // and call the bean
                .bean(AppBean, "saySomething")
                // and print it to system out via stream component
                .to("stream:out");*/

       /* from("stream:file?fileName=/home/keith/temp/test.log&scanStream=true&scanStreamDelay=1000")
                //.to("bean:logService?method=parseLogLine");
                .to("stream:out");*/

    }
}
