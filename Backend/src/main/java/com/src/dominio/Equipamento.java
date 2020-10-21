package com.src.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Getter
@Setter
@Table(name ="equipamento")
public class Equipamento implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipamento_sequence")
    @SequenceGenerator(name="equipamento_sequence", allocationSize = 1, sequenceName = "equipamento_sequence")
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_tipo_equipamento")
    private TipoEquipamento tipoEquipamento;

    @Column(name ="nome")
    private String nome;

    @Column(name ="preco_diario")
    private Double preco;

<<<<<<< HEAD:Backend/src/main/java/com/src/dominio/Equipamento.java

=======
    @Column(name ="obrigatorio")
    private Integer obrigatorio;
>>>>>>> 7933ea607a2a5275ae05af77a4004d275265d1be:Backend/src/main/java/com/src/dominio/Equipamento.java


}
