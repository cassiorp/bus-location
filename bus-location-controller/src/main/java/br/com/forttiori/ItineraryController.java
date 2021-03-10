package br.com.forttiori;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("api/itinerary")
@RequiredArgsConstructor
public class ItineraryController {

    private final ItineraryClient itineraryClient;

    @GetMapping("/{id}")
    public String getItinerary(@PathVariable String id) {
        String eti = this.itineraryClient.getItinerary(id);
        //String[] quebra = eti.split("\\{");
        return eti;
    }
}
