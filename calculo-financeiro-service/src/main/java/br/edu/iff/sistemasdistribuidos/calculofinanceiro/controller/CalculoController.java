package br.edu.iff.sistemasdistribuidos.calculofinanceiro.controller;

import br.edu.iff.sistemasdistribuidos.calculofinanceiro.model.AmortizacaoRequest;
import br.edu.iff.sistemasdistribuidos.calculofinanceiro.model.InvestimentoRequest;
import br.edu.iff.sistemasdistribuidos.calculofinanceiro.model.Parcela;
import br.edu.iff.sistemasdistribuidos.calculofinanceiro.model.ResultadoCalculo;
import br.edu.iff.sistemasdistribuidos.calculofinanceiro.service.CalculoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/calculo")
public class CalculoController {

    @Autowired
    private CalculoService calculoService;

    @PostMapping("/juros-compostos")
    public ResponseEntity<ResultadoCalculo> calcular(@RequestBody InvestimentoRequest request, HttpServletRequest httpRequest) {
        String clientIp = httpRequest.getRemoteAddr();
        
        ResultadoCalculo resultado = calculoService.calcularJurosCompostos(request, clientIp);
        
        return ResponseEntity.ok(resultado);
    }

    @PostMapping("/tabela-price")
    public ResponseEntity<List<Parcela>> calcularTabelaPrice(@RequestBody AmortizacaoRequest request, HttpServletRequest httpRequest) {
        String clientIp = httpRequest.getRemoteAddr();
        
        List<Parcela> resultado = calculoService.calcularTabelaPrice(request, clientIp);
        
        return ResponseEntity.ok(resultado);
    }
}