package GerenciamentoBiblioteca.view;

import GerenciamentoBiblioteca.model.*;
import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Livro Essencialismo = new Livro("Greg McKeown", "Essencialismo", 2014, true);
        Livro CodigoLimpo = new Livro("Robert C. Martin", "Código Limpo", 2009, true);
        biblioteca.adicionarLivro(CodigoLimpo);
        biblioteca.adicionarLivro(Essencialismo);

        biblioteca.mostrarLivrosDisponiveis();

        LocalDate dataEmprestimo = LocalDate.now();
        LocalDate dataDevolucaoPrevista = dataEmprestimo.plusDays(14);

        biblioteca.realizarEmprestimo(Essencialismo, dataEmprestimo, dataDevolucaoPrevista);

        biblioteca.mostrarLivrosDisponiveis();

        Emprestimo emprestimo = biblioteca.getEmprestimos().get(0);
        biblioteca.realizarDevolucao(emprestimo);

        biblioteca.mostrarLivrosDisponiveis();

    }
}
