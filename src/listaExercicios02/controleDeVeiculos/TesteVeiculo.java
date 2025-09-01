package listaExercicios02.controleDeVeiculos;

public class TesteVeiculo {
    public static void main(String[] args) {
        Veiculo carro1 = new Veiculo("Fiat", "Uno", 2020, 10000);
        Veiculo carro2 = new Veiculo("Ford", "Focus", 2019, 15000);
        Veiculo carro3 = new Veiculo("Volkswagen", "Golf", 2018, 12000);

        System.out.println("1. Status inicial da frota:");
        carro1.exibirStatus();
        carro2.exibirStatus();
        carro3.exibirStatus();

        System.out.println("2. Realizando aluguéis:");
        carro1.alugar();
        System.out.println();

        carro2.alugar();
        System.out.println();


        System.out.println("3. Tentando alugar veículo já alugado:");
        carro1.alugar();
        System.out.println();

        System.out.println("4. Status após aluguéis:");
        carro1.exibirStatus();
        carro2.exibirStatus();
        carro3.exibirStatus();

        System.out.println("5. Devolvendo veículos:");
        carro1.devolver(350);
        System.out.println();

        carro2.devolver(180);
        System.out.println();

        System.out.println("6. Tentando devolver veículo não alugado:");
        carro3.devolver(100);
        System.out.println();

        System.out.println("7. Testando quilometragem inválida:");
        carro3.alugar();
        System.out.println();
        carro3.devolver(-50);
        System.out.println();
        carro3.devolver(200);
        System.out.println();

        System.out.println("8. Status final da frota:");
        carro1.exibirStatus();
        carro2.exibirStatus();
        carro3.exibirStatus();
    }
}
