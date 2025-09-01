package listaExercicios02.sistemaPagamentoMensalidades;

public class TesteMensalidade {
    public static void main(String[] args) {
        Mensalidade mens1 = new Mensalidade("João Silva", 500.00, "10/10/2024");
        Mensalidade mens2 = new Mensalidade("Maria Santos", 450.00, "15/10/2024");
        Mensalidade mens3 = new Mensalidade("Pedro Costa", 600.00, "05/10/2024");

        System.out.println("1. Status inicial:");
        mens1.exibirStatus();
        mens2.exibirStatus();
        mens3.exibirStatus();

        System.out.println("2. Verificando em 08/10/2024:");
        mens1.verificarAtraso("08/10/2024");
        mens2.verificarAtraso("08/10/2024");
        mens3.verificarAtraso("08/10/2024");
        System.out.println();

        System.out.println("3. Verificando em 12/10/2024:");
        mens1.verificarAtraso("12/10/2024");
        mens2.verificarAtraso("12/10/2024");
        mens3.verificarAtraso("12/10/2024");
        System.out.println();

        System.out.println("4. Realizando pagamentos:");
        mens1.pagar();
        System.out.println();
        mens3.pagar();
        System.out.println();

        System.out.println("5. Tentando pagar novamente:");
        mens1.pagar();
        System.out.println();

        System.out.println("6. Verificando após pagamentos:");
        mens1.verificarAtraso("20/10/2024");
        mens2.verificarAtraso("20/10/2024");
        mens3.verificarAtraso("20/10/2024");
        System.out.println();

        System.out.println("7. Status final:");
        mens1.exibirStatus();
        mens2.exibirStatus();
        mens3.exibirStatus();

    }
}
