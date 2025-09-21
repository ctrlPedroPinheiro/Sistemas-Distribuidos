package br.edu.iff.sistemasdistribuidos.calculofinanceiro.model;

import java.util.List;

public class ResultadoCalculo {
    private double montanteFinal;
    private List<String> jurosMensais;

    public ResultadoCalculo(double montanteFinal, List<String> jurosMensais) {
        this.montanteFinal = montanteFinal;
        this.jurosMensais = jurosMensais;
    }

    public double getMontanteFinal() {
        return montanteFinal;
    }

    public void setMontanteFinal(double montanteFinal) {
        this.montanteFinal = montanteFinal;
    }

    public List<String> getJurosMensais() {
        return jurosMensais;
    }

    public void setJurosMensais(List<String> jurosMensais) {
        this.jurosMensais = jurosMensais;
    }
}