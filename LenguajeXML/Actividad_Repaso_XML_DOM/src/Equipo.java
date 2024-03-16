import java.util.ArrayList;

public class Equipo {
    public ArrayList<Herramienta> listaHerramientas;
    private String categoriaEquipo;

    public Equipo (String categoriaEquipo){
        this.categoriaEquipo = categoriaEquipo;
        listaHerramientas = new ArrayList<>();
    }
}
