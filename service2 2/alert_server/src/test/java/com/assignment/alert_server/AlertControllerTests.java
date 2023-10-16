package com.assignment.alert_server;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.assignment.alert_server.controller.AlertController;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AlertServerApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
class AlertControllerTests {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext wac;

    @Test
    void getTest() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        String url = "/alerts?service_id=11&start_ts=1111111110&end_ts=1111111112";
        mockMvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }
    @Test
    void postTest() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        mockMvc.perform(MockMvcRequestBuilders.post("/alerts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "alert_id": "22",
                                  "service_id": "22",
                                  "service_name": "22",
                                  "model": "22",
                                  "alert_type": "22",
                                  "alert_ts": "1111111222",
                                  "severity": "1111111",
                                  "team_slack": "111111"
                                }""")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }



}
