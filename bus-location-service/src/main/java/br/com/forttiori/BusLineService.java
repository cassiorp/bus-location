package br.com.forttiori;

import br.com.forttiori.entity.BusLine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BusLineService {
    List<BusLine> listAndSaveBusLines();
}
