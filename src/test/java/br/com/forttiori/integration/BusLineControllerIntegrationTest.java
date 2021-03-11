package br.com.forttiori.integration;

import br.com.forttiori.BusLineService;
import br.com.forttiori.entity.BusLine;
import br.com.forttiori.repository.BusLinesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class BusLineControllerIntegrationTest {

    @Autowired
    BusLineService busLineService;

    @Autowired
    BusLinesRepository busLinesRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;


    @Test
    void shouldSaveBeforeList() throws Exception {

        var result = this.mockMvc.perform(get("/api/buslocation")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn();

        var listedAndSaved = objectMapper.readValue(result.getResponse().getContentAsString(),
                BusLine[].class);

        var expected = this.busLineService.listAndSaveBusLines();

        assertEquals(expected ,Arrays.asList(listedAndSaved));
    }




}
