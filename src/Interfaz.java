import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Interfaz extends JFrame implements ActionListener {
    JButton botonAñadir;
    JButton botonVerContactos;

    ImageIcon fondo = new ImageIcon("portada.png");
    JLabel soporteImagen = new JLabel();

    void Interfaz(){


        this.setSize(700, 500);
       // this.getContentPane().setBackground(Color.gray);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("iagenda");

        botonAñadir = new JButton();
        botonAñadir.setText("Añadir contactos");
        botonAñadir.setBounds(250, 250, 200, 40);
        botonAñadir.setFocusable(false);
        botonAñadir.addActionListener(this);
        this.add(botonAñadir);

        botonVerContactos = new JButton();
        botonVerContactos.setText("Ver contactos");
        botonVerContactos.setBounds(250, 300, 200, 40);
        botonVerContactos.setFocusable(false);
        botonVerContactos.addActionListener(this);
        this.add(botonVerContactos);

        soporteImagen.setBounds(0,0,700,500);
        soporteImagen.setIcon(fondo);
        this.add(soporteImagen);


        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonAñadir) {
            this.dispose();
            firstTimeStart testPath =new firstTimeStart();
            try {
                testPath.newContact();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == botonVerContactos) {
            this.dispose();
        }
    }
}
