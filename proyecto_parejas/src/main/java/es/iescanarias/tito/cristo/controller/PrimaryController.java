package es.iescanarias.tito.cristo.controller;

import java.io.IOException;

import es.iescanarias.tito.cristo.model.GestorFichero;
import es.iescanarias.tito.cristo.model.Rectangulo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private Button btnLeer;

    @FXML
    private Button btnguardar;

    @FXML
    private TextField txtAltura;

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtBase;

    private final GestorFichero gestorFichero = new GestorFichero();

    @FXML
    void guardar(ActionEvent event) throws IOException {

        int base = Integer.parseInt(txtBase.getText().trim());
        int altura = Integer.parseInt(txtAltura.getText().trim());

        Rectangulo r = new Rectangulo(base, altura);
        gestorFichero.guardar(r);
        txtArea.setText(r.calcularArea() + "\nGuardado correctamente");

    }

    @FXML
    void leer(ActionEvent event) throws IOException {
        Rectangulo r = gestorFichero.leer();
        txtBase.setText(String.valueOf(r.getBase()));
        txtAltura.setText(String.valueOf(r.getAltura()));
        txtArea.setText(r.calcularArea());

    }
}
