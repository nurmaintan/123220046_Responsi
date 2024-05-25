/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Dosen.ModelDosen;
import Model.Dosen.ModelTableDosen;
import View.Dosen.EditDataDosen;
import View.Dosen.ViewDataDosen;
import java.util.List;
import javax.swing.JOptionPane;
import Model.Dosen.InterfaceDAODosen;
import View.Dosen.InputDataDosen;


public class ControllerDosen {

    InputDataDosen inputdos;
    EditDataDosen editdos;
    ViewDataDosen viewdos;

    InterfaceDAODosen daoDosen;

    List<ModelDosen> daftarDosen;

    public ControllerDosen(InputDataDosen inputdos) {
        this.inputdos = inputdos;
        this.daoDosen = new Model.Dosen.DAODosen();
    }

    public ControllerDosen(EditDataDosen editdos) {
        this.editdos = editdos;
        this.daoDosen = new Model.Dosen.DAODosen();
    }

    public ControllerDosen(ViewDataDosen viewdos) {
        this.viewdos = viewdos;
        this.daoDosen = new Model.Dosen.DAODosen();
    }

    public void showAllDosen() {
        daftarDosen = daoDosen.getAll();

        ModelTableDosen table = new ModelTableDosen(daftarDosen);
        
        viewdos.getTable().setModel(table);
    }

    public void insertDosen() {
        try {
            ModelDosen inputDosen = new ModelDosen();

            String nama = inputdos.getInputNama();
            String NoHp = inputdos.getInputNoHp();
            String Email = inputdos.getInputEmail();


            if ("".equals(nama) || "".equals(NoHp)|| "".equals(Email) ) {
                throw new Exception("Nama, No HP, Email tidak boleh kosong!");
            }

            inputDosen.setNama(nama);
            inputDosen.setNoHp(NoHp);
            inputDosen.setEmail(Email);

            daoDosen.insert(inputDosen);

            JOptionPane.showMessageDialog(null, "Data Dosen telah ditambahkan");

            inputdos.dispose();
            new ViewDataDosen();
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }

    public void editDosen(int id) {
        try {
            ModelDosen editDosen = new ModelDosen();

           String nama = inputdos.getInputNama();
            String NoHp = inputdos.getInputNoHp();
            String Email = inputdos.getInputEmail();
 

            if ("".equals(nama) || "".equals(NoHp) || "".equals(Email)  ) {
                throw new Exception("Nama, No Hp, Email!");
            }

            editDosen.setId(id);
            editDosen.setNama(nama);
            editDosen.setNoHp(NoHp);
            editDosen.setEmail(Email);
 

            daoDosen.update(editDosen);

            JOptionPane.showMessageDialog(null, "Data Dosen Berhasil diedit");

            editdos.dispose();
            new ViewDataDosen();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void deleteDosen(Integer baris) {
        Integer id = (int) viewdos.getTable().getValueAt(baris, 0);
        String nama = viewdos.getTable().getValueAt(baris, 1).toString();

        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + nama + "?",
                "Hapus Dosen",
                JOptionPane.YES_NO_OPTION
        );

        if (input == 0) {
            daoDosen.delete(id);

            JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");

            showAllDosen();
        }
    }

}
