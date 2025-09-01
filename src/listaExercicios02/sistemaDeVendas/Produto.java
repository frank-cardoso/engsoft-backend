package listaExercicios02.sistemaDeVendas;

public class Produto {

    private String nome;
    private int codigo;
    private double preco;
    private int estoque;

    public Produto(String nome, int codigo, double preco, int estoque) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.estoque = estoque;
    }

    public double vender(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade deve ser maior que zero!");
            return 0.0;
        }

        if (quantidade > estoque) {
            System.out.println("Venda não realizada! Estoque insuficiente.");
            System.out.println("Quantidade solicitada: " + quantidade);
            System.out.println("Estoque disponível: " + estoque);
            return 0.0;
        }

        estoque -= quantidade;
        double valorTotal = quantidade * preco;

        System.out.println("Venda realizada com sucesso!");
        System.out.println("Produto: " + nome);
        System.out.println("Quantidade vendida: " + quantidade);
        System.out.println("Valor unitário: R$ " + String.format("%.2f", preco));
        System.out.println("Valor total: R$ " + String.format("%.2f", valorTotal));
        System.out.println("Estoque restante: " + estoque);

        return valorTotal;
    }

    public void repor(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade deve ser maior que zero!");
            return;
        }

        int estoqueAnterior = estoque;
        estoque += quantidade;

        System.out.println("Reposição realizada com sucesso!");
        System.out.println("Produto: " + nome);
        System.out.println("Quantidade reposta: " + quantidade);
        System.out.println("Estoque anterior: " + estoqueAnterior);
        System.out.println("Estoque atual: " + estoque);
    }

    public void exibirProduto() {
        System.out.println("=== PRODUTO ===");
        System.out.println("Nome: " + nome);
        System.out.println("Código: " + codigo);
        System.out.println("Preço: R$ " + String.format("%.2f", preco));
        System.out.println("Estoque: " + estoque + " unidades");
        System.out.println("Status: " + (estoque > 0 ? "Disponível" : "Esgotado"));
        System.out.println("===============\n");
    }

}
