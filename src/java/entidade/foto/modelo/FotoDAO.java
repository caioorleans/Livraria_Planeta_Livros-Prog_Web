package entidade.foto.modelo;

import CredenciaisSGBD.Credenciais;
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
public class FotoDAO {
    
    public Foto recuperarFotoCapa(int id){
        Foto capa = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(Credenciais.getURL(),Credenciais.getUSUARIO(),Credenciais.getSENHA());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, descricao, endereco FROM foto WHERE id_produto = ? AND eh_capa = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.setBoolean(2, true);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                capa = new Foto();
                capa.setId(resultSet.getInt("id"));
                capa.setDescricao(resultSet.getString("descricao"));
                capa.setEndereco(resultSet.getString("endereco"));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            return null;
        }
        return capa;
    }
    
    public ArrayList<Foto> recuperarDemaisFotos(int id){
        ArrayList<Foto> fotos = new ArrayList<Foto>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(Credenciais.getURL(),Credenciais.getUSUARIO(),Credenciais.getSENHA());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, descricao, endereco FROM foto WHERE id_produto = ? AND eh_capa = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.setBoolean(2, false);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Foto f = new Foto();
                f.setId(resultSet.getInt("id"));
                f.setDescricao(resultSet.getString("descricao"));
                f.setEndereco(resultSet.getString("endereco"));
                fotos.add(f);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            return null;
        }
        return fotos;
    }
    
    public boolean inserirFoto(){
        boolean sucesso = false;
        return sucesso;
    }
}
