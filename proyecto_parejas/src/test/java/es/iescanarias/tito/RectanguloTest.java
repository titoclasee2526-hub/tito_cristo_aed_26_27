package es.iescanarias.tito;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iescanarias.tito.cristo.model.Rectangulo;

class RectanguloTest {

    private Rectangulo r;

    @BeforeEach
    void setUp() {
        r = new Rectangulo(5, 3);
    }

    @Test
    void constructorAsignaBaseYAltura() {
        assertEquals(5, r.getBase());
        assertEquals(3, r.getAltura());
    }

    @Test
    void setBaseCambiaLaBase() {
        r.setBase(10);
        assertEquals(10, r.getBase());
    }

    @Test
    void setAlturaCambiaLaAltura() {
        r.setAltura(7);
        assertEquals(7, r.getAltura());
    }

    @Test
    void calcularAreaDevuelveElTextoCorrecto() {
        assertEquals("El area es: 15", r.calcularArea());
    }

    @Test
    void calcularAreaSeActualizaTrasCambiarValores() {
        r.setBase(10);
        r.setAltura(4);
        assertEquals("El area es: 40", r.calcularArea());
    }

    @Test
    void calcularAreaConCero() {
        Rectangulo cero = new Rectangulo(0, 8);
        assertEquals("El area es: 0", cero.calcularArea());
    }

    @Test
    void toStringDevuelveBaseYAlturaSeparadasPorPuntoYComa() {
        assertEquals("5;3", r.toString());
    }

    @Test
    void toStringNoIncluyeElArea() {
        assertFalse(r.toString().contains("area"));
        assertFalse(r.toString().contains("15"));
    }

    @Test
    void toStringSeActualizaTrasCambiarValores() {
        r.setBase(10);
        r.setAltura(4);
        assertEquals("10;4", r.toString());
    }

    @Test
    void toStringSePuedeSepararConSplit() {
        // Así lo usará Persona 2 al leer el CSV
        String[] partes = r.toString().split(";");
        assertEquals(2, partes.length);
        assertEquals(5, Integer.parseInt(partes[0]));
        assertEquals(3, Integer.parseInt(partes[1]));
    }
}
