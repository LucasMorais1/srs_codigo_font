package com.basis.src.dominio;


import com.basis.src.servico.dto.SalaEquipamentoDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "sala")
public class Sala implements Serializable {

    @Id
    @SequenceGenerator(name = "sala_sequence", allocationSize = 1, sequenceName = "sala_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sala_sequence")
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_sala")
    private TipoSala tipoSala;

    @Column(name = "capacidade_pessoas")
    private Integer capacidadePessoas;

    @Column(name = "preco_diario")
    private Double precoDiario;

    @Column(name = "disponivel")
    private Integer disponivel;

    @OneToMany(mappedBy = "sala",cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<SalaEquipamento> equipamentos;

}
