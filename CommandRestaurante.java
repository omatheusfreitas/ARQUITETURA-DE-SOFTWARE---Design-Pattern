import java.util.ArrayList;
import java.util.List;

// Interface de comando
interface Comando {
    void executar();
}

// Comando para cozinhar um pedido
class CozinharPedido implements Comando {
    private String pedido;

    public CozinharPedido(String pedido) {
        this.pedido = pedido;
    }

    @Override
    public void executar() {
        System.out.println("Cozinhando o pedido: " + pedido);
    }
}

// Comando para servir um pedido
class ServirPedido implements Comando {
    private String pedido;

    public ServirPedido(String pedido) {
        this.pedido = pedido;
    }

    @Override
    public void executar() {
        System.out.println("Servindo o pedido: " + pedido);
    }
}

// Comando para cancelar um pedido
class CancelarPedido implements Comando {
    private String pedido;

    public CancelarPedido(String pedido) {
        this.pedido = pedido;
    }

    @Override
    public void executar() {
        System.out.println("Cancelando o pedido: " + pedido);
    }
}

// Classe que gerencia os comandos
class GestorPedidos {
    private List<Comando> filaDeComandos = new ArrayList<>();

    public void adicionarComando(Comando comando) {
        filaDeComandos.add(comando);
    }

    public void processarComandos() {
        for (Comando comando : filaDeComandos) {
            comando.executar();
        }
        filaDeComandos.clear();
    }
}

// Classe main para testar o padrão Command
public class CommandRestaurante {
    public static void main(String[] args) {
        GestorPedidos gestorPedidos = new GestorPedidos();

        Comando cozinhar = new CozinharPedido("Pizza Portuguesa");
        Comando servir = new ServirPedido("Pizza Portuguesa");
        Comando cancelar = new CancelarPedido("Lasanha");

        gestorPedidos.adicionarComando(cozinhar);
        gestorPedidos.adicionarComando(servir);
        gestorPedidos.adicionarComando(cancelar);

        gestorPedidos.processarComandos();
    }
}
