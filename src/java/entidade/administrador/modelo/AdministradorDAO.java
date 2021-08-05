package entidade.administrador.modelo;

import static java.lang.Class.forName;
import static java.lang.System.console;
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
public class AdministradorDAO {
    
    public boolean efetuarLogin(String login, String senha){
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Livraria_Orleanz","postgres","05121316");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, nome, login, senha, email FROM administrador WHERE login = ? AND senha = ?;");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, senha);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                sucesso = true;
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            return false;
        } catch (SQLException ex) {
            return false;
        }
        return sucesso;
    }
    
    public boolean atualizar(Administrador a){
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Livraria_Orleanz","postgres","05121316");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE administrador SET nome=?, login=?, senha=?, email=? WHERE id=?;");
            preparedStatement.setString(1, a.getNome());
            preparedStatement.setString(2, a.getLogin());
            preparedStatement.setString(3, a.getSenha());
            preparedStatement.setString(4, a.getEmail());
            preparedStatement.setInt(5, a.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                sucesso = true;
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            return false;
        } catch (SQLException ex) {
            return false;
        }
        return sucesso;
    }
    
    public Administrador obter(String login){
        Administrador adm = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Livraria_Orleanz","postgres","05121316");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, nome, login, senha, email FROM administrador WHERE login = ?;");
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                adm = new Administrador();
                adm.setId(resultSet.getInt("id"));
                adm.setNome(resultSet.getString("nome"));
                adm.setLogin(resultSet.getString("login"));
                adm.setEmail(resultSet.getString("email"));
                adm.setSenha(resultSet.getString("senha"));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            return null;
        }
        return adm;
    }
    
    public boolean deletar(int id){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Livraria_Orleanz","postgres","05121316");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM administrador WHERE id = ?;");
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
