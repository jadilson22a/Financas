package com.jadilson22a.github.FinancasAPI.entities;

import java.util.List;

public interface CrudInterface<T, ID> {
	
	void salvar(T entidade);
	void salvar(ID id,T entidade);
	void excluir(ID entidade);
	List<T> buscarTudo();
	T buscar(ID id);

}
