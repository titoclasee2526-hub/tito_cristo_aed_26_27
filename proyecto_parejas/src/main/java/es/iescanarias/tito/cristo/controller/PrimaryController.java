package es.iescanarias.tito.cristo.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;




public class PrimaryController {

   
    @FXML
    private Button btnLeer;

    @FXML
    private Button btnguardar;

    @FXML
    private TextArea txtArea;

    @FXML
    void guardar(ActionEvent event) {

        String textos[] = {"en ", "un ", "lugar ", "de ", "la ", "Mancha"};

        ArrayList<String> listaTextos = new ArrayList<>(Arrays.asList(textos));

        Path path = Paths.get("fichero.txt");
        try (BufferedWriter bw = Files.newBufferedWriter(path,
                StandardOpenOption.APPEND,
                StandardOpenOption.CREATE
        )) {
            for( String linea: listaTextos){
                bw.write(linea);
                bw.newLine();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void leer(ActionEvent event) {

        String fileName = "fichero.txt";
        ArrayList<String> list = null;
        try (
                BufferedReader br  = Files.newBufferedReader(Paths.get(fileName))
        ) {
            String linea ="";
            while ( ( linea = br.readLine () ) != null ) {
                //System.out.println(linea);
                list.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 

    }
    }

