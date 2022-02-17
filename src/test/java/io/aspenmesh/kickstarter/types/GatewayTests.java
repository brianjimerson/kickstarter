package io.aspenmesh.kickstarter.types;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import io.aspenmesh.kickstarter.types.Gateway.GatewaySpec;
import io.aspenmesh.kickstarter.types.Gateway.Port;
import io.aspenmesh.kickstarter.types.Gateway.Server;
import io.aspenmesh.kickstarter.types.Gateway.ServerTLSSettings;

@SpringBootTest
public class GatewayTests {

    @Autowired
    TemplateEngine templateEngine;

    @Test
    public void generateGateway() {

        Kind kind = Kind.GATEWAY;

        Metadata metadata = new Metadata();
        metadata.setName("test-gateway");
        metadata.setNamespace("test");

        Gateway gateway = new Gateway();
        gateway.setKind(kind);
        gateway.setMetadata(metadata);

        Port port = gateway.new Port();
        port.setName("test-http");
        port.setPort(80);
        port.setProtocol(Protocol.findByValue("HTTP"));
        port.setTargetPort(8080);

        ServerTLSSettings tlsSettings = gateway.new ServerTLSSettings();
        tlsSettings.setHttpsRedirect(false);
        tlsSettings.setCredentialName("test-credential");
        tlsSettings.setMode(TLSMode.findByValue("simple"));

        Server server = gateway.new Server();
        List<String> hosts = new ArrayList<String>();
        hosts.add("www.test.com");
        server.setHosts(hosts);
        server.setName("test-server");
        server.setPort(port);
        server.setTls(tlsSettings);

        GatewaySpec gatewaySpec = gateway.new GatewaySpec();
        gatewaySpec.setServer(server);

        gateway.setSpec(gatewaySpec);

        Context context = new Context(Locale.getDefault());
        context.setVariable("gateway", gateway);
        System.out.println("Generated gateway:");
        System.out.println("------------------------------------");
        templateEngine.process("gateway", context, new PrintWriter(System.out));
        
    }
}
