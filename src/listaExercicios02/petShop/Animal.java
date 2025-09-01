package listaExercicios02.petShop;

import java.util.ArrayList;
import java.util.List;

public class Animal {

    private String nome;
    private String especie;
    private int idade;
    private double peso;
    private String dono;
    private boolean limpo;
    private List<String> cuidados;

    public Animal(String nome, String especie, int idade, double peso, String dono) {
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
        this.peso = peso;
        this.dono = dono;
        this.limpo = false;
        this.cuidados = new ArrayList<>();
    }

    public void alimentar(double quantidade) {
        this.peso += quantidade * 0.001; // 1g = 0.001kg
        cuidados.add("Alimentado com " + quantidade + "g");
        System.out.println(nome + " foi alimentado com " + quantidade + "g");
        System.out.println("Peso atual: " + String.format("%.2f", peso) + "kg");
    }

    public void darBanho() {
        this.limpo = true;
        cuidados.add("Dando banho");
        System.out.println(nome + " tomou banho e está limpo!");
    }

    public void exibirFicha() {
        System.out.println("=== FICHA DO ANIMAL ===");
        System.out.println("Nome: " + nome);
        System.out.println("Espécie: " + especie);
        System.out.println("Idade: " + idade + " anos");
        System.out.println("Peso: " + String.format("%.2f", peso) + "kg");
        System.out.println("Dono: " + dono);
        System.out.println("Status: " + (limpo ? "Limpo" : "Sujo"));

        System.out.println("\nCuidados recebidos:");
        if (cuidados.isEmpty()) {
            System.out.println("Nenhum cuidado registrado ainda");
        } else {
            for (int i = 0; i < cuidados.size(); i++) {
                System.out.println((i + 1) + ". " + cuidados.get(i));
            }
        }
        System.out.println("======================\n");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public boolean isLimpo() {
        return limpo;
    }

    public void setLimpo(boolean limpo) {
        this.limpo = limpo;
    }

    public List<String> getCuidados() {
        return cuidados;
    }

    public void setCuidados(List<String> cuidados) {
        this.cuidados = cuidados;
    }
}
