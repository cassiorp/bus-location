package br.com.forttiori.endpoints;

import br.com.forttiori.BusLineService;
import br.com.forttiori.BusLinesController;
import br.com.forttiori.entity.BusLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BusLinesController.class)
public class BusLineControllerEndpointsTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BusLineService busLineService;

    String homepath = "/home/cassio/Desktop";

    String response;

    @BeforeEach
    void setUp() throws IOException {
        response = Files.readString(Paths.get(homepath + "/bus-location/response.txt"));
    }

    @Test
    void shouldGetLinesSavedOrSavedAndGetLines() throws Exception {
        List<BusLine> lines = new ArrayList<>();

        given(busLineService.listAndSaveBusLines()).willReturn(lines);

        this.mockMvc.perform(get("/api/buslocation")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
