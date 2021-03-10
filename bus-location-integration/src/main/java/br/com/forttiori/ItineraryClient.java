package br.com.forttiori;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name = "itinerary", url = "${api.datapoa}")
public interface ItineraryClient {

    @GetMapping("?a=il&p={id}")
    public String getItinerary(@PathVariable("id") String id);

}
