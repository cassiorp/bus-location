package br.com.forttiori;

import br.com.forttiori.entity.BusLine;
import br.com.forttiori.impl.BusLinesServiceImpl;
import br.com.forttiori.repository.BusLinesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BusLineServiceImplTest {

    @Mock
    BusLinesClient busLinesClient;

    @Mock
    BusLinesRepository busLinesRepository;

    @InjectMocks
    BusLinesServiceImpl busLinesService;

    // para rodar testes tem que trocar para o diretorio que o projeto esta.
    // Tentar deixar generico mais tarde
    String homepath = "/home/cassio/Desktop";

    String response;

    @BeforeEach
    void setUp() throws IOException {
        response = Files.readString(Paths.get(homepath + "/bus-location/response.txt"));
    }

    @Test
    void shouldSaveResponseWithEmptyDataBase() {
        var lines = this.busLinesService.mapStringToListString(response);

        List<BusLine> busLines = createBusLins();

        when(busLinesClient.getBusLines()).thenReturn(response);

        when(busLinesRepository.count()).thenReturn(0L);

        when(busLinesRepository.saveAll(busLines)).thenReturn(createBusLins());

        var saved = this.busLinesService.listAndSaveBusLines();
        var expected = createBusLins();

        assertEquals(expected, saved);
    }


    @Test
    void shouldGetResponseAsString() {
        when(busLinesClient.getBusLines()).thenReturn(response);
        var text  = this.busLinesService.getBusLinesAsString();
        assertEquals(response, text);
    }

    @Test
    void shouldExtractNome() {
        List<String> busLines = this.busLinesService.mapStringToListString(response);
        String nome = this.busLinesService.extractNome(busLines.get(0));
        assertEquals("1 DE MAIO", nome);
    }

    @Test
    void shouldExtractId() {
        List<String> busLines = this.busLinesService.mapStringToListString(response);
        String id = this.busLinesService.extractId(busLines.get(busLines.size()-1));
        assertEquals("5792", id);
    }

    @Test
    void shouldExtractCodigo() {
        List<String> busLines = this.busLinesService.mapStringToListString(response);
        String codigo = this.busLinesService.extractCodigo(busLines.get(busLines.size()-2));
        assertEquals("2661-1", codigo);
    }

    @Test
    void shouldCatchExceptionToExtractId(){
        assertThrows(StringIndexOutOfBoundsException.class, () -> this.busLinesService.extractId("1"));
    }

    @Test
    void shouldCatchExceptionToExtractCodigo(){
        assertThrows(StringIndexOutOfBoundsException.class, () ->   this.busLinesService.extractCodigo("5"));
    }

    @Test
    void shouldCatchExceptionToExtractNome(){
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->   this.busLinesService.extractNome("5"));
    }

    private List<BusLine> createBusLins() {
        List<BusLine> busLines = new ArrayList<>();
        var lines = this.busLinesService.mapStringToListString(response);
        lines.stream().forEach(l -> {
            busLines.add(BusLine.builder().id(busLinesService.extractId(l))
                    .codigo(busLinesService.extractCodigo(l))
                    .nome(busLinesService.extractNome(l))
                    .build()
            );
        });
        return  busLines;
    }

}
