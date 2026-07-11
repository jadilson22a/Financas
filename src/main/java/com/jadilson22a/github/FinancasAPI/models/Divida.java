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

    @Column(name = "valor", precision = 12, scale = 2)
    private Double valor;

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;


    private Mensalidade mensalidade;

}
