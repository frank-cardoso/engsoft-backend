package listadeExercicios01;

import java.util.Scanner;

public class Exerc05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String resposta;

        do {
            double populacaoA = 0, taxaA = 0, populacaoB = 0, taxaB = 0;

            while (true) {
                System.out.print("Informe a população inicial do país A (número positivo): ");
                try {
                    populacaoA = Double.parseDouble(scanner.nextLine());
                    if (populacaoA > 0) break;
                    else System.out.println("População deve ser positiva.");
                } catch (Exception e) {
                    System.out.println("Entrada inválida. Tente novamente.");
                }
            }

            while (true) {
                System.out.print("Informe a taxa de crescimento anual do país A (em %, > 0): ");
                try {
                    taxaA = Double.parseDouble(scanner.nextLine());
                    if (taxaA > 0) break;
                    else System.out.println("Taxa deve ser maior que 0.");
                } catch (Exception e) {
                    System.out.println("Entrada inválida. Tente novamente.");
                }
            }

            while (true) {
                System.out.print("Informe a população inicial do país B (número positivo): ");
                try {
                    populacaoB = Double.parseDouble(scanner.nextLine());
                    if (populacaoB > 0) break;
                    else System.out.println("População deve ser positiva.");
                } catch (Exception e) {
                    System.out.println("Entrada inválida. Tente novamente.");
                }
            }

            while (true) {
                System.out.print("Informe a taxa de crescimento anual do país B (em %, > 0): ");
                try {
                    taxaB = Double.parseDouble(scanner.nextLine());
                    if (taxaB > 0) break;
                    else System.out.println("Taxa deve ser maior que 0.");
                } catch (Exception e) {
                    System.out.println("Entrada inválida. Tente novamente.");
                }
            }

            if (populacaoA >= populacaoB) {
                System.out.println("A população do país A já é maior ou igual à do país B. Nenhum cálculo necessário.");
            } else {
                int anos = 0;
                double popA = populacaoA;
                double popB = populacaoB;

                while (popA < popB) {
                    popA += popA * (taxaA / 100);
                    popB += popB * (taxaB / 100);
                    anos++;
                }

                System.out.println("Com as populações e taxas informadas, serão necessários " + anos +
                        " anos para que a população do país A ultrapasse ou se iguale à do país B.");
            }

            do {
                System.out.print("Deseja realizar outra simulação? (Sim/Não): ");
                resposta = scanner.nextLine().trim().toLowerCase();

                if (!resposta.equals("sim") && !resposta.equals("s") &&
                        !resposta.equals("nao") && !resposta.equals("não") && !resposta.equals("n")) {
                    System.out.println("Resposta inválida. Por favor, digite 'Sim' ou 'Não'.");
                }
            } while (!resposta.equals("sim") && !resposta.equals("s") &&
                    !resposta.equals("nao") && !resposta.equals("não") && !resposta.equals("n"));

        } while (resposta.equals("sim") || resposta.equals("s"));

        System.out.println("Programa encerrado. Obrigado por usar!");
        scanner.close();
    }
}
