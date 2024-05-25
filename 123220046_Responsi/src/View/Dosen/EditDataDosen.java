package View.Dosen;

import Controller.ControllerDosen;
import Model.Dosen.ModelDosen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EditDataDosen extends JFrame {
    
    ControllerDosen controller;
    
    JLabel header = new JLabel("Input Dosen");
    JLabel labelInputNama = new JLabel("Nama");
    JLabel labelInputNoHp = new JLabel("No Hp");
    JLabel labelInputEmail = new JLabel("Email");
    JTextField inputNama = new JTextField();
    JTextField inputNoHp = new JTextField();
    JTextField inputEmail = new JTextField();
    JButton tombolEdit = new JButton("Edit Dosen");
    JButton tombolKembali = new JButton("Kembali");

    public EditDataDosen(ModelDosen Dosen) {
        setTitle("Edit Dosen");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(680, 440);
        setLocationRelativeTo(null);
        setLayout(null);
        
       add(header);
        add(labelInputNama);
        add(labelInputNoHp);
        add(inputNama);
        add(inputNoHp);
         add(tombolEdit);
        add(tombolKembali);
        add(labelInputEmail);
        add(inputEmail);

         header.setBounds(20, 8, 440, 24);
        labelInputNama.setBounds(20, 32, 440, 24);
        inputNama.setBounds(18, 56, 440, 36);
        labelInputNoHp.setBounds(20, 96, 440, 24);
        inputNoHp.setBounds(18, 120, 440, 36);
        labelInputEmail.setBounds(20, 160, 440, 24);
        inputEmail.setBounds(18, 184, 440, 36);
        tombolKembali.setBounds(20, 340, 215, 40);
        tombolEdit.setBounds(240, 340, 215, 40);
        
        inputNama.setText(Dosen.getNama());
        inputNoHp.setText(Dosen.getNoHp());
        inputEmail.setText(Dosen.getEmail());  
  

        controller = new ControllerDosen(this);
       
        
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewDataDosen();
            }
        });

        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               controller.editDosen(Dosen.getId());
            }
        });
    }

    public String getInputNama() {
        return inputNama.getText();
    }

    public String getInputNoHp() {
        return inputNoHp.getText();
    }
    


    public String getInputEmail() {
        return inputEmail.getText();
    }
    
    
    
}
