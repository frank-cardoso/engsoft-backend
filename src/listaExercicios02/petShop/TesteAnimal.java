package listaExercicios02.petShop;

public class TesteAnimal {

    public static void main(String[] args) {
        Animal cachorro = new Animal("Rex", "Cachorro", 3, 15.0, "João Silva");
        Animal gato = new Animal("Mimi", "Gato", 2, 4.5, "Maria Santos");

        System.out.println("=== TESTE DO SISTEMA DE PET SHOP ===\n");

        System.out.println("1. Fichas iniciais:");
        cachorro.exibirFicha();
        gato.exibirFicha();

        System.out.println("2. Alimentando os animais:");
        cachorro.alimentar(200);
        gato.alimentar(80);
        System.out.println();

        System.out.println("3. Dando banho:");
        cachorro.darBanho();
        gato.darBanho();
        System.out.println();

        System.out.println("4. Segunda alimentação:");
        cachorro.alimentar(150);
        gato.alimentar(60);
        System.out.println();

        System.out.println("5. Fichas atualizadas:");
        cachorro.exibirFicha();
        gato.exibirFicha();

    }

}
