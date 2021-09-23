package io.aspenmesh.kickstarter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class DeploymentControllerTest {

    @Autowired
    MockMvc mvc;
    
    @Test
    public void testValidDeployment() throws Exception {
        DeploymentRequest deploymentRequest = new DeploymentRequest();
        deploymentRequest.setName("test-deployment");
        deploymentRequest.setNamespace("test-ns");
        deploymentRequest.setContainerName("test-container");
        deploymentRequest.setContainerImage("test-image");
        deploymentRequest.setContainerImagePullPolicy("Always");
        deploymentRequest.setContainerPort(10000);
        deploymentRequest.setServiceAccountName("test-sa");
        deploymentRequest.setReplicas(2);
        deploymentRequest.setDeploymentStrategy("RollingUpdate");

        ObjectMapper objectMapper = new ObjectMapper();

        mvc.perform(
            MockMvcRequestBuilders.post("/deployment")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(deploymentRequest)))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string(
                Matchers.containsString("name: test-deployment")));
    }

}
