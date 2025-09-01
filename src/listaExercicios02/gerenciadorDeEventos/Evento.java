package listaExercicios02.gerenciadorDeEventos;

import java.util.ArrayList;
import java.util.List;


public class Evento {
    private String nome;
    private String data;
    private String local;
    private int capacidade;
    private List<String> inscritos;

    public Evento(String nome, String data, String local, int capacidade) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.capacidade = capacidade;
        this.inscritos = new ArrayList<>();
    }

    public boolean inscrever(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Nome não pode ser vazio!");
            return false;
        }

        if (inscritos.contains(nome)) {
            System.out.println(nome + " já está inscrito no evento " + this.nome);
            return false;
        }

        if (inscritos.size() >= capacidade) {
            System.out.println("Evento " + this.nome + " está lotado! Não é possível inscrever " + nome);
            return false;
        }

        inscritos.add(nome);
        System.out.println(nome + " inscrito com sucesso no evento " + this.nome);
        System.out.println("Vagas ocupadas: " + inscritos.size() + "/" + capacidade);

        return true;
    }

    public int verificarDisponibilidade() {
        int vagasDisponiveis = capacidade - inscritos.size();

        System.out.println("=== DISPONIBILIDADE ===");
        System.out.println("Evento: " + nome);
        System.out.println("Capacidade: " + capacidade);
        System.out.println("Inscritos: " + inscritos.size());
        System.out.println("Vagas disponíveis: " + vagasDisponiveis);
        System.out.println("Status: " + (vagasDisponiveis > 0 ? "Disponível" : "Lotado"));
        System.out.println("=======================\n");

        return vagasDisponiveis;
    }

    public void exibirDetalhes() {
        System.out.println("=== DETALHES DO EVENTO ===");
        System.out.println("Nome: " + nome);
        System.out.println("Data: " + data);
        System.out.println("Local: " + local);
        System.out.println("Capacidade: " + capacidade + " pessoas");
        System.out.println("Inscritos: " + inscritos.size() + "/" + capacidade);

        if (inscritos.isEmpty()) {
            System.out.println("Nenhum inscrito ainda");
        } else {
            System.out.println("Lista de inscritos:");
            for (int i = 0; i < inscritos.size(); i++) {
                System.out.println((i + 1) + ". " + inscritos.get(i));
            }
        }

        System.out.println("==========================\n");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public List<String> getInscritos() {
        return inscritos;
    }

    public void setInscritos(List<String> inscritos) {
        this.inscritos = inscritos;
    }
}
