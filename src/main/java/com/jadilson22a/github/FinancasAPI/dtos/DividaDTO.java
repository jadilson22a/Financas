package com.jadilson22a.github.FinancasAPI.dtos;

import java.time.LocalDate;

import com.jadilson22a.github.FinancasAPI.models.Divida;

public record DividaDTO(Integer id, String nome, Double valor, LocalDate dataVencimento) {

	public Divida toDivida() {
		return new Divida(nome, valor, dataVencimento);
	}
}
