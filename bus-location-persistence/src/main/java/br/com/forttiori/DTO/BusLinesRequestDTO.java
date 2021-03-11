package br.com.forttiori.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BusLinesRequestDTO {

    @NotNull
    @NotEmpty
    private String id;

    @NotNull
    @NotEmpty
    private String codigo;

    @NotNull
    @NotEmpty
    private String nome;
}
