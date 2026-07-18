package com.jadilson22a.github.FinancasAPI.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "dividas")
public class Divida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    @ManyToOne()
    @JoinColumn(name = "Mensalidade_id")
    private Mensalidade mensalidade;

	public Divida(Integer id, String nome, Double valor, LocalDate dataVencimento, Mensalidade mensalidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.dataVencimento = dataVencimento;
		this.mensalidade = mensalidade;
	}

	public Divida() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Mensalidade getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(Mensalidade mensalidade) {
		this.mensalidade = mensalidade;
	}

}
