package com.Ej63.xml63.classes;

import jakarta.persistence.*;

@Entity
@Table(name = "gasto")
public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String precio;
    @ManyToOne
    @JoinColumn (name = "fk_tipo_de_gasto_id", nullable = false)
    private TipoDeGasto tipoDeGasto;

    @ManyToOne()
    @JoinColumn (name = "fk_profesor_id", nullable = false)
    private Profesor profesor;


    public Gasto() {
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public TipoDeGasto getTipoDeGasto() {
        return tipoDeGasto;
    }

    public void setTipoDeGasto(TipoDeGasto tipoDeGasto) {
        this.tipoDeGasto = tipoDeGasto;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Gasto{" +
                "id=" + id +
                ", precio='" + precio + '\'' +
                ", tipoDeGasto=" + tipoDeGasto +
                ", profesor=" + profesor +
                '}';
    }
}
