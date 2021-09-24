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

import io.aspenmesh.kickstarter.types.Deployment.DeploymentStrategy;

@SpringBootTest
public class DeploymentTests {

    @Autowired
    TemplateEngine templateEngine;

    @Test
    public void generateDeployment() {

        Kind kind = Kind.DEPLOYMENT;

        Metadata metadata = new Metadata();
        metadata.setName("test-deployment");
        metadata.setNamespace("test");

        Container container = new Container();
        container.setImage("docker.io/test");
        container.setName("test-container");
        container.setImagePullPolicy(ImagePullPolicy.ALWAYS);
        container.setPort(60000);
        List<Container> containers = new ArrayList<Container>();
        containers.add(container);

        PodSpec pod = new PodSpec();
        pod.setContainers(containers);
        pod.setServiceAccountName("test-sa");
        
        Deployment deployment = new Deployment();
        deployment.setKind(kind);
        deployment.setMetadata(metadata);

        Deployment.DeploymentSpec deploymentSpec = deployment.new DeploymentSpec();
        deploymentSpec.setDeploymentStrategy(DeploymentStrategy.ROLLING_UPDATE);
        deploymentSpec.setReplicas(1);
        deploymentSpec.setPod(pod);
        deployment.setSpec(deploymentSpec);

        Context context = new Context(Locale.getDefault());
        context.setVariable("deployment", deployment);
        System.out.println("Generated deployment:");
        System.out.println("------------------------------------");
        templateEngine.process("deployment", context, new PrintWriter(System.out));
        
    }
}
