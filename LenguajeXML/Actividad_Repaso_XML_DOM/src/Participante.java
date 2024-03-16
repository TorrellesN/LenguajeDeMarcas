public class Participante {
    private int id;
    private String nombre;
    private String apellido;
    private Equipo equipo;

    public Participante (int id, String nombre, String apellido, Equipo equipo){

        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.equipo = equipo;
    }
}
