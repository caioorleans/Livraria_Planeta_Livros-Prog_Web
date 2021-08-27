package entidade.categoriaproduto.modelo;

import CredenciaisSGBD.Credenciais;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author caioo
 */
public class CategoriaProdutoDAO {

    public boolean inserir(int produtoId, int categoriaId) throws SQLException {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(Credenciais.getURL(), Credenciais.getUSUARIO(), Credenciais.getSENHA());
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO categoria_produto(id_produto, id_categoria) VALUES (?, ?)");
            preparedStatement.setInt(1, produtoId);
            preparedStatement.setInt(2, categoriaId);
            sucesso = (preparedStatement.executeUpdate() == 1);
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            return false;
        }
        return sucesso;
    }

    public boolean excluir(int produtoId, int categoriaId) throws SQLException {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(Credenciais.getURL(), Credenciais.getUSUARIO(), Credenciais.getSENHA());;
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM categoria_produto WHERE id_produto = ? AND id_categoria = ?");
            preparedStatement.setInt(1, produtoId);
            preparedStatement.setInt(2, categoriaId);
            sucesso = (preparedStatement.executeUpdate() == 1);
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoriaProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sucesso;
    }
    
    public boolean excluir(int produtoId) throws SQLException {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(Credenciais.getURL(), Credenciais.getUSUARIO(), Credenciais.getSENHA());;
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM categoria_produto WHERE id_produto = ?");
            preparedStatement.setInt(1, produtoId);
            sucesso = (preparedStatement.executeUpdate() == 1);
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoriaProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sucesso;
    }
    
    public boolean excluirPorCategoria(int categoriaId) throws SQLException {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(Credenciais.getURL(), Credenciais.getUSUARIO(), Credenciais.getSENHA());;
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM categoria_produto WHERE id_categoria = ?");
            preparedStatement.setInt(1, categoriaId);
            sucesso = (preparedStatement.executeUpdate() == 1);
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoriaProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sucesso;
    }
}
