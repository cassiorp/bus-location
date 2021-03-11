package br.com.forttiori;

import br.com.forttiori.DTO.BusLineUpDateDTO;
import br.com.forttiori.DTO.BusLinesRequestDTO;
import br.com.forttiori.entity.BusLine;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BusLineService {

    List<BusLine> listAndSaveBusLines() throws JsonProcessingException;

    List<BusLine> findBusLinesByName(String name);

    BusLine save(BusLinesRequestDTO busLinesRequestDTO);

    BusLine findByID(String id);

    BusLine update(BusLineUpDateDTO busLineUpDateDTO, String id);

    List<BusLine> findAll();
}
