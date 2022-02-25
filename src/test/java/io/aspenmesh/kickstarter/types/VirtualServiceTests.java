package io.aspenmesh.kickstarter.types;

import java.io.PrintWriter;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@SpringBootTest
public class VirtualServiceTests {

    @Autowired
    TemplateEngine templateEngine;

    @Test
    public void generateVirtualService() {

        Kind kind = Kind.VIRTUAL_SERVICE;

        Metadata metadata = new Metadata();
        metadata.setName("test-virtual-service");
        metadata.setNamespace("test");

        VirtualService virtualService = new VirtualService();
        virtualService.setKind(kind);
        virtualService.setMetadata(metadata);

        VirtualService.Destination destination = virtualService.new Destination();
        destination.setHost("test-k8s-service");
        destination.setPortNumber(10000);

        VirtualService.VirtualServiceSpec virtualServiceSpec = virtualService.new VirtualServiceSpec();
        virtualServiceSpec.setDestination(destination);
        virtualServiceSpec.setGatewayName("test-gateway");
        virtualServiceSpec.setHost("test-host");

        virtualService.setSpec(virtualServiceSpec);

        Context context = new Context(Locale.getDefault());
        context.setVariable("virtualService", virtualService);
        System.out.println("Generated virtual service :");
        System.out.println("------------------------------------");
        templateEngine.process("virtualService", context, new PrintWriter(System.out));
        
    }
}
