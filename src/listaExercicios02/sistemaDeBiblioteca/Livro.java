package listaExercicios02.sistemaDeBiblioteca;

public class Livro {

    private String titulo;

    private String autor;

    private int ano;

    private int isbn;

    private boolean disponivel;

    public Livro(String titulo, String autor, int ano, int isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.isbn = isbn;
        this.disponivel = true;
    }

    public boolean emprestar() {
        if(disponivel) {
            disponivel = false;
            System.out.println("Livro '" + titulo + "' emprestado com sucesso!");

            return true;
        } else {
            System.out.println("Livro '" + titulo + "' não está disponível para empréstimo.");
            return false;
        }
    }

    public boolean devolver() {
        if(!disponivel) {
            disponivel = true;
            System.out.println("Livro '" + titulo + "' devolvido com sucesso!");
            return true;
        } else {
            System.out.println("Livro '" + titulo + "' já está disponível na biblioteca.");
            return false;
        }
    }

    public void exibirInformacoes() {
        System.out.println("=== INFORMAÇÕES DO LIVRO ===");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Ano de Publicação: " + ano);
        System.out.println("ISBN: " + isbn);
        System.out.println("Disponibilidade: " + (disponivel ? "Disponível" : "Emprestado"));
        System.out.println("============================");
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
