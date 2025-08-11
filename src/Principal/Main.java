package principal;

import entidades.*;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criando cadastros
        CadastrarAtores cadastroAtores = new CadastrarAtores();
        CadastrarDiretores cadastroDiretores = new CadastrarDiretores();
        CadastrarFilmes cadastroFilmes = new CadastrarFilmes();

        // Criando diretores
        Diretor d1 = new Diretor("Christopher Nolan", LocalDate.of(1970, 7, 30),
                "Diretor britânico conhecido por filmes complexos.", "Reino Unido");
        cadastroDiretores.adicionar(d1);

        Diretor d2 = new Diretor("Greta Gerwig", LocalDate.of(1983, 8, 4),
                "Diretora e roteirista americana.", "Estados Unidos");
        cadastroDiretores.adicionar(d2);

        // Criando atores
        Ator a1 = new Ator("Leonardo DiCaprio", LocalDate.of(1974,11,11),
                "Ator americano premiado.", "A Origem, O Regresso");
        Ator a2 = new Ator("Ellen Page", LocalDate.of(1987,2,21),
                "Ator canadense.");
        Ator a3 = new Ator("Saoirse Ronan", LocalDate.of(1994,4,12),
                "Atriz irlandesa.");

        cadastroAtores.adicionar(a1);
        cadastroAtores.adicionar(a2);
        cadastroAtores.adicionar(a3);

        // Criando filmes
        Filme f1 = new Filme("A Origem", d1, 2010, "Sci-Fi / Ação");
        f1.adicionarAtor(a1);

        Filme f2 = new Filme("Lady Bird", d2, 2017, "Drama / Comédia");
        f2.adicionarAtor(a3);

        cadastroFilmes.adicionar(f1);
        cadastroFilmes.adicionar(f2);

        // Exibindo catálogo
        System.out.println("=== DIRETORES ===");
        for (Diretor d : cadastroDiretores.listarTodos()) {
            System.out.println(d);
        }

        System.out.println("\n=== ATORES ===");
        for (Ator a : cadastroAtores.listarTodos()) {
            System.out.println(a);
        }

        System.out.println("\n=== FILMES ===");
        for (Filme f : cadastroFilmes.listarTodos()) {
            System.out.println(f);
            System.out.println("---------------------");
        }

        // Exemplos de busca
        System.out.println("\nBuscando filme por título 'A Origem':");
        cadastroFilmes.buscarPorTitulo("A Origem").ifPresent(System.out::println);
    }
}
