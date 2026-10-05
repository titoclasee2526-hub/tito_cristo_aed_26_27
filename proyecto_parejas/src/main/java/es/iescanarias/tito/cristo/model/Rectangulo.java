package es.iescanarias.tito.cristo.model;

public class Rectangulo {
 
    private int base;
    private int altura;

    public Rectangulo(int base, int altura) {
        this.altura = altura;
        this.base = base;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String calcularArea(){
        return "El area es:" + base * altura;
    }

    
}
