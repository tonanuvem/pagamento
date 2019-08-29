package padroesgof.pagamento;

public interface PagamentoAPI {

    public enum TipoPagamento
    {
        CARTAO("CARTAO"),
        CHEQUE("CHEQUE"),
        DINHEIRO("DINHEIRO");
    
        private String tipo;
    
        TipoPagamento(String t) {
            this.tipo = t;
        }
    
        public String toString() {
            return tipo;
        }
    }

    abstract Pagamento processarPagamento(int valor);

}