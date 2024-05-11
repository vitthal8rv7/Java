package com.learn.java.junit5.controller;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTestApproach1 {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void healthCheckUpTest() throws Exception {
    	ResultActions resultActions =   this.mockMvc.perform(get("/mongo/demo/"))
                    .andDo(print())
                    .andExpect(status().isOk());
    	
    				Boolean resultMatcher = resultActions.andReturn().getResponse().getContentAsString()
    										.equals("Running");
    				Assertions.assertTrue(resultMatcher);
    	
//                    .andExpect(jsonPath("$.person.name").value("Jason"));
//        			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
                   // .andExpect(content().string(containsString("Hello World!")));
    }
}
