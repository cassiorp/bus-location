package br.com.forttiori.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BusLineUpDateDTO {

    @NotNull
    @NotEmpty
    private String codigo;

    @NotNull
    @NotEmpty
    private String nome;

}
