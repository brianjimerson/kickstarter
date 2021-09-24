package io.aspenmesh.kickstarter.types;

import java.io.PrintWriter;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@SpringBootTest
public class ServiceTests {

    @Autowired
    TemplateEngine templateEngine;

    @Test
    public void generateService() {

        Kind kind = Kind.SERVICE;

        Metadata metadata = new Metadata();
        metadata.setName("test-service");
        metadata.setNamespace("test");

        Service service = new Service();
        service.setKind(kind);
        service.setMetadata(metadata);

        Service.ServiceSpec serviceSpec = service.new ServiceSpec();
        serviceSpec.setPort(10000);
        service.setSpec(serviceSpec);

        Context context = new Context(Locale.getDefault());
        context.setVariable("service", service);
        System.out.println("Generated service :");
        System.out.println("------------------------------------");
        templateEngine.process("service", context, new PrintWriter(System.out));
        
    }
}
