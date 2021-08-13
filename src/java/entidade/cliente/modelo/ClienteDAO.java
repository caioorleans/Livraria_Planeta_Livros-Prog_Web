package entidade.cliente.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caioo
 */
public class ClienteDAO {
    
    public Cliente obter(String login){
        Cliente c = null;
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Livraria_Orleanz","postgres","05121316");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, nome, endereco, login, senha, email FROM cliente WHERE login = ?;");
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                c = new Cliente();
                c.setId(resultSet.getInt("id"));
                c.setNome(resultSet.getString("nome"));
                c.setLogin(resultSet.getString("login"));
                c.setEmail(resultSet.getString("email"));
                c.setSenha(resultSet.getString("senha"));
                c.setEndereco(resultSet.getString("endereco"));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }catch(ClassNotFoundException ex){
            return null;
        } catch (SQLException ex) {
            return null;
        }
        return c;
    }
    
    public void inserir(Cliente c) throws Exception {
        boolean sucesso = false;
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Livraria_Orleanz","postgres","05121316");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cliente(nome, endereco, login, senha, email) VALUES (?, ?, ?, ?, ?);");
            preparedStatement.setString(1, c.getNome());
            preparedStatement.setString(2, c.getEndereco());
            preparedStatement.setString(3, c.getLogin());
            preparedStatement.setString(4, c.getSenha());
            preparedStatement.setString(5, c.getEmail());
            sucesso = (preparedStatement.executeUpdate() == 1);
            preparedStatement.close();
            connection.close();
        }catch(ClassNotFoundException ex){
            throw new Exception(ex.getMessage());
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    public boolean efetuarLogin(String login, String senha){
        boolean sucesso = false;
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Livraria_Orleanz","postgres","05121316");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, nome, endereco, login, senha, email FROM cliente WHERE login = ? AND senha = ?;");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, senha);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                sucesso = true;
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }catch(ClassNotFoundException ex){
            return false;
        } catch (SQLException ex) {
            return false;
        }
        return sucesso;
    }
    
    public boolean atualizar(Cliente c){
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Livraria_Orleanz","postgres","05121316");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE cliente SET nome=?, endereco=?, login=?, senha=?, email=? WHERE id=?;");
            preparedStatement.setString(1, c.getNome());
            preparedStatement.setString(2, c.getEndereco());
            preparedStatement.setString(3, c.getLogin());
            preparedStatement.setString(4, c.getSenha());
            preparedStatement.setString(5, c.getEmail());
            preparedStatement.setInt(6, c.getId());
            if(preparedStatement.executeUpdate() != 0){
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
    
    public boolean deletar(int id){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Livraria_Orleanz","postgres","05121316");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM cliente WHERE id = ?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            return false;
        } catch (SQLException ex) {
            return true;
        }
        return true;
    }
}
