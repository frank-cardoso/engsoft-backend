package listaExercicios02.gerenciadorDeFuncionários;

public class TesteFuncionario {
    public static void main(String[] args) {
        Funcionario func1 = new Funcionario(
                "Frank",
                "Gerente",
                10000,
                123456789,
                "Gerencia"
        );

        Funcionario func2 = new Funcionario(
                "João Santos",
                "Assistente Administrativo",
                3000.00,
                1002,
                "Recursos Humanos"
        );

        System.out.println("1. Exibindo informações iniciais dos funcionários:");
        func1.exibirDados();
        func2.exibirDados();

        System.out.println("=" .repeat(60) + "\n");

        System.out.println("2. Promovendo o funcionário João Santos:");
        func2.promover("Analista Administrativo", 1500.00);
        func2.exibirDados();

        System.out.println("=" .repeat(60) + "\n");

        System.out.println("3. Transferindo o funcionário Frank para o departamento de Recursos Humanos:");
        func1.transferir("Recursos Humanos");
        func1.exibirDados();

        System.out.println("=" .repeat(60) + "\n");

        System.out.println("5. Dados Finais:");
        func1.exibirDados();
        func2.exibirDados();


    }
}
