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
public class VirtualServiceControllerTests {

    @Autowired
    MockMvc mvc;
    
    @Test
    public void testValidVirtualService() throws Exception {
        VirtualServiceRequest virtualServiceRequest = new VirtualServiceRequest();
        virtualServiceRequest.setName("test-virtual-service");
        virtualServiceRequest.setNamespace("test-ns");
        virtualServiceRequest.setHost("test-host");
        virtualServiceRequest.setGatewayName("test-gateway");
        virtualServiceRequest.setDestinationHost("test-internal-service");
        virtualServiceRequest.setDestinationPortNumber(10000);

        ObjectMapper objectMapper = new ObjectMapper();

        mvc.perform(
            MockMvcRequestBuilders.post("/virtualService")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(virtualServiceRequest)))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string(
                Matchers.containsString("name: test-virtual-service")));
    }

}
