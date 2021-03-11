package br.com.forttiori;

import br.com.forttiori.entity.Itinerary;
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

    private final ItineraryServiceImpl itineraryService;

    @GetMapping("/{id}")
    public Itinerary getItinerary(@PathVariable String id) {
        return this.itineraryService.listAndSave(id);
    }
}
