package listadeExercicios01;

public class Exerc04 {
    public static void main(String[] args) {
        int populacaoA = 80000;
        int populacaoB = 200000;

        double taxaA = 0.03;
        double taxaB = 0.015;

        int anos = 0;

        while (populacaoA < populacaoB) {
            populacaoA += populacaoA * taxaA;
            populacaoB += populacaoB * taxaB;
            anos++;
        }

        System.out.println("Serão necessários " + anos +
                " anos para que a população do país A ultrapasse ou se iguale à população do país B.");

    }
}
