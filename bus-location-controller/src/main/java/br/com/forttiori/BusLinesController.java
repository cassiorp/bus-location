package br.com.forttiori;

import br.com.forttiori.DTO.BusLineUpDateDTO;
import br.com.forttiori.DTO.BusLinesRequestDTO;
import br.com.forttiori.entity.BusLine;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/buslocation")
@RequiredArgsConstructor
public class BusLinesController {

    private final BusLineService busLineService;

    @GetMapping("/all")
    @ApiOperation("Busca As Linhas de onibus da api datapoa. Caso o banco de dados não contenha as linhas sera salvo!.")
    public List<BusLine> findAll() {
        return this.busLineService.findAll();
    }


    @GetMapping("/integration")
    @ApiOperation("Busca As Linhas de onibus da api datapoa. Caso o banco de dados não contenha as linhas sera salvo!.")
    public List<BusLine> listAndSaveBusLines() throws JsonProcessingException {
        return this.busLineService.listAndSaveBusLines();
    }

    @GetMapping
    public List<BusLine> findBusLinesByName(@RequestParam("name") @Valid String name) {
        return this.busLineService.findBusLinesByName(name);
    }

    @GetMapping("/{id}")
    public BusLine findByID(@PathVariable String id){
        return this.busLineService.findByID(id);
    }

    @PutMapping("/{id}")
    public BusLine update(@RequestBody BusLineUpDateDTO busLineUpDateDTO, @PathVariable String id) {
        return this.busLineService.update(busLineUpDateDTO, id);
    }

    @PostMapping
    public BusLine save(@RequestBody @Valid BusLinesRequestDTO requestDTO) {
        return this.busLineService.save(requestDTO);
    }
}
