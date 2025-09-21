package br.edu.iff.sistemasdistribuidos.calculofinanceiro.service;

import br.edu.iff.sistemasdistribuidos.calculofinanceiro.model.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculoService {

    @Cacheable(value = "jurosCompostos", key = "{#request, #clientIp}")
    public ResultadoCalculo calcularJurosCompostos(InvestimentoRequest request, String clientIp) {
        System.out.println(String.format("REQUISIÇÃO DE [%s]: EXECUTANDO CÁLCULO DE JUROS COMPOSTOS PARA: %s", clientIp, request));
        
        double montante = request.getValorInicial();
        List<String> jurosPorMes = new ArrayList<>();

        for (int i = 1; i <= request.getMeses(); i++) {
            montante *= (1 + request.getTaxaJurosMensal() / 100);
            jurosPorMes.add(String.format("Mês %d: Montante = %.2f", i, montante));
        }

        return new ResultadoCalculo(montante, jurosPorMes);
    }

    public List<Parcela> calcularTabelaPrice(AmortizacaoRequest request, String clientIp) {
        System.out.println(String.format("REQUISIÇÃO DE [%s]: EXECUTANDO CÁLCULO DA TABELA PRICE PARA: %s", clientIp, request));
        
        List<Parcela> parcelas = new ArrayList<>();
        double taxa = request.getTaxaJurosMensal() / 100.0;
        double saldoDevedor = request.getValorFinanciado();
        
        double valorParcela = saldoDevedor * (taxa * Math.pow(1 + taxa, request.getNumeroParcelas())) / (Math.pow(1 + taxa, request.getNumeroParcelas()) - 1);

        for (int i = 1; i <= request.getNumeroParcelas(); i++) {
            double juros = saldoDevedor * taxa;
            double amortizacao = valorParcela - juros;
            saldoDevedor -= amortizacao;
            
            if (i == request.getNumeroParcelas()) {
                saldoDevedor = 0.0;
            }

            parcelas.add(new Parcela(i, valorParcela, juros, amortizacao, saldoDevedor));
        }
        
        return parcelas;
    }
}