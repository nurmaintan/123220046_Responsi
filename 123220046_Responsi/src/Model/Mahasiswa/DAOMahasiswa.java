/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Mahasiswa;

import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DAOMahasiswa implements InterfaceDAOMahasiswa {
     @Override
    public void insert(ModelMahasiswa Mahasiswa) {
        try {
            String query = "INSERT INTO mahasiswa (nama, nim, email, password, angkatan) VALUES (?, ?, ?, ?, ?);";
            
            PreparedStatement statement;
            statement = Connector.Koneksi().prepareStatement(query);
            statement.setString(1, Mahasiswa.getNama());
            statement.setString(2, Mahasiswa.getNIM());
            statement.setString(3, Mahasiswa.getEmail());
            statement.setString(4, Mahasiswa.getPassword());
            statement.setString(5, Mahasiswa.getAngkatan());
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Input Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void update(ModelMahasiswa Mahasiswa) {
        try {
            String query = "UPDATE mahasiswa SET nama=?, nim=?, email =?, password=? angkatan=? WHERE id=?;";
            
            PreparedStatement statement;
            statement = Connector.Koneksi().prepareStatement(query);
            statement.setString(1, Mahasiswa.getNama());
            statement.setString(2, Mahasiswa.getNIM());
            statement.setString(3, Mahasiswa.getEmail());
            statement.setString(4, Mahasiswa.getPassword());
            statement.setString(5, Mahasiswa.getAngkatan());
            statement.setInt(6, Mahasiswa.getId());
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("update Failed! (" + e.getMessage() + ")");
        }
    }

    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM mahasiswa WHERE id=?;";
            
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
    public List<ModelMahasiswa> getAll() {
        List<ModelMahasiswa> listMahasiswa = null;
            try {
            listMahasiswa = new ArrayList<>();
            
            Statement statement = Connector.Koneksi().createStatement();
            
            String query = "SELECT * FROM mahasiswa;";
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
              
                ModelMahasiswa mhs = new ModelMahasiswa();
                
                mhs.setId(resultSet.getInt("id"));
                mhs.setNama(resultSet.getString("nama"));
                mhs.setNIM(resultSet.getString("nim"));
                mhs.setEmail(resultSet.getString("email"));
                mhs.setPassword(resultSet.getString("password"));
                mhs.setAngkatan(resultSet.getString("angkatan"));
                
    
                listMahasiswa.add(mhs);
            }
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listMahasiswa;
    }
}
