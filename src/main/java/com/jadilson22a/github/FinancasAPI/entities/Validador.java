package com.jadilson22a.github.FinancasAPI.entities;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jadilson22a.github.FinancasAPI.Repositories.MensalidadeRepository;
import com.jadilson22a.github.FinancasAPI.models.Mensalidade;

@Component
public class Validador {

	@Autowired
	private MensalidadeRepository repository;
	
	public void validar(Mensalidade mensalidade) {
		
		Optional<Mensalidade> mensalidadeEncontrada = repository.findByMesAndAno(
				mensalidade.getMes(), 
				mensalidade.getAno());
		
		if(mensalidadeEncontrada.isPresent()) {
			throw new RuntimeException("Mensalidade existente!");
		}
	}

}
