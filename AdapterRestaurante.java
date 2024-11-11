// Interface de pagamento padrão que o restaurante usa
interface Pagamento {
    void pagar(double valor);
}


class PagamentoPix {
    public void efetuarPagamento(double valor) {
        System.out.println("Pagamento de R$ " + valor + " Transação autorizada.");
    }
}

class PagamentoDebito {
    public void fazerPagamento(double valor) {
        System.out.println("Pagamento de R$ " + valor + " Transação autorizada.");
    }
}

// Adapter para integrar o sistema PayPal
class PixAdapter implements Pagamento {
    private PagamentoPix pagamentoPix;

    public PixAdapter(PagamentoPayPal pagamentoPix) {
        this.pagamentoPix = pagamentoPix;
    }

    @Override
    public void pagar(double valor) {
        pagamentoPix.efetuarPagamento(valor);
    }
}


class DebitoAdapter implements Pagamento {
    private PagamentoDebito pagamentoDebito;

    public DebitoAdapter(PagamentoStripe pagamentoDebito) {
        this.pagamentoDebito = pagamentoDebito;
    }

    @Override
    public void pagar(double valor) {
        pagamentoDebito.fazerPagamento(valor);
    }
}


public class AdapterRestaurante {
    public static void main(String[] args) {
        Pagamento pagamentoPix = new PixAdapter(new PagamentoPix());
        Pagamento pagamentoDebito = new DebitoAdapter(new PagamentoDebito());

        pagamentoPix.pagar(50.0);
        pagamentoDebito.pagar(75.0);
    }
}
