package padroesgof.pagamento;

abstract class Pagamento implements PagamentoAPI {

    protected long id;
    protected String statusPagamento;
    protected int valorPagamento;

    @Override
    public abstract Pagamento processarPagamento(int valor);

    static Pagamento factoryPagamento(long contador, TipoPagamento tipoPagamento, int valor) {
        // Definir qual o tipo de Pagamento
        switch (tipoPagamento) {
        case CARTAO:
            return new PagamentoComCartao(contador, valor); // Exemplo Factory Method
        case CHEQUE:
            return new PagamentoComCheque(contador, valor);
        case DINHEIRO: 
            return new PagamentoComDinheiro(contador, valor);
        }
        return null;
    }

    public long getId() {
        return id;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public int getValorPagamento() {
        return valorPagamento;
    }

    public void setStatusPagamento(String s) {
        statusPagamento = s;
    }

    public void setValorPagamento(int valorPagamento) {
        this.valorPagamento = valorPagamento;
    }


}
