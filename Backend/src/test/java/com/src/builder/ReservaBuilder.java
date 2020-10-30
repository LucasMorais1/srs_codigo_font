package com.src.builder;

import com.src.dominio.*;
import com.src.repositorio.ReservaRepositorio;
import com.src.servico.ReservaServico;
import com.src.servico.dto.ReservaDTO;
import com.src.servico.mapper.ReservaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//paulo.teotonio
@Component
public class ReservaBuilder extends ConstrutorDeEntidade<Reserva>{

    @Autowired
    private ReservaServico reservaServico;

    @Autowired
    private ReservaMapper reservaMapper;

    @Autowired
    private ReservaRepositorio reservaRepositorio;

    @Autowired
    private ClienteBuilder clienteBuilder;

    @Autowired
    private EquipamentoBuilder equipamentoBuilder;

    @Autowired
    private SalaBuilder salaBuilder;

    @Override
    public Reserva construirEntidade() throws ParseException {

        Reserva reserva = new Reserva();
        reserva.setDataFim(LocalDate.of(2020, 10, 9));
        reserva.setDataIni(LocalDate.of(2020, 11, 9));
        reserva.setTotal(455.00);

        Cliente cliente = clienteBuilder.construir();
        reserva.setCliente(cliente);

        Sala sala = salaBuilder.construir();
        reserva.setSala(sala);

        Equipamento equipamento = equipamentoBuilder.construir();

        ReservaEquipamento reservaEquipamento = new ReservaEquipamento();
        reservaEquipamento.setEquipamento(equipamento);
        reservaEquipamento.setReserva(reserva);
        reservaEquipamento.setQuantidade(50);

        reserva.setEquipamentos(Collections.singletonList(reservaEquipamento));

        return reserva;
    }

    @Override
    public Reserva persistir(Reserva entidade){
        ReservaDTO dto = reservaMapper.toDto(entidade);
        return  reservaMapper.toEntity(reservaServico.inserir(dto));
    }

    @Override
    public Collection<Reserva> obterTodos()
    {
        return reservaRepositorio.findAll();
    }

    @Override
    public Reserva obterPorId(Integer id)
    {
        return reservaMapper.toEntity(reservaServico.buscar(id));
    }

    public void deletarPorId(Integer id){
        reservaRepositorio.deleteById(id);
    }

    public ReservaDTO converterToDto(Reserva reserva){
        return reservaMapper.toDto(reserva);
    }

}