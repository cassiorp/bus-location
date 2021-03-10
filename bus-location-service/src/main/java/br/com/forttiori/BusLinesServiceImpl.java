package br.com.forttiori;


import br.com.forttiori.entity.BusLine;
import br.com.forttiori.repository.BusLinesRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.apache.commons.lang3.StringEscapeUtils.unescapeJava;


@Service
@RequiredArgsConstructor
public class BusLinesServiceImpl implements BusLineService {

    private final BusLinesClient busLinesClient;
    private final BusLinesRespository busLinesRespository;

    @Override
    public List<BusLine> listAndSaveBusLines() {
        String response = this.busLinesClient.getBusLines();
        List<String> lines = this.mapStringToListString(response);
        List<BusLine> busLines = new ArrayList<>();
        if (busLinesRespository.count() == 0) {
            lines.stream().forEach(l -> {
                busLines.add(BusLine.builder().id(extractId(l))
                        .codigo(extractCodigo(l))
                        .nome(extractNome(l))
                        .build()
                );
            });
            return this.busLinesRespository.saveAll(busLines);
        }
        return this.busLinesRespository.findAll();
    }

    public String getBusLinesAsString() {
        return this.busLinesClient.getBusLines();
    }

    public String extractNome(String line) {

        String[] split = line.split(",");
        String lineWithName = split[2];
        String nome = lineWithName.substring(7);
        nome = nome.replace("\"", "");
        nome = unescapeJava(nome);
        return Optional.ofNullable(nome)
                .orElseThrow(() -> new ArrayIndexOutOfBoundsException("Erro ao extrair nome"));

    }


    public String extractId(String line) {
        return Optional.ofNullable(line.substring(6, 10))
                .orElseThrow(() -> new StringIndexOutOfBoundsException("Erro ao extrair id"));
    }

    public String extractCodigo(String line) {
        String cut = line.substring(22);
        String[] codigo = cut.split("\"");
        return Optional.ofNullable(codigo[0])
                .orElseThrow(() -> new StringIndexOutOfBoundsException("Erro ao extrair codigo"));

    }

    public List<String> mapStringToListString(String response) {

        response = response.replace("{", "");
        response = response.replace("[", "");
        response = response.replace("]", "");

        String[] split = response.split("},");

        List<String> responseFinal = new ArrayList<>();
        responseFinal.addAll(Arrays.asList(split));
        var ultimo = responseFinal.get(responseFinal.size() - 1);
        responseFinal.remove(ultimo);
        ultimo = ultimo.replace("}", "");
        responseFinal.add(ultimo);

        return Optional.ofNullable(responseFinal)
                .orElseThrow(()-> new RuntimeException("Erro ao converter texto para array de textos"));

    }


}
