import javax.swing.JOptionPane;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class firstTimeStart {
  String directoryName = "\\contacts";
  String path;
  final JFrame frame = new JFrame("Welcome To Your Agenda! Choose Directory!");
  final JFileChooser fc = new JFileChooser();
    String userhomedirectory = System.getProperty("user.home");
    String pathForContact;
   public void chooseDirectory(){
    
    fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    fc.setMultiSelectionEnabled(false);
    fc.setCurrentDirectory(new File("user.home"));

    JButton btn1 = new JButton("Browse");

    Container pane = frame.getContentPane();
    pane.setLayout(new GridLayout(1, 1, 10, 10));
    pane.add(btn1);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 400);
    frame.setLocationRelativeTo(null);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setResizable(false);


    frame.setVisible(true);
    btn1.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            fc.showDialog(frame, "Choose");
            File f = fc.getSelectedFile();
            String directoryPath = String.valueOf(f);
            System.out.println(directoryPath);
            System.out.println(directoryName);
            makefolder(directoryPath,directoryName);
            frame.dispose();
              try {
                configSaver(directoryPath, directoryName);
              } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
              }
            frame.dispose();
        }
    });
       System.out.println(pathForContact);
   }
   void configSaver(String directoryPath,String directoryName) throws IOException{
      try {

        FileWriter myWriter = new FileWriter(userhomedirectory+"\\config.properties");
        myWriter.write(directoryPath+directoryName);
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }

 void makefolder(String directoryPath, String directoryName){    
  
    File f1 = new File(directoryPath+directoryName);

    boolean bool = f1.mkdir();  
          if(bool){  
            JOptionPane.showMessageDialog(null, "Folder is created successfully");
            System.out.println("Folder is created successfully");  
          }else{  
            JOptionPane.showMessageDialog(null, "Not Successful");
            System.out.println("Error Found!");  
     
          }  
  
  }

            String firstName;
            String lastName;
            String phoneNumber;
            String address;
            String socialMedia;
            int type;
            String typeConverted;
            String contactFile;
        
            String[] contactTypes ={"Amigo", "Compañero", "Conocido"};
        
        
        void newContact() throws IOException {
            
            firstName =JOptionPane.showInputDialog(null, "Nombres");
            lastName = JOptionPane.showInputDialog(null, "Apellidos");
            phoneNumber =JOptionPane.showInputDialog(null, "Numero");
            address =JOptionPane.showInputDialog(null, "Ubicacion");
            type = JOptionPane.showOptionDialog(null, "Tipo De Contacto", "Elige...", 0, JOptionPane.QUESTION_MESSAGE, null, contactTypes, "Agregar Contacto");
            if (type==0){
                typeConverted = "Amigo";
            } else if (type==1){
                typeConverted = "Compañero";
            } else  {
                typeConverted= "Conocido";
            }
            //String configFilePath = "/Users/aaaronvelez/repos/AgendaDS1/AgendaProyectoFinalUno/src/config.properties";
            BufferedReader reader = new BufferedReader(new FileReader(userhomedirectory + "\\config.properties"));
            String pathForContact =reader.readLine();
            contactFile = pathForContact+"\\"+firstName+lastName+ ".txt";
            System.out.println(contactFile);
            System.out.println(type);

            try {
                File newContact = new File(contactFile);
                if (newContact.createNewFile()) {
                  System.out.println("File created: " + newContact.getName());
                } else {
                  System.out.println("File already exists.");
                }
              } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
              }
        
        //FileWriter myWriter = new FileWriter(contactFile);
              try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(contactFile));
                
                writer.write(firstName +" " + lastName);
                writer.newLine();
                writer.write(phoneNumber);
                writer.newLine();
                writer.write(address);
                writer.newLine();
                writer.write(typeConverted);
                writer.close();
                System.out.println("Successfully wrote to the file.");
              } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
              }
        }
}
    