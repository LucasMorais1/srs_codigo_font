package com.basis.src.mapper;

import com.basis.src.dominio.Reserva;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring", uses = {})
public interface ReservaMapper extends EntityMapper<ReservaDtoTO, Reserva>{
}