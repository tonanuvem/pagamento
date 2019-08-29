package padroesgof.pagamento;

class PagamentoComDinheiro extends Pagamento {

    PagamentoComDinheiro(long contador, int valor) {
        this.id = contador;
        this.setValorPagamento(valor);
        processarPagamento(valor);
    }

    @Override
    public PagamentoComDinheiro processarPagamento(int valor) {
        this.setStatusPagamento("Pagamento em Dinheiro processado com sucesso");
        return this;
    }
}