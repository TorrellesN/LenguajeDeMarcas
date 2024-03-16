package Enunciado1;

public class Libro {
    private String titulo;
    private String autor;
    private String genero;
    private String anio;

    public Libro (String titulo, String autor , String genero, String anio){
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.genero = genero;
    }

    public String getTitulo (){
        return titulo;
    }
    public String getAutor (){
        return autor;
    }
    public String getGenero (){
        return genero;
    }
    public String getAnio (){
        return anio;
    }

}
