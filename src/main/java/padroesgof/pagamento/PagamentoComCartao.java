package padroesgof.pagamento;

class PagamentoComCartao extends Pagamento {

    private final int limiteCartao = 1000;

    PagamentoComCartao(long contador, int valor) {
        this.id = contador;
        this.setValorPagamento(valor);
        processarPagamento(valor);
    }

    @Override
    public PagamentoComCartao processarPagamento(int valor) {
        if (valor <= limiteCartao) {
            this.setStatusPagamento("Pagamento em Cartão processado com sucesso");
        }
        else {
            this.setStatusPagamento("Pagamento não autorizado");
        }
        return this;
    }
}