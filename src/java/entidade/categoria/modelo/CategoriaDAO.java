package entidade.categoria.modelo;

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
public class CategoriaDAO {
    
    public ArrayList<Categoria> recuperarTodas(int id){
        ArrayList<Categoria> categorias = new ArrayList<Categoria>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Livraria_Orleanz","postgres","05121316");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, descricao FROM categoria");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Categoria c = new Categoria();
                c.setId(resultSet.getInt("id"));
                c.setDescricao(resultSet.getString("descricao"));
                categorias.add(c);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            return null;
        }
        return categorias;
    }
}
