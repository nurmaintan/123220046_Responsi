/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dosen;

import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DAODosen implements InterfaceDAODosen {
     @Override
    public void insert(ModelDosen Dosen) {
        try {
            String query = "INSERT INTO Dosen (nama, no_hp, email) VALUES (?, ?, ?);";
            
            PreparedStatement statement;
            statement = Connector.Koneksi().prepareStatement(query);
            statement.setString(1, Dosen.getNama());
            statement.setString(2, Dosen.getNoHp());
            statement.setString(3, Dosen.getEmail());
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Input Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void update(ModelDosen Dosen) {
        try {
            String query = "UPDATE Dosen SET nama=?, no_hp=?, email =? where id=?;";
            
            PreparedStatement statement;
            statement = Connector.Koneksi().prepareStatement(query);
            statement.setString(1, Dosen.getNama());
            statement.setString(2, Dosen.getNoHp());
            statement.setString(3, Dosen.getEmail());
            statement.setInt(4, Dosen.getId());
 
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("update Failed! (" + e.getMessage() + ")");
        }
    }

    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM Dosen WHERE id=?;";
            
            PreparedStatement statement;
            statement = Connector.Koneksi().prepareStatement(query);
            statement.setInt(1, id);
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Delete Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<ModelDosen> getAll() {
        List<ModelDosen> listDosen = null;
            try {
            listDosen = new ArrayList<>();
            
            Statement statement = Connector.Koneksi().createStatement();
            
            String query = "SELECT * FROM Dosen;";
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
              
                ModelDosen dos = new ModelDosen();
                
                dos.setId(resultSet.getInt("id"));
                 dos.setNama(resultSet.getString("nama"));
                dos.setNoHp(resultSet.getString("no_hp"));
                dos.setEmail(resultSet.getString("email"));

                
    
                listDosen.add(dos);
            }
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listDosen;
    }
}
