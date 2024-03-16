package Enunciado5;

public class Perro {

    private String nombre;
    private int edad;
    private boolean vacunado;
    private float peso;
    private String colorDePelo;

    public Perro(String nombre, int edad, boolean vacunado, float peso, String colorDePelo){
        this.nombre = nombre;
        this.edad = edad;
        this.vacunado = vacunado;
        this.peso = peso;
        this.colorDePelo = colorDePelo;

    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " , Edad: " + edad + " , Vacunado: " + vacunado + " , Peso: " + peso + " , Color de pelo: " + colorDePelo;
    }
}
