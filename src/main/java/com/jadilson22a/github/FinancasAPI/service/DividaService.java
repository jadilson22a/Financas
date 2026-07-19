package com.jadilson22a.github.FinancasAPI.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jadilson22a.github.FinancasAPI.Repositories.DividaRepository;
import com.jadilson22a.github.FinancasAPI.Repositories.MensalidadeRepository;
import com.jadilson22a.github.FinancasAPI.models.Divida;
import com.jadilson22a.github.FinancasAPI.models.Mensalidade;

@Service
public class DividaService {

	private DividaRepository repository;
	private MensalidadeRepository mensalidadeRepository;

	public DividaService(DividaRepository repository, MensalidadeRepository mensalidadeRepository) {
		this.repository = repository;
		this.mensalidadeRepository = mensalidadeRepository;
	}
	
	public void atualizar(Integer id, Divida divida) {
		divida.setId(id);
		Divida dividaEncontrada = repository.findById(id).orElse(null);
		divida.setMensalidade(dividaEncontrada.getMensalidade());
		repository.save(divida);
	}

	public List<Divida> buscar(Integer mensalidadeId) {
		Mensalidade mensalidade = mensalidadeRepository.findById(mensalidadeId).orElse(null);
		List<Divida> dividas = repository.findByMensalidade(mensalidade);
		return dividas;
	}
	
}
