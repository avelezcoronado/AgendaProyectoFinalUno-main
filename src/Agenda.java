
import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Properties;

public class Agenda extends firstTimeStart {

    void runProgram() throws IOException {
        String userhomedirectory = System.getProperty("user.home");
        File file = new File(userhomedirectory+"\\config.properties");
        file.createNewFile();
        //file.mkdir();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            if (br.readLine() == null) {
                System.out.println("File is empty");
                chooseDirectory();


            } else {
                System.out.println("to main menu");
                Interfaz menu = new Interfaz();
                menu.Interfaz();

            }
        } catch (IOException e) {
            e.printStackTrace();

        }


    }

    public static void main(String[] args) throws IOException {


        Agenda test = new Agenda();
        test.runProgram();
    }
}
