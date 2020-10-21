package com.src.servico.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class SalaDTO {

    private Integer id;
<<<<<<< HEAD


    @NotNull
    private String descricao;

    @NotNull
    private Integer idTipoSala;

    @Positive @NotNull
    private Integer capacidadePessoas;

    @NotNull
    private Double precoDiario;

    @NotNull
    @Min(0) @Max(1)
    private Integer disponivel;

=======
    @NotNull
    private String descricao;
    @Min(1) @Max(5)
    private Integer idTipoSala;
    @Positive @NotNull
    private Integer capacidadePessoas;
    @NotNull
    private Double precoDiario;
    @Min(0) @Max(1)
    private Integer disponivel;
>>>>>>> 7933ea607a2a5275ae05af77a4004d275265d1be
    @NotNull
    private List<SalaEquipamentoDTO> equipamentos;

}
