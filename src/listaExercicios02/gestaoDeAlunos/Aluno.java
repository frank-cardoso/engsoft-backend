package listaExercicios02.gestaoDeAlunos;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

    private String nome;
    private int idade;
    private int matricula;
    private String curso;
    private List<Double> notas;

    public Aluno(String nome, int idade, int matricula, String curso) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
        this.curso = curso;
        this.notas = new ArrayList<>();
    }

    public void adicionarNota(double nota) {
        if (nota < 0 || nota > 10) {
            System.out.println("Nota inválida! Deve estar entre 0 e 10.");
            return;
        }

        notas.add(nota);
        System.out.println("Nota " + nota + " adicionada para " + nome);
    }


    public double calcularMedia() {

        if(notas.isEmpty()) {
            System.out.println("Nenhuma nota cadastrada para " + nome);
            return 0.0;
        }

        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }

        double media = soma / notas.size();
        System.out.println("Média de " + nome + ": " + String.format("%.2f", media));
        return media;
    }

    public boolean verificarAprovacao() {
        if (notas.isEmpty()) {
            System.out.println("Não é possível verificar aprovação sem notas para " + nome);
            return false;
        }

        double media = calcularMedia();
        boolean aprovado = media >= 7.0;

        System.out.println("Situação de " + nome + ": " + (aprovado ? "APROVADO" : "REPROVADO"));
        return aprovado;
    }


    public void exibirInfo() {
        System.out.println("=== INFORMAÇÕES DO ALUNO ===");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade + " anos");
        System.out.println("Matrícula: " + matricula);
        System.out.println("Curso: " + curso);

        if (notas.isEmpty()) {
            System.out.println("Notas: Nenhuma nota cadastrada");
        } else {
            System.out.print("Notas: ");
            for (int i = 0; i < notas.size(); i++) {
                System.out.print(notas.get(i));
                if (i < notas.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
            System.out.println("Média: " + String.format("%.2f", calcularMedia()));
        }

        System.out.println("============================\n");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }
}
