package listaExercicios02.sistemaDeReservasHotel;

public class Quarto {

    private int numero;
    private String tipo;
    private double precoPorNoite;
    private boolean estaOcupado;

    public Quarto(int numero, String tipo, double precoPorNoite) {
        this.numero = numero;
        this.tipo = tipo;
        this.precoPorNoite = precoPorNoite;
        this.estaOcupado = false;
    }

    public boolean reservar() {
        if(!estaOcupado) {
            estaOcupado = true;
            System.out.println("Quarto " + numero + " (" + tipo + ") reservado com sucesso!");
            return true;
        } else {
            System.out.println("Quarto " + numero + " já está ocupado.");
            return false;
        }
    }

    public boolean liberar() {
        if(estaOcupado) {
            estaOcupado = false;
            System.out.println("Quarto " + numero + " liberado com sucesso!");
            return true;
        } else {
            System.out.println("Quarto " + numero + " já está disponível.");
            return false;
        }
    }

    public double calcularValor(int dias) {
        if (dias <= 0) {
            System.out.println("Número de dias deve ser maior que zero.");
            return 0.0;
        }

        double valorTotal = precoPorNoite * dias;
        System.out.println("Valor da estadia para o quarto " + numero + ":");
        System.out.println("Preço por noite: R$ " + String.format("%.2f", precoPorNoite));
        System.out.println("Número de dias: " + dias);
        System.out.println("Valor total: R$ " + String.format("%.2f", valorTotal));

        return valorTotal;
    }

    public void exibirInfo() {
        System.out.println("=== QUARTO " + numero + " ===");
        System.out.println("Tipo: " + tipo);
        System.out.println("Preço por noite: R$ " + String.format("%.2f", precoPorNoite));
        System.out.println("Status: " + (estaOcupado ? "Ocupado" : "Disponível"));
        System.out.println("==================\n");
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isEstaOcupado() {
        return estaOcupado;
    }

    public void setEstaOcupado(boolean estaOcupado) {
        this.estaOcupado = estaOcupado;
    }

    public double getPrecoPorNoite() {
        return precoPorNoite;
    }

    public void setPrecoPorNoite(double precoPorNoite) {
        this.precoPorNoite = precoPorNoite;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
