package com.jadilson22a.github.FinancasAPI.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jadilson22a.github.FinancasAPI.models.Divida;
import com.jadilson22a.github.FinancasAPI.models.Mensalidade;

public interface DividaRepository extends JpaRepository<Divida, Integer> {
	
	List<Divida> findByMensalidade(Mensalidade mensalidade);
}
