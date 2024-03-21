package com.cpifppiramide.noticias.Classes;

public class Noticia {
    private String titulo;
    private String descripcion;
    private String autor;
    private String fecha_publicacion;
    private String ruta_foto;

    public Noticia (String titulo, String descripcion, String autor, String fecha_publicacion, String ruta_foto){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.autor = autor;
        this.fecha_publicacion = fecha_publicacion;
        this.ruta_foto = ruta_foto;
    }

    public String getAutor() {
        return autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public String getRuta_foto() {
        return ruta_foto;
    }
}
