package org.keith.camelsandboxapp.route;

import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.PollingConsumer;
import org.apache.camel.Processor;
import org.apache.camel.builder.endpoint.EndpointRouteBuilder;
import org.keith.camelsandboxapp.model.CamelSandboxBean;
import org.keith.camelsandboxapp.model.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.apache.camel.builder.endpoint.StaticEndpointBuilders.stream;

@Component
public class CamelSandboxRouter extends EndpointRouteBuilder {

    @Autowired
    CamelSandboxBean AppBean;

    @Autowired
    @Qualifier("empDataSource")
    DataSource dataSource;

    @Override
    public void configure() throws Exception {

        // getContext().addRoutes(new RouteBuilderA());
        // getContext().addRoutes(new RouteBuilderB());

        /*
         * from("timer:hello?period={{myPeriod}}")
         * .routeId("hello")
         * // and call the bean
         * .bean(AppBean, "saySomething")
         * // and print it to system out via stream component
         * .to("stream:out");
         */

        /*
         * from(
         * "stream:file?fileName=/home/keith/temp/test.log&scanStream=true&scanStreamDelay=1000")
         * //.to("bean:logService?method=parseLogLine");
         * .to("stream:out");
         */

        /*
         *
         * //static creation
         * //StreamComponent sc = new StreamComponent();
         * //getCamelContext().addComponent("sc", sc);
         * //Endpoint sOut = StaticEndpointBuilders.stream("out").resolve(getContext());
         * //Endpoint sOut = sc.createEndpoint("stream:out");;
         * from(stream("file")
         * .fileName("/home/keith/temp/test.log")
         * .scanStream(true)
         * .scanStreamDelay(100))
         * //.to(StaticEndpointBuilders.log("org.apache.camel.example?level=DEBUG"));
         * //.to(stream("file").fileName("/dev/stdout"));
         * //.to(stream("out"));
         * .to(sOut);
         */

        // api
        /*
         * rest("/say")
         * .get("/hello").to("direct:hello")
         * .get("/bye").consumes("application/json").to("direct:bye")
         * .post("/bye").to("mock:update");
         * //pipe
         * from("direct:hello")
         * .transform().constant("Hello World!!!");
         * //pipe
         * from("direct:bye")
         * .transform().constant("Bye World");
         */


         /* from("sql:select * from employees.employees?dataSource=#empDataSource")
         .routeId("test1")
          .to("stream:out");*/


       /* Endpoint endpoint = getCamelContext()

                .getEndpoint("sql:select * from employees.employees?dataSource=#empDataSource");
        PollingConsumer consumer = endpoint.createPollingConsumer();
        Exchange exchange = consumer.receive();*/

        // from("direct:qq").to("stream:out")
        // to("controlbus:route?routeId=test1&action=stop&async=true");

            /*  from("direct:hello")
                        .setBody(constant("select * from employees")).split(body())
                .to("jdbc:empDataSource")
                        .to("stream:out");*/

        // Select Route
      /*  from("direct:select").setBody(constant("select * from employees.employees")).to("jdbc:empDataSource")
                .process(new Processor() {
                    public void process(Exchange xchg) throws Exception {
                        //the camel jdbc select query has been executed. We get the list of employees.
                        ArrayList<Map<String, String>> dataList = (ArrayList<Map<String, String>>) xchg.getIn()
                                .getBody();
                        List<Employee> employees = new ArrayList<Employee>();
                        System.out.println(dataList);
                        for (Map<String, String> data : dataList) {
                            Employee employee = new Employee();
                            employee.setEmpNo(data.get("emp_no"));
                            employee.setEmpLastName(data.get("last_name"));
                            sud
                            System.out.println("Employee: "+ employee);
                            employees.add(employee);
                        }

                        xchg.getIn().setBody(employees);
                    }
                }).to("stream:out"); */


        //onException(ConnectException.class).to("stream:out");
        from("timer://timer1?period=1000")
                .setBody(constant("select * from employees.employees"))
                .to("jdbc:empDataSource")
                .split().simple("${body}")
                .log("process row ${body}")
                .process(new Processor() {

                    public void process(Exchange xchg) throws Exception {

                        Map<String, Object> row = xchg.getIn().getBody(Map.class);
                        System.out.println("Processing....." + row);

                        Employee emp = new Employee();
                        emp.setEmpNo(row.get("emp_no").toString());
                        emp.setEmpDob(row.get("birth_date").toString());
                        emp.setEmpFirstName(row.get("first_name").toString());
                        emp.setEmpLastName(row.get("last_name").toString());
                        emp.setEmpGender(row.get("gender").toString());
                        emp.setEmpHireDate(row.get("hire_date").toString());

                        System.out.println("Employee: " + emp);

                    }

                })
                .to("mock:result");

    }

}


       /* from("direct:hello")
                .setBody(constant("select * from employees")).split(body())
                .to("jdbc:empDataSource")
                .split().simple("${body}")
                .log("process row ${body}");
        */

//?outputType=StreamList")
//.split(body()).streaming()


