package View.Mahasiswa;

import Controller.ControllerMahasiswa;
import Model.Mahasiswa.ModelMahasiswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EditDataMahasiswa extends JFrame {
    
    ControllerMahasiswa controller;
    
    JLabel header = new JLabel("Edit Mahasiswa");
    JLabel labelInputNama = new JLabel("Nama");
    JLabel labelInputNIM = new JLabel("NIM");
    JLabel labelInputEmail = new JLabel("Email");
    JLabel labelInputAngkatan = new JLabel("Angkatan");
    JLabel labelInputPassword = new JLabel("Password");
    JTextField inputNama = new JTextField();
    JTextField inputNIM = new JTextField();
    JTextField inputAngkatan = new JTextField();
    JTextField inputEmail = new JTextField();
    JTextField inputPassword = new JTextField();
    JButton tombolEdit = new JButton("Edit Mahasiswa");
    JButton tombolKembali = new JButton("Kembali");

    public EditDataMahasiswa(ModelMahasiswa Mahasiswa) {
        setTitle("Edit Mahasiswa");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(680, 440);
        setLocationRelativeTo(null);
        setLayout(null);

        add(header);
        add(labelInputNama);
        add(labelInputNIM);
        add(labelInputAngkatan);
        add(inputNama);
        add(inputNIM);
        add(inputAngkatan);
        add(tombolEdit);
        add(tombolKembali);
        add(labelInputEmail);
        add(inputEmail);
        add(labelInputPassword);
        add(inputPassword);

        header.setBounds(20, 8, 440, 24);
        labelInputNama.setBounds(20, 32, 440, 24);
        inputNama.setBounds(18, 56, 440, 36);
        labelInputNIM.setBounds(20, 96, 440, 24);
        inputNIM.setBounds(18, 120, 440, 36);
        labelInputEmail.setBounds(20, 160, 440, 24);
        inputEmail.setBounds(18, 184, 440, 36);
        labelInputPassword.setBounds(20, 224, 440, 24);
        inputPassword.setBounds(18, 248, 440, 36);
        labelInputAngkatan.setBounds(20, 288, 440, 24);
        inputAngkatan.setBounds(18, 312, 440, 36);
        tombolKembali.setBounds(20, 340, 215, 40);
        tombolEdit.setBounds(240, 340, 215, 40);
        
        inputNama.setText(Mahasiswa.getNama());
        inputNIM.setText(Mahasiswa.getNIM());
        inputEmail.setText(Mahasiswa.getEmail());  
        inputPassword.setText(Mahasiswa.getPassword());  
        inputAngkatan.setText(Mahasiswa.getAngkatan());

        controller = new ControllerMahasiswa(this);
       
        
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewDataMahasiswa();
            }
        });

        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               controller.editMahasiswa(Mahasiswa.getId());
            }
        });
    }

    public String getInputNama() {
        return inputNama.getText();
    }

    public String getInputNIM() {
        return inputNIM.getText();
    }
    
    public String getInputAngkatan() {
        return inputAngkatan.getText();
    }

    public String getInputEmail() {
        return inputEmail.getText();
    }
    
    
     public String getInputPassword() {
        return inputPassword.getText();
    }

    
    
}
