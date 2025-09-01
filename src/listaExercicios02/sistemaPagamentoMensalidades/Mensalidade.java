package listaExercicios02.sistemaPagamentoMensalidades;

public class Mensalidade {
    private String aluno;
    private double valor;
    private String dataVencimento;
    private boolean estaPago;

    public Mensalidade(String aluno, double valor, String dataVencimento) {
        this.aluno = aluno;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.estaPago = false;
    }

    public boolean pagar() {
        if (estaPago) {
            System.out.println("Mensalidade de " + aluno + " já foi paga!");
            return false;
        }

        estaPago = true;
        System.out.println("Pagamento registrado com sucesso!");
        System.out.println("Aluno: " + aluno);
        System.out.println("Valor: R$ " + String.format("%.2f", valor));

        return true;
    }

    public boolean verificarAtraso(String dataAtual) {
        if (estaPago) {
            System.out.println("Mensalidade de " + aluno + " está paga. Sem atraso.");
            return false;
        }

        boolean emAtraso = compararDatas(dataAtual, dataVencimento);

        if (emAtraso) {
            System.out.println("Mensalidade de " + aluno + " está em ATRASO!");
            System.out.println("Vencimento: " + dataVencimento + " | Data atual: " + dataAtual);
        } else {
            System.out.println("Mensalidade de " + aluno + " está em dia.");
        }

        return emAtraso;
    }

    public void exibirStatus() {
        System.out.println("=== STATUS DA MENSALIDADE ===");
        System.out.println("Aluno: " + aluno);
        System.out.println("Valor: R$ " + String.format("%.2f", valor));
        System.out.println("Data de vencimento: " + dataVencimento);
        System.out.println("Status: " + (estaPago ? "PAGO" : "PENDENTE"));
        System.out.println("=============================\n");
    }

    private boolean compararDatas(String dataAtual, String dataVencimento) {
        try {
            String[] atual = dataAtual.split("/");
            String[] vencimento = dataVencimento.split("/");

            int diaAtual = Integer.parseInt(atual[0]);
            int mesAtual = Integer.parseInt(atual[1]);
            int anoAtual = Integer.parseInt(atual[2]);

            int diaVenc = Integer.parseInt(vencimento[0]);
            int mesVenc = Integer.parseInt(vencimento[1]);
            int anoVenc = Integer.parseInt(vencimento[2]);

            if (anoAtual > anoVenc) return true;
            if (anoAtual < anoVenc) return false;
            if (mesAtual > mesVenc) return true;
            if (mesAtual < mesVenc) return false;
            return diaAtual > diaVenc;

        } catch (Exception e) {
            return false;
        }
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public boolean isEstaPago() {
        return estaPago;
    }

    public void setEstaPago(boolean estaPago) {
        this.estaPago = estaPago;
    }
}
