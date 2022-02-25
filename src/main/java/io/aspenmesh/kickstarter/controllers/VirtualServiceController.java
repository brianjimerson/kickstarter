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

import io.aspenmesh.kickstarter.types.VirtualService;
import io.aspenmesh.kickstarter.util.RequestParser;

@RestController
public class VirtualServiceController {
    
    @Autowired
    TemplateEngine templateEngine;
    
    @PostMapping(value = "/virtualService", produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody byte[] getVirtualService(@RequestBody VirtualServiceRequest virtualServiceRequest) {

        VirtualService virtualService = RequestParser.parseVirtualServiceRequest(virtualServiceRequest);

        Context context = new Context(Locale.getDefault());
        context.setVariable("virtualService", virtualService);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintWriter writer = new PrintWriter(out);
        templateEngine.process("virtualService", context, writer);
        return out.toByteArray();
    }
}
