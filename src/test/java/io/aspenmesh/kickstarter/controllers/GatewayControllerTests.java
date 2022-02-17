package io.aspenmesh.kickstarter.controllers;

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
public class GatewayControllerTests {

    @Autowired
    MockMvc mvc;
    
    @Test
    public void testValidDeployment() throws Exception {

        GatewayRequest gatewayRequest = new GatewayRequest();
        gatewayRequest.setName("test-gateway");
        gatewayRequest.setNamespace("test-ns");
        gatewayRequest.setCredentialName("test-credential");
        gatewayRequest.setHost("www.test.com");
        gatewayRequest.setHttpsRedirect(Boolean.FALSE);
        gatewayRequest.setPort(80);
        gatewayRequest.setPortName("test-http");
        gatewayRequest.setProtocol("HTTP");
        gatewayRequest.setServerName("test-server");
        gatewayRequest.setTargetPort(80);
        gatewayRequest.setTlsMode("SIMPLE");

        ObjectMapper objectMapper = new ObjectMapper();

        mvc.perform(
            MockMvcRequestBuilders.post("/gateway")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(gatewayRequest)))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string(
                Matchers.containsString("name: test-gateway")));
    }

}
