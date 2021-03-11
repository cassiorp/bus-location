package br.com.forttiori;

import br.com.forttiori.entity.Itinerary;
import org.springframework.stereotype.Service;

@Service
public interface ItineraryService {
    Itinerary listAndSave(String id);
}
