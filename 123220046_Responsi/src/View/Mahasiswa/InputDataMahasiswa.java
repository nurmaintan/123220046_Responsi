package View.Mahasiswa;

import Controller.ControllerMahasiswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InputDataMahasiswa extends JFrame {
    
    ControllerMahasiswa controller;

    JLabel header = new JLabel("Input Mahasiswa");
    JLabel labelInputNama = new JLabel("Nama");
    JLabel labelInputNIM = new JLabel("NIM");
    JLabel labelInputAngkatan = new JLabel("Angkatan");
    JLabel labelInputEmail = new JLabel("Email");
    JLabel labelInputPassword = new JLabel("Email");
    JTextField inputNama = new JTextField();
    JTextField inputNIM = new JTextField();
    JTextField inputAngkatan = new JTextField();
    JTextField inputEmail = new JTextField();
       JTextField inputPassword = new JTextField();
    JButton tombolTambah = new JButton("Tambah Mahasiswa");
    JButton tombolKembali = new JButton("Kembali");

    public InputDataMahasiswa() {
        setTitle("Daftar Mahasiswa");
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
        add(tombolTambah);
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
        tombolTambah.setBounds(240, 340, 215, 40);
        
        controller = new ControllerMahasiswa(this);

        
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewDataMahasiswa();
            }
        });

        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              controller.insertMahasiswa();
            }
        });
    }


    public String getInputNIM() {
        return inputNIM.getText();
    }
    
    
    public String getInputAngkatan() {
        return inputAngkatan.getText();
    }

    public String getInputNama() {
            return inputNama.getText();
    }
    
    public String getInputEmail() {
        return inputEmail.getText();
    }
    
   
     
     public String getInputPassword() {
        return inputPassword.getText();
    }


    
    
}
