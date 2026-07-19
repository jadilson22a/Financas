package com.jadilson22a.github.FinancasAPI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jadilson22a.github.FinancasAPI.entities.Mes;
import com.jadilson22a.github.FinancasAPI.models.Divida;
import com.jadilson22a.github.FinancasAPI.models.Mensalidade;
import com.jadilson22a.github.FinancasAPI.service.MensalidadeService;

@SpringBootTest
class FinancasApiApplicationTests {

	@Autowired
	private MensalidadeService service;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testeMensalidade() {
		List<Divida> dividasTeste = new ArrayList<Divida>();
		
		String nome = "Divida teste";
		Double valor = 25.50;
		LocalDate dataVencimento = LocalDate.parse("2026-07-18");
		Mes mes = Mes.julho;
		Integer ano = 2026;
		
		dividasTeste.add(new Divida(nome, valor, dataVencimento));
		service.salvar(new Mensalidade(mes, ano, dividasTeste));
		
		Mensalidade mensalidade = service.buscar(mes, ano);
		System.out.println(mensalidade);
		
		service.excluir(mensalidade.getId());
	}

}
