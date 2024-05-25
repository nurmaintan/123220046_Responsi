/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Menu;

import View.Mahasiswa.ViewDataMahasiswa;
import View.Dosen.ViewDataDosen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.exit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Menu extends JFrame implements ActionListener{
    
    JLabel judul = new JLabel();
    JLabel judul2 = new JLabel("Silahkan pilih untuk melanjutkan");
    
    JButton pilihMahasiswa = new JButton("Mahasiswa");
    JButton pilihDosen = new JButton("Dosen");
    JButton pilihLogout = new JButton("Logout");
    public Menu(String username) {
        setVisible(true);
        setSize(480,520);
        setTitle("Halaman Utama");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        
        add(judul);
        judul.setText("Selamat Datang, " + username);
        judul.setBounds(50, 20, 500, 30);
        judul.setFont(judul.getFont().deriveFont(20f));
        
        add(judul2);
        judul2.setBounds(50, 40, 400, 30);
        
        add(pilihMahasiswa);
        pilihMahasiswa.setBounds(150, 100, 150, 30);
        pilihMahasiswa.addActionListener(this);
        
        add(pilihDosen);
        pilihDosen.setBounds(150, 150, 150, 30);
        pilihDosen.addActionListener(this);
        
        add(pilihLogout);
        pilihLogout.setBounds(150, 200, 150, 30);
        pilihLogout.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pilihMahasiswa){
            new ViewDataMahasiswa();
            this.dispose();
        }else if(e.getSource() == pilihDosen){
            new ViewDataDosen();
            this.dispose();
        }else if(e.getSource() == pilihLogout){
            exit(0);
        }
        
    }
    
}

