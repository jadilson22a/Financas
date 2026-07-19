package com.jadilson22a.github.FinancasAPI.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jadilson22a.github.FinancasAPI.entities.Mes;
import com.jadilson22a.github.FinancasAPI.models.Mensalidade;

public interface MensalidadeRepository extends JpaRepository<Mensalidade, Integer>{

	Optional<Mensalidade> findByMesAndAno(Mes mes, Integer Ano);
}
