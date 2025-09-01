package listaExercicios02.sistemaDeBiblioteca;

public class TesteLivro {

    public static void main(String[] args) {
        Livro livro1 = new Livro(
                "Dom Casmurro",
                "Machado de Assis",
                1899,
                123456789
        );

        System.out.println("1. Chamando metodo exibirInformacoes()");
        livro1.exibirInformacoes();

        System.out.println("2. Tentando emprestar o livro com o metodo emprestar()");
        boolean emprestado = livro1.emprestar();
        System.out.println("Livro emprestado? " + emprestado);

        System.out.println("3. Informações após empréstimo:");
        livro1.exibirInformacoes();

        System.out.println("4. Tentando emprestar novamente (deve falhar):");
        boolean segundoEmprestimo = livro1.emprestar();
        System.out.println("Resultado do segundo empréstimo: " + (segundoEmprestimo ? "Sucesso" : "Falha"));

        System.out.println("5. Tentando devolver o livro com o metodo devolver()");
        boolean devolvido = livro1.devolver();
        System.out.println("Livro devolvido? " + devolvido);

        System.out.println("6. Informações após devolução:");
        livro1.exibirInformacoes();



    }
}
