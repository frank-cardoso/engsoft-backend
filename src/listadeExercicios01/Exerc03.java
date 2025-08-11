package listadeExercicios01;

import java.util.Scanner;

public class Exerc03 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String nome;
        int idade;
        double salario;
        char sexo;
        char estadoCivil;

        while(true){
            System.out.println("Digite seu nome: ");
            nome = scanner.next();

            if(nome.length() > 3) {
                break;
            } else {
                System.out.println("Nome inválido. Insira um nome com mais de 3 caracteres.");
            }
        }

        while(true){
            System.out.println("Digite sua idade: ");
            idade = scanner.nextInt();

            if(idade >= 0 && idade <= 150) {
                break;
            } else {
                System.out.println("Idade inválida. Insira uma idade entre 0 e 150.");
            }
        }

        while(true){
            System.out.println("Digite seu salario: ");
            salario = scanner.nextDouble();

            if(salario > 0 ) {
                break;
            } else {
                System.out.println("Salário inválido. Insira um valor maior que zero.");
            }
        }

        scanner.nextLine();

        while(true){
            System.out.println("Digite seu sexo(f/m): ");
            String entradaSexo =  scanner.nextLine().toLowerCase();

            if(entradaSexo.equals("f")  || entradaSexo.equals("m")){
                sexo = entradaSexo.charAt(0);
                break;
            } else {
                System.out.println("Sexo inválido. Insira 'f' para feminino ou 'm' para masculino.");
            }
        }

        while(true){
            System.out.println("Digite o estado civil (s/c/v/d): ");
            String entradaEstadoCivil =  scanner.nextLine().toLowerCase();

            if(entradaEstadoCivil.equals("s")  || entradaEstadoCivil.equals("c") ||
               entradaEstadoCivil.equals("v") || entradaEstadoCivil.equals("d")){
               estadoCivil = entradaEstadoCivil.charAt(0);
               break;
            } else {
                System.out.println("Estado civil inválido. Insira 's', 'c', 'v' ou 'd'.");
            }
        }

        System.out.println("\n--- Cadastro Concluído ---");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Salário: R$ " + salario);
        System.out.println("Sexo: " + (sexo == 'f' ? "Feminino" : "Masculino"));
        System.out.println("Estado civil: " + estadoCivil);

        scanner.close();
    }
}
