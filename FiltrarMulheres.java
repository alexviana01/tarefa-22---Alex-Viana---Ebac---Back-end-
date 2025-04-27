


import java.util.*;
import java.util.stream.*;
import java.io.*;

public class FiltrarMulheres {
    static class Pessoa {
        private String nome;
        private String genero;

        public Pessoa(String nome, String genero) {
            this.nome = nome;
            this.genero = genero;
        }

        public String getNome() {
            return nome;
        }

        public String getGenero() {
            return genero;
        }

        @Override
        public String toString() {
            return nome + ", " + genero;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite as pessoas no formato Nome,Genero separadas por ponto e vírgula:");
        String entrada = scanner.nextLine(); 
        // Exemplo de entrada: Ana,Feminino;João,Masculino;Maria,Feminino;Pedro,Masculino

        List<Pessoa> listaPessoas = Arrays.stream(entrada.split(";"))
            .map(item -> item.split(","))
            .filter(arr -> arr.length == 2) // Garante que não dá erro se vier incompleto
            .map(arr -> new Pessoa(arr[0].trim(), arr[1].trim()))
            .collect(Collectors.toList());

        // Filtrar apenas as mulheres usando lambda e streams
        List<Pessoa> mulheres = listaPessoas.stream()
            .filter(p -> p.getGenero().equalsIgnoreCase("Feminino"))
            .collect(Collectors.toList());

        System.out.println("\nLista de Mulheres:");
        mulheres.forEach(m -> System.out.println(m.getNome()));
    }
}