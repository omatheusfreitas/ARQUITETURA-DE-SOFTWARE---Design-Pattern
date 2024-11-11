class PedidoPersonalizado {
    private String pratoPrincipal;
    private String acompanhamento;
    private String bebida;

    private PedidoPersonalizado(Builder builder) {
        this.pratoPrincipal = builder.pratoPrincipal;
        this.acompanhamento = builder.acompanhamento;
        this.bebida = builder.bebida;
    }

    @Override
    public String toString() {
        return "PedidoPersonalizado [Prato Principal=" + pratoPrincipal + ", Acompanhamento=" + acompanhamento + ", Bebida=" + bebida + "]";
    }

    // Builder interno
    public static class Builder {
        private String pratoPrincipal;
        private String acompanhamento;
        private String bebida;

        public Builder setPratoPrincipal(String pratoPrincipal) {
            this.pratoPrincipal = pratoPrincipal;
            return this;
        }

        public Builder setAcompanhamento(String acompanhamento) {
            this.acompanhamento = acompanhamento;
            return this;
        }

        public Builder setBebida(String bebida) {
            this.bebida = bebida;
            return this;
        }

        public PedidoPersonalizado build() {
            return new PedidoPersonalizado(this);
        }
    }
}

// Classe main para testar o padrão Builder
public class BuilderRestaurante {
    public static void main(String[] args) {
        PedidoPersonalizado pedido = new PedidoPersonalizado.Builder()
            .setPratoPrincipal("Bife com batatas")
            .setAcompanhamento("Salada Verde")
            .setBebida("Suco de Laranja")
            .build();

        System.out.println(pedido);
    }
}
