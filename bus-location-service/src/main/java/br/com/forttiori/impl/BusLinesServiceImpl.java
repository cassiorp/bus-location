package br.com.forttiori.impl;


import br.com.forttiori.BusLineService;
import br.com.forttiori.BusLinesClient;
import br.com.forttiori.DTO.BusLineUpDateDTO;
import br.com.forttiori.DTO.BusLinesRequestDTO;
import br.com.forttiori.entity.BusLine;
import br.com.forttiori.exceptions.BusLineAlreadyRegistredException;
import br.com.forttiori.exceptions.BusLinesNotFoundException;
import br.com.forttiori.repository.BusLinesRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringEscapeUtils.unescapeJava;


@Service
@RequiredArgsConstructor
public class BusLinesServiceImpl implements BusLineService {

    private final BusLinesClient busLinesClient;
    private final BusLinesRepository busLinesRepository;
    private final ObjectMapper mapper;

    @Override
    public List<BusLine> listAndSaveBusLines() throws JsonProcessingException {
        Optional<List<BusLine>> find = Optional.ofNullable(this.busLinesRepository.findAll());
        if(find.isPresent()){
            return find.get();
        }

        String json = this.busLinesClient.getBusLines();
        BusLine[] busLines = mapper.readValue(json, BusLine[].class);
        Optional<List<BusLine>> busLinesToSave =
                Optional.ofNullable(this.busLinesRepository.saveAll(Arrays.asList(busLines)));

        return busLinesToSave.orElseThrow(() -> new RuntimeException("Erro ao Listar"));
    }


    @Override
    public List<BusLine> findBusLinesByName(String name) {
        Optional<List<BusLine>> busLines = Optional.ofNullable(this.busLinesRepository.findByNomeIgnoreCaseStartingWith(name));
        return busLines.orElseThrow(()-> new BusLinesNotFoundException("Nenhuma linha encontrada com esse nome"));
    }

    @Override
    public BusLine save(BusLinesRequestDTO busLinesRequestDTO) {

        Optional<BusLine> busLine = this.busLinesRepository.findById(busLinesRequestDTO.getId());
        if(busLine.isPresent()){
            var toSave = busLine.get();
            toSave.setId(busLinesRequestDTO.getId());
            toSave.setNome(busLinesRequestDTO.getNome());
            toSave.setCodigo(busLinesRequestDTO.getCodigo());
            return this.busLinesRepository.save(toSave);
        }

        return this.busLinesRepository.save(BusLine.builder()
                .id(busLinesRequestDTO.getId())
                .nome(busLinesRequestDTO.getNome())
                .codigo(busLinesRequestDTO.getCodigo())
                .build());
    }

    @Override
    public BusLine findByID(String id) {
        return this.busLinesRepository.findById(id)
                .orElseThrow(() -> new  BusLinesNotFoundException("Linhas nao encontrada"));
    }

    @Override
    public BusLine update(BusLineUpDateDTO busLineUpDateDTO, String id) {
        BusLine busLine = findByID(id);
        if(!busLine.getNome().equals(busLineUpDateDTO.getNome())) busLine.setNome(busLineUpDateDTO.getNome());
        if(!busLine.getCodigo().equals(busLineUpDateDTO.getCodigo())) busLine.setCodigo(busLineUpDateDTO.getCodigo());
        return this.busLinesRepository.save(busLine);
    }

    @Override
    public List<BusLine> findAll() {
        return this.busLinesRepository.findAll();
    }


}
