import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque();

        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE CONTROLE DE ESTOQUE ===");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Buscar produto");
            System.out.println("4 - Atualizar quantidade");
            System.out.println("5 - Remover produto");
            System.out.println("6 - Entrada de estoque");
            System.out.println("7 - Saída de estoque");
            System.out.println("8 - Valor total do estoque");
            System.out.println("9 - Listar produtos com estoque baixo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Código: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();

                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();

                    Produto produto = new Produto(codigo, nome, quantidade, preco);
                    estoque.adicionarProduto(produto);
                    break;

                case 2:
                    estoque.listarProdutos();
                    break;

                case 3:
                    System.out.print("Código do produto: ");
                    int codigoBusca = scanner.nextInt();

                    Produto produtoEncontrado = estoque.buscarProduto(codigoBusca);

                    if (produtoEncontrado != null) {
                        System.out.println(produtoEncontrado);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Código do produto: ");
                    int codigoAtualizar = scanner.nextInt();

                    System.out.print("Nova quantidade: ");
                    int novaQuantidade = scanner.nextInt();

                    estoque.atualizarQuantidade(codigoAtualizar, novaQuantidade);
                    break;

                case 5:
                    System.out.print("Código do produto: ");
                    int codigoRemover = scanner.nextInt();

                    estoque.removerProduto(codigoRemover);
                    break;

                case 6:
                    System.out.print("Código do produto: ");
                    int codigoEntrada = scanner.nextInt();

                    System.out.print("Quantidade de entrada: ");
                    int quantidadeEntrada = scanner.nextInt();

                    estoque.entradaEstoque(codigoEntrada, quantidadeEntrada);
                    break;

                case 7:
                    System.out.print("Código do produto: ");
                    int codigoSaida = scanner.nextInt();

                    System.out.print("Quantidade de saída: ");
                    int quantidadeSaida = scanner.nextInt();

                    estoque.saidaEstoque(codigoSaida, quantidadeSaida);
                    break;

                case 8:
                    estoque.calcularValorTotalEstoque();
                    break;

                case 9:
                    estoque.listarProdutosEstoqueBaixo();
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}