package es.iescanarias.tito.cristo.model;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class GestorFichero {

        private static final String NOMBRE_FICHERO = "rectangulo.csv";

        private static final String SEPARADOR = ";";


        public void guardar(Rectangulo r) throws IOException {

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_FICHERO, false))) {


                String escribirRect = "" + r.getBase() + SEPARADOR + r.getAltura();

                bw.write(escribirRect);
                bw.newLine();
            }
        }

        public Rectangulo leer() throws IOException {


            ArrayList<String> lineas = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(NOMBRE_FICHERO))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    // Ignoramos las líneas en blanco
                    if (!linea.trim().isEmpty()) {
                        lineas.add(linea);
                    }
                }
            }


            if (lineas.isEmpty()) {
                throw new IOException("El fichero '" + NOMBRE_FICHERO + "' está vacío.");
            }


            String[] campos = lineas.get(0).split(SEPARADOR);

            if (campos.length != 2) {
                throw new IllegalArgumentException(
                        "Formato incorrecto: se esperaba 'base;altura' y se encontró '" + lineas.get(0) + "'.");
            }


            try {
                int base = Integer.parseInt(campos[0].trim());
                int altura = Integer.parseInt(campos[1].trim());


                return new Rectangulo(base, altura);

            } catch (NumberFormatException e) {

                throw new IllegalArgumentException(
                        "La base y la altura deben ser números enteros: '" + lineas.get(0) + "'.", e);
            }
        }
    }



