package listaExercicios02.gestaoDeAlunos;

public class TesteAluno {

    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("João Silva", 20, 2021001, "Engenharia de Software");
        Aluno aluno2 = new Aluno("Maria Santos", 19, 2021002, "Ciência da Computação");
        Aluno aluno3 = new Aluno("Pedro Costa", 21, 2021003, "Sistemas de Informação");

        System.out.println("1. Alunos cadastrados:");
        aluno1.exibirInfo();
        aluno2.exibirInfo();
        aluno3.exibirInfo();

        System.out.println("2. Adicionando notas para " + aluno1.getNome() + ":");
        aluno1.adicionarNota(8.5);
        aluno1.adicionarNota(7.0);
        aluno1.adicionarNota(9.2);
        aluno1.adicionarNota(6.8);

        System.out.println("=" .repeat(60) + "\n");

        System.out.println("3. Verificando aprovação:");
        aluno1.verificarAprovacao();

        System.out.println("=" .repeat(60) + "\n");

        System.out.println("4. Adicionando notas para " + aluno2.getNome() + ":");
        aluno2.adicionarNota(5.5);
        aluno2.adicionarNota(6.0);
        aluno2.adicionarNota(4.8);
        aluno2.adicionarNota(7.2);

        System.out.println("=" .repeat(60) + "\n");

        aluno2.verificarAprovacao();
        System.out.println("=" .repeat(60) + "\n");

        System.out.println("5. Adicionando notas para " + aluno3.getNome() + ":");
        aluno3.adicionarNota(9.0);
        aluno3.adicionarNota(8.5);
        aluno3.adicionarNota(7.8);

        System.out.println("=" .repeat(60) + "\n");

        aluno3.verificarAprovacao();

        System.out.println("=" .repeat(60) + "\n");

        System.out.println("6. Testando validação de notas:");
        aluno1.adicionarNota(11.0);
        aluno1.adicionarNota(-1.0);

        System.out.println("=" .repeat(60) + "\n");

        System.out.println("7. Informações finais dos alunos:");
        aluno1.exibirInfo();
        aluno2.exibirInfo();
        aluno3.exibirInfo();

        System.out.println("=" .repeat(60) + "\n");

    }
}