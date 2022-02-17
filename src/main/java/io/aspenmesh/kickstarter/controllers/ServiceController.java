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

import io.aspenmesh.kickstarter.types.Service;
import io.aspenmesh.kickstarter.util.RequestParser;

@RestController
public class ServiceController {
    
    @Autowired
    TemplateEngine templateEngine;
    
    @PostMapping(value = "/service", produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody byte[] getService(@RequestBody ServiceRequest serviceRequest) {

        Service service = RequestParser.parseServiceRequest(serviceRequest);
        
        Context context = new Context(Locale.getDefault());
        context.setVariable("service", service);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintWriter writer = new PrintWriter(out);
        templateEngine.process("service", context, writer);
        return out.toByteArray();
    }
}
