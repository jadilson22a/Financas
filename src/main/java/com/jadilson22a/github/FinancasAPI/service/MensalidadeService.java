package com.jadilson22a.github.FinancasAPI.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jadilson22a.github.FinancasAPI.Repositories.MensalidadeRepository;
import com.jadilson22a.github.FinancasAPI.entities.CrudInterface;
import com.jadilson22a.github.FinancasAPI.models.Mensalidade;

@Service
public class MensalidadeService implements CrudInterface<Mensalidade, Integer>{

	private MensalidadeRepository repository;

	public MensalidadeService(MensalidadeRepository repository) {
		this.repository = repository;
	}

	@Override
	public void salvar(Mensalidade mensalidade) {
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
	public Mensalidade buscarPorId(Integer id) {
		Mensalidade mensalidade = repository.findById(id).orElse(null);
		return mensalidade;
	}
	
	
	
}
