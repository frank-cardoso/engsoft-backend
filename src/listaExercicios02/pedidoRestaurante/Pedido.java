package listaExercicios02.pedidoRestaurante;

import java.util.List;

public class Pedido {
    private int numeroPedido;
    private List<String> itens;
    private List<Double> valores;
    private double valorTotal;
    private String status;

    public Pedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
        this.itens = new java.util.ArrayList<>();
        this.valores = new java.util.ArrayList<>();
        this.valorTotal = 0;
        this.status = "em preparo";
    }

    public void adicionarItem(String item, double valor) {
        if (valor <= 0) {
            System.out.println("Valor do item deve ser maior que zero!");
            return;
        }

        itens.add(item);
        valores.add(valor);
        valorTotal += valor;

        System.out.println("Item adicionado: " + item + " - R$ " + String.format("%.2f", valor));
        System.out.println("Valor total atual: R$ " + String.format("%.2f", valorTotal));
    }

    public void alterarStatus(String novoStatus) {
        String[] statusValidos = {"em preparo", "pronto", "entregue"};
        boolean statusValido = false;

        for (String statusPermitido : statusValidos) {
            if (statusPermitido.equals(novoStatus.toLowerCase())) {
                statusValido = true;
                break;
            }
        }

        if (!statusValido) {
            System.out.println("Status inválido! Status válidos: em preparo, pronto, entregue");
            return;
        }

        String statusAnterior = this.status;
        this.status = novoStatus.toLowerCase();

        System.out.println("Status do pedido " + numeroPedido + " alterado:");
        System.out.println("Anterior: " + statusAnterior + " → Atual: " + status);
    }

    public void exibirResumo() {
        System.out.println("=== RESUMO DO PEDIDO ===");
        System.out.println("Número: " + numeroPedido);
        System.out.println("Status: " + status.toUpperCase());

        if (itens.isEmpty()) {
            System.out.println("Nenhum item no pedido");
        } else {
            System.out.println("Itens:");
            for (int i = 0; i < itens.size(); i++) {
                System.out.println((i + 1) + ". " + itens.get(i) +
                        " - R$ " + String.format("%.2f", valores.get(i)));
            }
        }

        System.out.println("Valor Total: R$ " + String.format("%.2f", valorTotal));
        System.out.println("========================\n");
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public List<String> getItens() {
        return itens;
    }

    public void setItens(List<String> itens) {
        this.itens = itens;
    }

    public List<Double> getValores() {
        return valores;
    }

    public void setValores(List<Double> valores) {
        this.valores = valores;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
