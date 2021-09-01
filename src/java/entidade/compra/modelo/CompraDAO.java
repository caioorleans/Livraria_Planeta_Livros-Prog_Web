/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.compra.modelo;

import CredenciaisSGBD.Credenciais;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author caioo
 */
public class CompraDAO {
    
    public boolean inserir(int idCliente, Timestamp data){
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(Credenciais.getURL(), Credenciais.getUSUARIO(), Credenciais.getSENHA());
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO compra(id_cliente, data_hora) VALUES(?,?);");
            preparedStatement.setInt(1, idCliente);
            preparedStatement.setTimestamp(2, data);
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
            Connection connection = DriverManager.getConnection(Credenciais.getURL(), Credenciais.getUSUARIO(), Credenciais.getSENHA());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT MAX(id) FROM compra;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
    
    public ArrayList<Compra> recuperarCompras(int idCliente) {
        ArrayList<Compra> compras = new ArrayList<Compra>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(Credenciais.getURL(), Credenciais.getUSUARIO(), Credenciais.getSENHA());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, data_hora FROM compra WHERE id_cliente = ?;");
            preparedStatement.setInt(1, idCliente);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Compra c = new Compra();
                c.setId(resultSet.getInt("id"));
                c.setDataHora(resultSet.getTimestamp("data_hora"));
                compras.add(c);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            return null;
        }
        return compras;
    }
    
}
