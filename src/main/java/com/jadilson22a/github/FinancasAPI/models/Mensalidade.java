package com.jadilson22a.github.FinancasAPI.models;

import com.jadilson22a.github.FinancasAPI.dtos.MensalidadeDTO;
import com.jadilson22a.github.FinancasAPI.entities.Mes;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "mensalidade")
public class Mensalidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "mes")
	@Enumerated(EnumType.STRING)
    private Mes mes;
	
	@Column(name = "ano")
    private Integer ano;
	
	@OneToMany(mappedBy = "mensalidade", cascade = CascadeType.ALL)
    private List<Divida> dividas;
	
    public Mensalidade() {
	}

	public Mensalidade(Mes mes, Integer ano, List<Divida> dividas) {
        this.mes = mes;
        this.ano = ano;
        this.dividas = dividas;
        
        if(dividas != null) {
        	dividas.forEach(divida -> divida.setMensalidade(this));
        }
    }
	
	public Mensalidade(Integer id, Mes mes, Integer ano, List<Divida> dividas) {
		this.id = id;
		this.mes = mes;
		this.ano = ano;
		this.dividas = dividas;
		
		if(dividas != null) {
        	dividas.forEach(divida -> divida.setMensalidade(this));
        }
	}

	public MensalidadeDTO toDTO() {
		return new MensalidadeDTO(id, mes.toString(), ano, dividas);
	}

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Mes getMes() {
        return mes;
    }

    public void setMes(Mes mes) {
        this.mes = mes;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public List<Divida> getDividas() {
        return dividas;
    }

    public void setDividas(List<Divida> dividas) {
        this.dividas = dividas;
    }

	@Override
	public String toString() {
		return "Mensalidade [id=" + id + ", mes=" + mes + ", ano=" + ano + ", dividas=" + dividas + "]";
	}
    
    
}
