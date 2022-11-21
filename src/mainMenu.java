import javax.swing.JOptionPane;
import java.io.File;
import java.util.Scanner; 
public class mainMenu {
    
    String[] options ={"Agregar Contacto", "Buscar Contacto", "Borrar Contacto"};
    
    void secondStartUp(){
        JOptionPane.showOptionDialog(null, "Bienvenido A Tu Agenda", "Elige...", 0, JOptionPane.QUESTION_MESSAGE, null, options, "Agregar Contacto");
}
}
