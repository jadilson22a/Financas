package com.jadilson22a.github.FinancasAPI.dtos;

import java.util.List;

import com.jadilson22a.github.FinancasAPI.entities.Mes;
import com.jadilson22a.github.FinancasAPI.models.Divida;
import com.jadilson22a.github.FinancasAPI.models.Mensalidade;

public record MensalidadeDTO(Integer id, String mes, Integer ano, List<Divida> dividas) {
	
	public Mensalidade toMensalidade() {
		return new Mensalidade(id, Mes.valueOf(mes), ano, dividas);
	}
	
}
