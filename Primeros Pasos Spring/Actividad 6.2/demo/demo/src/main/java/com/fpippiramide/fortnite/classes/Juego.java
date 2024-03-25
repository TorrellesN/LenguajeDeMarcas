package com.fpippiramide.fortnite.classes;

public class Juego {
    private String nombre;
    private String numero_jugadores;
    private String imagen;

    public Juego (String nombre, String numero_jugadores, String imagen){
        this.nombre = nombre;
        this.imagen = imagen;
        this.numero_jugadores = numero_jugadores;
    }

    public String getNombre (){
        return this.nombre;
    }
    public String getNumero_jugadores(){
        return this.numero_jugadores;
    }
    public String getImagen(){
        return this.imagen;
    }

}
