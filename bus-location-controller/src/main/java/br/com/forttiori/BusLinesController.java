package br.com.forttiori;

import br.com.forttiori.entity.BusLine;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/buslocation")
@RequiredArgsConstructor
public class BusLinesController {

    private final BusLineService busLineService;

    @GetMapping
    @ApiOperation("Busca As Linhas de onibus da api datapoa. Caso o banco de dados não contenha as linhas sera salvo!.")
    public List<BusLine> listAndSaveBusLines() {
        return this.busLineService.listAndSaveBusLines();
    }

}
