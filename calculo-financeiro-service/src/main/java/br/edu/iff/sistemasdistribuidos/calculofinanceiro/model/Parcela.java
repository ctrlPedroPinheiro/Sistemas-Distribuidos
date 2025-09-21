package br.edu.iff.sistemasdistribuidos.calculofinanceiro.model;

public class Parcela {
    private int numero;
    private double valor;
    private double juros;
    private double amortizacao;
    private double saldoDevedor;

    public Parcela(int numero, double valor, double juros, double amortizacao, double saldoDevedor) {
        this.numero = numero;
        this.valor = valor;
        this.juros = juros;
        this.amortizacao = amortizacao;
        this.saldoDevedor = saldoDevedor;
    } 
    
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public double getAmortizacao() {
        return amortizacao;
    }

    public void setAmortizacao(double amortizacao) {
        this.amortizacao = amortizacao;
    }

    public double getSaldoDevedor() {
        return saldoDevedor;
    }

    public void setSaldoDevedor(double saldoDevedor) {
        this.saldoDevedor = saldoDevedor;
    }
}
