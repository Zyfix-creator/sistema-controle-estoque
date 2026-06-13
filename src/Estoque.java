import java.util.ArrayList;

public class Estoque {
    private ArrayList<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        if (buscarProduto(produto.getCodigo()) != null) {
            System.out.println("Erro: já existe um produto com esse código.");
            return;
        }

        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    public Produto buscarProduto(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    public void removerProduto(int codigo) {
        Produto produto = buscarProduto(codigo);

        if (produto != null) {
            produtos.remove(produto);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void atualizarQuantidade(int codigo, int novaQuantidade) {
        Produto produto = buscarProduto(codigo);

        if (produto != null) {
            produto.setQuantidade(novaQuantidade);
            System.out.println("Quantidade atualizada com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void entradaEstoque(int codigo, int quantidadeEntrada) {
        Produto produto = buscarProduto(codigo);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        if (quantidadeEntrada <= 0) {
            System.out.println("A quantidade de entrada deve ser maior que zero.");
            return;
        }

        produto.setQuantidade(produto.getQuantidade() + quantidadeEntrada);
        System.out.println("Entrada registrada com sucesso!");
    }

    public void saidaEstoque(int codigo, int quantidadeSaida) {
        Produto produto = buscarProduto(codigo);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        if (quantidadeSaida <= 0) {
            System.out.println("A quantidade de saída deve ser maior que zero.");
            return;
        }

        if (quantidadeSaida > produto.getQuantidade()) {
            System.out.println("Erro: estoque insuficiente.");
            return;
        }

        produto.setQuantidade(produto.getQuantidade() - quantidadeSaida);
        System.out.println("Saída registrada com sucesso!");
    }

    public void calcularValorTotalEstoque() {
        double total = 0;

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (Produto produto : produtos) {
            double valorProduto = produto.getQuantidade() * produto.getPreco();
            total += valorProduto;

            System.out.println(produto.getNome() + ": " +
                    produto.getQuantidade() + " x R$ " +
                    produto.getPreco() + " = R$ " + valorProduto);
        }

        System.out.println("Valor total em estoque: R$ " + total);
    }
}