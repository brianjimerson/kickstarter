package io.aspenmesh.kickstarter.controllers;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import io.aspenmesh.kickstarter.types.Kind;
import io.aspenmesh.kickstarter.types.Metadata;
import io.aspenmesh.kickstarter.types.Service;

@RestController
public class ServiceController {
    
    @Autowired
    TemplateEngine templateEngine;
    
    @PostMapping(value = "/service", produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody byte[] getService(@RequestBody ServiceRequest serviceRequest) {

        Kind kind = Kind.SERVICE;

        Metadata metadata = new Metadata();
        metadata.setName(serviceRequest.getName());
        metadata.setNamespace(serviceRequest.getNamespace());

        Service service = new Service();
        service.setKind(kind);
        service.setMetadata(metadata);

        Service.ServiceSpec serviceSpec = service.new ServiceSpec();
        serviceSpec.setPort(serviceRequest.getPort());
        service.setSpec(serviceSpec);

        Context context = new Context(Locale.getDefault());
        context.setVariable("service", service);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintWriter writer = new PrintWriter(out);
        templateEngine.process("service", context, writer);
        return out.toByteArray();
    }
}
