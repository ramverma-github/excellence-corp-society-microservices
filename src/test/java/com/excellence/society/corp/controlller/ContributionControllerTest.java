package com.excellence.society.corp.controlller;

import com.excellence.society.corp.ExcellenceCorpSocietyApplication;
import com.excellence.society.corp.domain.Contribution;
import com.excellence.society.corp.domain.Contributor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = ExcellenceCorpSocietyApplication.class)
@WebAppConfiguration
class ContributionControllerTest {

    private MockMvc mockMvc;
   // @Autowired
    private WebApplicationContext webApplicationContext;

   // @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    //  @Test
    public void test_addContributionPostMethod() throws Exception {
        String uri = "/api/contribution/add";
        Contribution contribution = new Contribution();
        contribution.setAmount(7500.00);
        Contributor contributor = new Contributor();
        contributor.setName("RAM");
        contributor.setDob("1991-04-06");
        contributor.setProfession("Software Engineer");
        contribution.setContributor(contributor);
        String contributionData = mapToJson(contribution);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON).content(contributionData)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals("Hello", content);
    }

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
}
