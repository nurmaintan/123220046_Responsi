/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.Mahasiswa;

import java.util.List;

public interface InterfaceDAOMahasiswa {
    public void insert(ModelMahasiswa Mahasiswa);
    
    public void update(ModelMahasiswa Mahasiswa);
    
    public void delete(int id);
    
    public List<ModelMahasiswa> getAll();
}

