package padroesgof.pagamento;

class PagamentoComCheque extends Pagamento {

    private final int limiteCheque = 450;

    PagamentoComCheque(long contador, int valor) {
        this.id = contador;
        this.setValorPagamento(valor);
        processarPagamento(valor);
    }

    @Override
    public PagamentoComCheque processarPagamento(int valor) {
        if (valor <= limiteCheque) {
            this.setStatusPagamento("Pagamento em Cheque processado com sucesso");
        }
        else {
            this.setStatusPagamento("Pagamento não autorizado");
        }
        return this;
    }
}