package br.com.forttiori;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient(name = "busline", url = "${api.datapoa}")
public interface BusLinesClient {

    @GetMapping("?a=nc&p=%&t=o")
    public String getBusLines();

}
