package com.jadilson22a.github.FinancasAPI.dtos;

import java.util.List;

import com.jadilson22a.github.FinancasAPI.entities.Mes;
import com.jadilson22a.github.FinancasAPI.models.Divida;

public record MensalidadeDTO(Integer id, Mes mes, Integer ano, List<Divida> dividas) {

	
}
