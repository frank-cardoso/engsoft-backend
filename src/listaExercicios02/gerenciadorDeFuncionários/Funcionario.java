package listaExercicios02.gerenciadorDeFuncionários;

public class Funcionario {

    private String nome;
    private String cargo;
    private double salario;
    private int matricula;
    private String departamento;

    public Funcionario(String nome, String cargo, double salario, int matricula, String departamento) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.matricula = matricula;
        this.departamento = departamento;
    }

    public void promover(String novoCargo, double aumento) {
        String cargoAnterior = this.cargo;
        double salarioAnterior = this.salario;

        this.cargo = novoCargo;
        this.salario += aumento;

        System.out.println("=== PROMOÇÃO REALIZADA ===");
        System.out.println("Funcionário: " + nome + " (Matrícula: " + matricula + ")");
        System.out.println("Cargo anterior: " + cargoAnterior + " → Novo cargo: " + cargo);
        System.out.println("Salário anterior: R$ " + String.format("%.2f", salarioAnterior) +
                " → Novo salário: R$ " + String.format("%.2f", salario));
        System.out.println("Aumento aplicado: R$ " + String.format("%.2f", aumento));
        System.out.println("Parabéns pela promoção!");
        System.out.println("========================\n");
    }

    public void transferir(String novoDepartamento) {
        String departamentoAnterior = this.departamento;

        this.departamento = novoDepartamento;

        System.out.println("=== TRANSFERÊNCIA REALIZADA ===");
        System.out.println("Funcionário: " + nome + " (Matrícula: " + matricula + ")");
        System.out.println("Cargo: " + cargo);
        System.out.println("Departamento anterior: " + departamentoAnterior +
                " → Novo departamento: " + departamento);
        System.out.println("Transferência efetuada com sucesso!");
        System.out.println("==============================\n");
    }

    public void exibirDados() {
        System.out.println("=== DADOS DO FUNCIONÁRIO ===");
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Cargo: " + cargo);
        System.out.println("Salário: R$ " + String.format("%.2f", salario));
        System.out.println("Departamento: " + departamento);
        System.out.println("===========================\n");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
