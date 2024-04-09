package com.fpippiramide.fortnite.classes;

public class Idioma {

    private String codigo;
    private String nombre;

    public Idioma (){
    }
    public void setNombre (String nombre){
        this.nombre = nombre;
    }
    public void setCodigo (String codigo){
        this.codigo = codigo;
    }
    public String getNombre (){
        return this.nombre;
    }
    public String getCodigo (){
        return this.codigo;
    }
}
