package listaExercicios02.sistemaDeVendas;

public class TesteProduto {
    public static void main(String[] args) {
        Produto produto1 = new Produto("TV", 123456789, 1000.0, 10);
        Produto produto2 = new Produto("Notebook", 987654321, 2000.0, 25);
        Produto produto3 = new Produto("Teclado Mecânico", 1003, 300.00, 5);

        System.out.println("1. Produtos cadastrados:");
        produto1.exibirProduto();
        produto2.exibirProduto();
        produto3.exibirProduto();

        System.out.println("2. Realizando vendas:");
        produto1.vender(2);
        System.out.println("=" .repeat(60) + "\n");

        produto2.vender(10);
        System.out.println("=" .repeat(60) + "\n");

        produto3.vender(3);
        System.out.println("=" .repeat(60) + "\n");

        System.out.println("3. Tentando vender mais do que o disponível:");
        produto1.vender(15);
        System.out.println("=" .repeat(60) + "\n");

        produto3.vender(5);
        System.out.println("=" .repeat(60) + "\n");

        System.out.println("4. Repondo estoque:");
        produto1.repor(5);
        System.out.println("=" .repeat(60) + "\n");

        produto2.repor(20);
        System.out.println("=" .repeat(60) + "\n");

        produto3.repor(10);
        System.out.println("=" .repeat(60) + "\n");


        System.out.println("5. Produtos após reposição:");
        produto1.exibirProduto();
        produto2.exibirProduto();
        produto3.exibirProduto();


    }
}
