package br.com.forttiori.impl;

import br.com.forttiori.ItineraryClient;
import br.com.forttiori.ItineraryService;
import br.com.forttiori.entity.Itinerary;
import br.com.forttiori.repository.ItineraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.valueOf;
import static org.apache.commons.lang3.StringEscapeUtils.unescapeJava;

@Service
@RequiredArgsConstructor
public class ItineraryServiceImpl implements ItineraryService {

    private final ItineraryClient itineraryClient;
    private final ItineraryRepository itineraryRepository;

    @Override
    public Itinerary listAndSave(String id) {
        Optional<Itinerary> itinerary = this.itineraryRepository.findById(id);
        if (itinerary.isPresent()) {
            return itinerary.get();
        }

        String line = this.itineraryClient.getItinerary(id);

        Itinerary itineraryToSave = Itinerary.builder()
                .id(extractId(line))
                .nome(extractNome(line))
                .codigo(extractCodigo(line))
                .locations(locations(line))
                .build();

        return this.itineraryRepository.save(itineraryToSave);
    }

    public String extractId(String line) {
        return Optional.ofNullable(line.substring(12, 16))
                .orElseThrow(() -> new StringIndexOutOfBoundsException());
    }

    public String extractNome(String line) {
        String nome = line.substring(26);
        String[] nomeSplit = nome.split("\"");
        String nomeFinal = unescapeJava(nomeSplit[0]);
        return Optional.ofNullable(nomeFinal)
                .orElseThrow(() -> new StringIndexOutOfBoundsException());
    }

    public String extractCodigo(String line) {
        String[] split = line.split(",");
        String codigo = split[2];
        codigo = codigo.substring(10);
        codigo = codigo.replaceAll("\"", "");
        return codigo;
    }

    public String extractLocations(String line) {
        var index = line.indexOf(",\"0");
        var str = line.substring(index);
        str = str.replaceAll("\"", "");
        str = str.substring(1);

        return str;
    }

    public List<String> locations(String line) {
        String locationsExtracted = extractLocations(line);
        String[] ltc = locationsExtracted.split("},");
        List<String> locations = Stream.of(ltc).map(l -> l.concat("}")).collect(Collectors.toList());
        return locations;
    }

}
