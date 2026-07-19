package com.jadilson22a.github.FinancasAPI.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jadilson22a.github.FinancasAPI.Repositories.MensalidadeRepository;
import com.jadilson22a.github.FinancasAPI.entities.CrudInterface;
import com.jadilson22a.github.FinancasAPI.entities.Mes;
import com.jadilson22a.github.FinancasAPI.entities.Validador;
import com.jadilson22a.github.FinancasAPI.models.Mensalidade;

@Service
public class MensalidadeService implements CrudInterface<Mensalidade, Integer>{

	private MensalidadeRepository repository;
	private Validador validador;

	public MensalidadeService(MensalidadeRepository repository, Validador validador) {
		this.repository = repository;
		this.validador = validador;
	}

	@Override
	public void salvar(Mensalidade mensalidade) {
		validador.validar(mensalidade);
		repository.save(mensalidade);
	}

	@Override
	public void salvar(Integer id, Mensalidade mensalidade) {
		mensalidade.setId(id);
		repository.save(mensalidade);
	}

	@Override
	public void excluir(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<Mensalidade> buscarTudo() {
		List<Mensalidade> mensalidades = repository.findAll();
		return mensalidades;
	}

	@Override
	public Mensalidade buscar(Integer id) {
		Mensalidade mensalidade = repository.findById(id).orElse(null);
		return mensalidade;
	}
	
	public Mensalidade buscar(Mes mes, Integer ano) {
		Mensalidade mensalidade = repository.findByMesAndAno(mes, ano).orElse(null);
		return mensalidade;
	}
	
}
