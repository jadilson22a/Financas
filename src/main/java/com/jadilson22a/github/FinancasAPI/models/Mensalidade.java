package com.jadilson22a.github.FinancasAPI.models;

import com.jadilson22a.github.FinancasAPI.entities.Mes;

import java.util.List;

public class Mensalidade {

    private Mes mes;
    private Integer ano;
    private List<Divida> dividas;

    public Mensalidade(Mes mes, Integer ano, List<Divida> dividas) {
        this.mes = mes;
        this.ano = ano;
        this.dividas = dividas;
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
}
