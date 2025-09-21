package br.edu.iff.sistemasdistribuidos.calculofinanceiro.model;

public class InvestimentoRequest {
    private double valorInicial;
    private double taxaJurosMensal;
    private int meses;

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public double getTaxaJurosMensal() {
        return taxaJurosMensal;
    }

    public void setTaxaJurosMensal(double taxaJurosMensal) {
        this.taxaJurosMensal = taxaJurosMensal;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }
}