package br.com.forttiori;

import br.com.forttiori.entity.Itinerary;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public interface ItineraryService {
    Itinerary listAndSave(String id) throws JsonProcessingException;
}
