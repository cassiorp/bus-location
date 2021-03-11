package br.com.forttiori;

import br.com.forttiori.entity.Itinerary;
import br.com.forttiori.impl.ItineraryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/itinerary")
@RequiredArgsConstructor
public class ItineraryController {

    private final ItineraryService itineraryService;

    @GetMapping("/{id}")
    public Itinerary getItinerary(@PathVariable String id) {
        return this.itineraryService.listAndSave(id);
    }
}
