package listaExercicios02.pedidoRestaurante;

public class TestePedido {
    public static void main(String[] args) {
        Pedido pedido1 = new Pedido(101);
        Pedido pedido2 = new Pedido(102);
        Pedido pedido3 = new Pedido(103);

        System.out.println("1. Pedidos iniciais:");
        pedido1.exibirResumo();
        pedido2.exibirResumo();

        System.out.println("2. Montando pedido 101:");
        pedido1.adicionarItem("Hambúrguer Clássico", 25.50);
        pedido1.adicionarItem("Batata Frita", 12.00);
        pedido1.adicionarItem("Refrigerante", 6.50);
        System.out.println();

        System.out.println("3. Montando pedido 102:");
        pedido2.adicionarItem("Pizza Margherita", 35.00);
        pedido2.adicionarItem("Suco Natural", 8.00);
        System.out.println();

        System.out.println("4. Montando pedido 103:");
        pedido3.adicionarItem("Salada Caesar", 22.00);
        pedido3.adicionarItem("Água", 3.50);
        pedido3.adicionarItem("Sobremesa", 15.00);
        System.out.println();

        System.out.println("5. Resumos dos pedidos:");
        pedido1.exibirResumo();
        pedido2.exibirResumo();
        pedido3.exibirResumo();

        System.out.println("6. Alterando status - Pedido pronto:");
        pedido1.alterarStatus("pronto");
        System.out.println();

        System.out.println("7. Entregando pedido:");
        pedido1.alterarStatus("entregue");
        System.out.println();

        pedido1.exibirResumo();

        System.out.println("9. Testando valor inválido:");
        pedido2.adicionarItem("Item Teste", -5.00);
        System.out.println();

        System.out.println("10. Simulando fluxo completo do pedido 102:");
        pedido2.exibirResumo();

        System.out.println("Preparando...");
        pedido2.alterarStatus("pronto");
        System.out.println();

        System.out.println("Entregando...");
        pedido2.alterarStatus("entregue");
        System.out.println();

        pedido2.exibirResumo();

        System.out.println("11. Adicionando mais itens ao pedido 103:");
        pedido3.adicionarItem("Café Espresso", 4.50);
        pedido3.adicionarItem("Pão de Açúcar", 7.00);
        System.out.println();

        pedido3.exibirResumo();

        System.out.println("12. Finalizando pedido 103:");
        pedido3.alterarStatus("pronto");
        System.out.println();

        pedido3.alterarStatus("entregue");
        System.out.println();

    }
}
