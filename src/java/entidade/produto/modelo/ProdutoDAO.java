package entidade.produto.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caioo
 */
public class ProdutoDAO {

    public ArrayList<Produto> recuperarPorCategoria(int idCategoria) {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Livraria_Orleanz", "postgres", "05121316");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT p.id, p.descricao, p.preco, p.quantidade, pc.id_categoria, pc.id_produto From produto AS p, produto_categoria AS pc Where pc.id_categoria = ? AND pc.id_produto = p.id");
            preparedStatement.setInt(1, idCategoria);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Produto p = new Produto();
                p.setId(resultSet.getInt("p.id"));
                p.setDescricao(resultSet.getString("p.descricao"));
                p.setPreco(resultSet.getDouble("p.preco"));
                p.setQuantidade(resultSet.getInt("p.quantidade"));
                produtos.add(p);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            return null;
        }
        return produtos;
    }

    public Produto recuperar(int id) {
        Produto p = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Livraria_Orleanz", "postgres", "05121316");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, descricao, preco, quantidade, imagem FROM produto WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                p = new Produto();
                p.setId(resultSet.getInt("id"));
                p.setDescricao(resultSet.getString("descricao"));
                p.setPreco(resultSet.getDouble("preco"));
                p.setQuantidade(resultSet.getInt("quantidade"));
                p.setFoto(resultSet.getString("imagem"));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            return null;
        }
        return p;
    }

    public ArrayList<Produto> recuperarPorNome(String descricao) {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Livraria_Orleanz", "postgres", "05121316");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, descricao, preco, quantidade FROM produto WHERE id LIKE %?%");
            preparedStatement.setString(1, descricao);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Produto p = new Produto();
                p.setId(resultSet.getInt("id"));
                p.setDescricao(resultSet.getString("descricao"));
                p.setPreco(resultSet.getDouble("preco"));
                p.setQuantidade(resultSet.getInt("quantidade"));
                produtos.add(p);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            return null;
        }
        return produtos;
    }

    public ArrayList<Produto> recuperarProdutosEmEstoque() {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Livraria_Orleanz", "postgres", "05121316");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, descricao, preco, quantidade, imagem FROM produto WHERE quantidade > 0");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Produto p = new Produto();
                p.setId(resultSet.getInt("id"));
                p.setDescricao(resultSet.getString("descricao"));
                p.setPreco(resultSet.getDouble("preco"));
                p.setQuantidade(resultSet.getInt("quantidade"));
                p.setFoto(resultSet.getString("imagem"));
                produtos.add(p);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            return null;
        }
        return produtos;
    }

    public ArrayList<Produto> recuperarTodos() {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Livraria_Orleanz", "postgres", "05121316");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, descricao, preco, quantidade, imagem FROM produto");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Produto p = new Produto();
                p.setId(resultSet.getInt("id"));
                p.setDescricao(resultSet.getString("descricao"));
                p.setPreco(resultSet.getDouble("preco"));
                p.setQuantidade(resultSet.getInt("quantidade"));
                p.setFoto(resultSet.getString("imagem"));
                produtos.add(p);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            return null;
        }
        return produtos;
    }

    public boolean inserir(Produto p) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Livraria_Orleanz", "postgres", "05121316");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO produto(descricao, preco, quantidade) VALUES(?,?,?);");
            preparedStatement.setString(1, p.getDescricao());
            preparedStatement.setDouble(2, p.getPreco());
            preparedStatement.setInt(3, p.getQuantidade());
            if (preparedStatement.executeUpdate() == 1) {
                sucesso = true;
            }
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            return false;
        } catch (SQLException ex) {
            return false;
        }
        return sucesso;
    }

    public int recuperarUltimoId() {
        int id = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Livraria_Orleanz", "postgres", "05121316");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT MAX(id) FROM produto;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                id = resultSet.getInt(1);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            return 0;
        } catch (SQLException ex) {
            return 0;
        }
        return id;
    }

    public boolean atualizar(Produto p) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Livraria_Orleanz", "postgres", "05121316");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE produto SET descricao=?, preco=?, quantidade=? WHERE id=?");
            preparedStatement.setString(1, p.getDescricao());
            preparedStatement.setDouble(2, p.getPreco());
            preparedStatement.setInt(3, p.getQuantidade());
            preparedStatement.setInt(4, p.getId());
            if (preparedStatement.executeUpdate() == 1) {
                sucesso = true;
            }
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            return false;
        } catch (SQLException ex) {
            return false;
        }
        return sucesso;
    }
    
    public void atualizarFoto(int id, String caminhoFoto) throws Exception {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Livraria_Orleanz", "postgres", "05121316");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE produto SET imagem = ? WHERE id = ?");
            preparedStatement.setString(1, caminhoFoto);
            preparedStatement.setInt(2, id);
            sucesso = (preparedStatement.executeUpdate() == 1);
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
