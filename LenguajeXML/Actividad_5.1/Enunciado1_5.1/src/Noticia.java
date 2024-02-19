import java.util.ArrayList;

public class Noticia {

    //clase con los atributos, cada atributo es un nodo del xml noticia

    private String titulo;
    private String categoria;
    private String descripcion;
    private String autor;
    private ArrayList<String> ficherosAdjuntos;

    public Noticia (String titulo, String categoria, String descripcion, String autor){
        this.titulo = titulo;
        this.categoria = categoria;
        this.descripcion=descripcion;
        this.autor = autor;

        this.ficherosAdjuntos = new ArrayList<>();
    }

    public void addFicheroAdjuto (String ficheroAdjunto){
        this.ficherosAdjuntos.add(ficheroAdjunto);
    }
    public void mostrarFicherosAdjuntos (){

        for (String ficheroAdjunto: this.ficherosAdjuntos){
            System.out.println(ficheroAdjunto);
        }
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + ", Categoria: " + categoria;
    }
}
