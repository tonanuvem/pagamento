package padroesgof.pagamento;

import padroesgof.pagamento.PagamentoAPI.TipoPagamento;
import padroesgof.pagamento.Pagamento;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final AtomicLong contador = new AtomicLong();

    // Exemplo de chamada:
    // http://localhost:8080/pagamento?tipo_pagamento=DINHEIRO&valor_pagamento=500
    @RequestMapping("/pagamento")
    public Pagamento pagamento(@RequestParam(value="tipo_pagamento", defaultValue="CARTAO") String tipoPagamento, @RequestParam(value="valor_pagamento", defaultValue="1001") int valorPagamento) {
        // Tratamento dos parametros da entrada: Get enum by name baseado na String
        TipoPagamento tipo = TipoPagamento.valueOf(tipoPagamento);
        return Pagamento.factoryPagamento(contador.incrementAndGet(), tipo, valorPagamento);
    }

    @RequestMapping("/")
    public String index() {
        return "Microserviço de Pagamento!";
    }
}