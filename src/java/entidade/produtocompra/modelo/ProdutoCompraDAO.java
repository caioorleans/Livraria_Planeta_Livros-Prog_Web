/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.produtocompra.modelo;

import CredenciaisSGBD.Credenciais;
import entidade.produto.modelo.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author caioo
 */
public class ProdutoCompraDAO {
    public boolean inserir(int idCompra,Produto p, int quantidade){
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(Credenciais.getURL(), Credenciais.getUSUARIO(), Credenciais.getSENHA());
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO compra_produto(id_compra, quantidade, id_produto) VALUES(?,?,?);");
            preparedStatement.setInt(1, idCompra);
            preparedStatement.setInt(2, quantidade);
            preparedStatement.setInt(3,p.getId());
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
    
    public ArrayList<Produto> recuperarPorCompra(int idCompra){
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(Credenciais.getURL(), Credenciais.getUSUARIO(), Credenciais.getSENHA());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT p.id, p.descricao, p.preco, p.imagem, cp.quantidade FROM produto AS p, compra_produto as cp WHERE cp.id_compra = ? AND cp.id_produto = p.id;");
            preparedStatement.setInt(1, idCompra);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Produto p = new Produto();
                p.setId(resultSet.getInt("id"));
                p.setDescricao(resultSet.getString("descricao"));
                p.setPreco(resultSet.getDouble("preco"));
                p.setFoto(resultSet.getString("imagem"));
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
}
