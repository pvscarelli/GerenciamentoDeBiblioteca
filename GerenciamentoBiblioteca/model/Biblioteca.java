package GerenciamentoBiblioteca.model;

import java.time.LocalDate;
import java.util.LinkedList;

public class Biblioteca {

    private LinkedList<Livro> livros = new LinkedList<>();
    private LinkedList<Emprestimo> emprestimos = new LinkedList<>();

    public LinkedList<Livro> getLivros() {
        return livros;
    }

    public LinkedList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void adicionarLivro(Livro livro) {
        livro.setCodigo(livros.size() + 1);
        livros.add(livro);
    }

    public void realizarEmprestimo(Livro livro, LocalDate dataEmprestimo, LocalDate dataDevolucaoPrevista) {

        if (livro.isDisponivel()) {
            livro.setDisponivel(false);
            Emprestimo emprestimo = new Emprestimo(livro, dataEmprestimo, dataDevolucaoPrevista);
            emprestimos.add(emprestimo);
            System.out.println("Empréstimo realizado com sucesso!");
        } else {
            System.out.println("Livro não está disponível para empréstimo.");
        }
    }

    public void realizarDevolucao(Emprestimo emprestimo) {
        Livro livroDevolvido = emprestimo.getLivro();
        livroDevolvido.setDisponivel(true);
        emprestimos.remove(emprestimo);
        System.out.println("Devolução realizada com sucesso!");
    }

    public void mostrarLivrosDisponiveis() {
        System.out.println("Livros Disponíveis:\n");
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                System.out.println("Código: " + livro.getCodigo() + ", Título: " + livro.getTitulo());
            }
        }

        System.out.println("\nLivros Indisponíveis:\n");
        for (Livro livro : livros) {
            if (!livro.isDisponivel()) {
                System.out.println("Código: " + livro.getCodigo() + ", Título: " + livro.getTitulo());
            }
        }
    }
}
