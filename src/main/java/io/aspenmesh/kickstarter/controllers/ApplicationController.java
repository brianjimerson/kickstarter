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

import io.aspenmesh.kickstarter.types.Deployment;
import io.aspenmesh.kickstarter.types.Gateway;
import io.aspenmesh.kickstarter.types.Service;
import io.aspenmesh.kickstarter.util.RequestParser;

@RestController
public class ApplicationController {
    
    @Autowired
    TemplateEngine templateEngine;

    @PostMapping(value = "/application", produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody byte[] getApplication(@RequestBody ApplicationRequest applicationRequest) {

        Context context = new Context(Locale.getDefault());

        DeploymentRequest deploymentRequest = new DeploymentRequest();
        deploymentRequest.setContainerImage(applicationRequest.getContainerImage());
        deploymentRequest.setContainerImagePullPolicy(applicationRequest.getContainerImagePullPolicy());
        deploymentRequest.setContainerPort(applicationRequest.getContainerPort());
        deploymentRequest.setDeploymentStrategy(applicationRequest.getDeploymentStrategy());
        deploymentRequest.setName(applicationRequest.getName());
        deploymentRequest.setNamespace(applicationRequest.getNamespace());
        deploymentRequest.setReplicas(applicationRequest.getReplicas());
        deploymentRequest.setServiceAccountName(applicationRequest.getName());
        Deployment deployment = RequestParser.parseDeploymentRequest(deploymentRequest);
        context.setVariable("deployment", deployment);

        ServiceRequest serviceRequest = new ServiceRequest();
        serviceRequest.setName(applicationRequest.getName());
        serviceRequest.setNamespace(applicationRequest.getNamespace());
        serviceRequest.setServicePort(applicationRequest.getServicePort());
        Service service = RequestParser.parseServiceRequest(serviceRequest);
        context.setVariable("service", service);

        if (Boolean.TRUE.equals(applicationRequest.getIncludeGateway())) {
            GatewayRequest gatewayRequest = new GatewayRequest();
            gatewayRequest.setCredentialName(applicationRequest.getCredentialName());
            gatewayRequest.setHost(applicationRequest.getHost());
            gatewayRequest.setHttpsRedirect(applicationRequest.getHttpsRedirect());
            gatewayRequest.setName(applicationRequest.getName() + "-gw");
            gatewayRequest.setNamespace(applicationRequest.getNamespace());
            gatewayRequest.setPort(applicationRequest.getGatewayPort());
            gatewayRequest.setPortName(applicationRequest.getGatewayPortName());
            gatewayRequest.setProtocol(applicationRequest.getProtocol());
            gatewayRequest.setTlsMode(applicationRequest.getTlsMode());
            Gateway gateway = RequestParser.parseGatewayRequest(gatewayRequest);
            context.setVariable("gateway", gateway);
        }

        if (Boolean.TRUE.equals(applicationRequest.getIncludeVirtualService())) {
            //todo add virtual service
        }
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintWriter writer = new PrintWriter(out);
        templateEngine.process("application", context, writer);
        return out.toByteArray();
    }
}
