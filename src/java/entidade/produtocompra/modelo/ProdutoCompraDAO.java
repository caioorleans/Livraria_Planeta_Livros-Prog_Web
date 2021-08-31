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
import java.sql.SQLException;

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
}
