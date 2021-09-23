package io.aspenmesh.kickstarter.controllers;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import io.aspenmesh.kickstarter.types.Container;
import io.aspenmesh.kickstarter.types.Deployment;
import io.aspenmesh.kickstarter.types.ImagePullPolicy;
import io.aspenmesh.kickstarter.types.Kind;
import io.aspenmesh.kickstarter.types.Metadata;
import io.aspenmesh.kickstarter.types.PodSpec;
import io.aspenmesh.kickstarter.types.Deployment.DeploymentStrategy;

@RestController
public class DeploymentController {
    
    @Autowired
    TemplateEngine templateEngine;
    
    @PostMapping(value = "/deployment", produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody byte[] getDeployment(@RequestBody DeploymentRequest deploymentRequest) {

        Kind kind = Kind.DEPLOYMENT;

        Metadata metadata = new Metadata();
        metadata.setName(deploymentRequest.getName());
        metadata.setNamespace(deploymentRequest.getNamespace());

        Container container = new Container();
        container.setName(deploymentRequest.getContainerName());
        container.setImage(deploymentRequest.getContainerImage());
        container.setImagePullPolicy(
            ImagePullPolicy.findByValue(deploymentRequest.getContainerImagePullPolicy()));
        container.setPort(deploymentRequest.getContainerPort());
        List<Container> containers = new ArrayList<Container>();
        containers.add(container);

        PodSpec pod = new PodSpec();
        pod.setContainers(containers);
        pod.setServiceAccountName(deploymentRequest.getServiceAccountName());
        
        Deployment deployment = new Deployment();
        deployment.setKind(kind);
        deployment.setMetadata(metadata);

        Deployment.DeploymentSpec deploymentSpec = deployment.new DeploymentSpec();
        deploymentSpec.setDeploymentStrategy(
            DeploymentStrategy.findByValue(deploymentRequest.getDeploymentStrategy()));
        deploymentSpec.setReplicas(deploymentRequest.getReplicas());
        deploymentSpec.setPod(pod);
        deployment.setSpec(deploymentSpec);

        Context context = new Context(Locale.getDefault());
        context.setVariable("deployment", deployment);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintWriter writer = new PrintWriter(out);
        templateEngine.process("deployment", context, writer);
        return out.toByteArray();
    }
}
