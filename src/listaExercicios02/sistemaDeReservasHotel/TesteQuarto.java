package listaExercicios02.sistemaDeReservasHotel;

public class TesteQuarto {
    public static void main(String[] args) {
        Quarto quarto1 = new Quarto(1, "Suite", 100.0);
        Quarto quarto2 = new Quarto(2, "Economica", 50.0);

        System.out.println("1. Quartos disponíveis:");
        quarto1.exibirInfo();
        quarto2.exibirInfo();

        System.out.println("2. Reservando quartos:");
        quarto1.reservar();
        quarto2.reservar();

        System.out.println("=" .repeat(60) + "\n");

        System.out.println("3. Tentando reservar quarto já ocupado:");
        quarto1.reservar();

        System.out.println("=" .repeat(60) + "\n");

        System.out.println("4. Calculando valores das estadias:\n");
        quarto1.calcularValor(3);

        System.out.println("=" .repeat(60) + "\n");

        quarto2.calcularValor(5);

        System.out.println("=" .repeat(60) + "\n");

        System.out.println("5. Liberando quartos:");
        quarto1.liberar();
        quarto2.liberar();

        System.out.println("=" .repeat(60) + "\n");

        System.out.println("6. Tentando liberar quarto já disponível:");
        quarto2.liberar();

        System.out.println("=" .repeat(60) + "\n");

        System.out.println("7. Status final dos quartos:");
        quarto1.exibirInfo();
        quarto2.exibirInfo();



    }
}
