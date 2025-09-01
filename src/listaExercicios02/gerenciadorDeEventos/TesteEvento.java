package listaExercicios02.gerenciadorDeEventos;

public class TesteEvento {
    public static void main(String[] args) {
        Evento evento1 = new Evento("Workshop de Java", "15/10/2024", "Auditório A", 5);
        Evento evento2 = new Evento("Palestra de IA", "20/10/2024", "Sala de Conferências", 3);
        Evento evento3 = new Evento("Curso de Python", "25/10/2024", "Laboratório 1", 8);

        System.out.println("1. Eventos criados:");
        evento1.exibirDetalhes();
        evento2.exibirDetalhes();
        evento3.exibirDetalhes();

        System.out.println("2. Verificando disponibilidade inicial:");
        evento1.verificarDisponibilidade();
        evento2.verificarDisponibilidade();

        System.out.println("3. Inscrevendo pessoas no Workshop de Java:");
        evento1.inscrever("João Silva");
        evento1.inscrever("Maria Santos");
        evento1.inscrever("Pedro Costa");
        System.out.println();

        System.out.println("4. Verificando disponibilidade após inscrições:");
        evento1.verificarDisponibilidade();

        System.out.println("5. Completando lotação do Workshop:");
        evento1.inscrever("Ana Oliveira");
        evento1.inscrever("Carlos Lima");
        System.out.println();

        System.out.println("6. Tentando inscrever além da capacidade:");
        evento1.inscrever("Roberto Silva");
        System.out.println();

        System.out.println("7. Testando inscrição duplicada:");
        evento1.inscrever("João Silva");
        System.out.println();

        System.out.println("8. Testando nome inválido:");
        evento1.inscrever("");
        evento1.inscrever(null);
        System.out.println();

        System.out.println("9. Inscrevendo na Palestra de IA:");
        evento2.inscrever("Sofia Martinez");
        evento2.inscrever("Bruno Ferreira");
        evento2.inscrever("Laura Pereira");
        System.out.println();

        System.out.println("10. Tentando inscrever no evento lotado:");
        evento2.inscrever("Gabriel Santos");
        System.out.println();

        System.out.println("11. Inscrevendo no Curso de Python:");
        evento3.inscrever("Fernanda Lima");
        evento3.inscrever("Ricardo Oliveira");
        evento3.inscrever("Juliana Costa");
        System.out.println();

        System.out.println("12. Detalhes finais dos eventos:");
        evento1.exibirDetalhes();
        evento2.exibirDetalhes();
        evento3.exibirDetalhes();

    }
}
