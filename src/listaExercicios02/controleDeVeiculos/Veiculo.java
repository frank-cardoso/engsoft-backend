package listaExercicios02.controleDeVeiculos;

public class Veiculo {
    private String modelo;
    private String placa;
    private int ano;
    private boolean estaAlugado;
    private int quilometragem;


    public Veiculo(String modelo, String placa, int ano, int quilometragem) {
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.estaAlugado = false;
    }

    public boolean alugar() {
        if (!estaAlugado) {
            estaAlugado = true;
            System.out.println("Veículo alugado com sucesso!");
            System.out.println("Modelo: " + modelo + " - Placa: " + placa);
            System.out.println("Quilometragem inicial: " + quilometragem + " km");
            return true;
        } else {
            System.out.println("Veículo " + modelo + " (" + placa + ") já está alugado.");
            return false;
        }
    }

    public boolean devolver(int kmRodados) {
        if (!estaAlugado) {
            System.out.println("Veículo " + modelo + " (" + placa + ") não está alugado.");
            return false;
        }

        if (kmRodados < 0) {
            System.out.println("Quilometragem rodada não pode ser negativa!");
            return false;
        }

        int quilometragemAnterior = quilometragem;
        quilometragem += kmRodados;
        estaAlugado = false;

        System.out.println("Veículo devolvido com sucesso!");
        System.out.println("Modelo: " + modelo + " - Placa: " + placa);
        System.out.println("Quilometragem anterior: " + quilometragemAnterior + " km");
        System.out.println("Quilômetros rodados: " + kmRodados + " km");
        System.out.println("Quilometragem atual: " + quilometragem + " km");

        return true;
    }

    public void exibirStatus() {
        System.out.println("=== STATUS DO VEÍCULO ===");
        System.out.println("Modelo: " + modelo);
        System.out.println("Placa: " + placa);
        System.out.println("Ano: " + ano);
        System.out.println("Quilometragem: " + quilometragem + " km");
        System.out.println("Status: " + (estaAlugado ? "ALUGADO" : "DISPONÍVEL"));
        System.out.println("=========================\n");
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public boolean isEstaAlugado() {
        return estaAlugado;
    }

    public void setEstaAlugado(boolean estaAlugado) {
        this.estaAlugado = estaAlugado;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
