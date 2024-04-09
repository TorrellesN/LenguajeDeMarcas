package com.fpippiramide.fortnite.classes;

public class Idioma {
    private int codigo;
    private String nombre;

    public Idioma(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
