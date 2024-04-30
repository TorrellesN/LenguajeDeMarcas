package com.example.Ej62.classes;

import jakarta.persistence.*;

@Entity
@Table (name = "Video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int duracion;
    private String descripcion;
    @Column(name="numero_de_likes")
    private int numeroDeLikes;
    @ManyToOne
    @JoinColumn(name = "fk_cuenta_id", nullable = false)
    private Cuenta cuenta;

    public Video() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuración(int duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumeroDeLikes() {
        return numeroDeLikes;
    }

    public void setNumeroDeLikes(int numeroDeLikes) {
        this.numeroDeLikes = numeroDeLikes;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", duración=" + duracion +
                ", descripcion='" + descripcion + '\'' +
                ", numeroDeLikes=" + numeroDeLikes +
                ", cuenta=" + cuenta +
                '}';
    }
}
