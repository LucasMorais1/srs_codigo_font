package com.src.servico.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Getter
@Setter
public class SalaDTO {

    private Integer id;

    @NotNull
    private String descricao;

    @NotNull
    private Integer idTipoSala;

    @Positive @NotNull
    private Integer capacidadePessoas;

    @NotNull
    private Double precoDiario;

    @NotNull
    private List<SalaEquipamentoDTO> equipamentos;

}
