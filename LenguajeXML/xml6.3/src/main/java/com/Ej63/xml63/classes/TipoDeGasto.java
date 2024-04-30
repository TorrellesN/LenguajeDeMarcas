package com.Ej63.xml63.classes;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tipode_gasto")
public class TipoDeGasto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    @OneToMany (mappedBy = "tipoDeGasto")
    private List<Gasto> gastos;

    public TipoDeGasto() {
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

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    @Override
    public String toString() {
        return "TipoDeGasto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", gastos=" + gastos +
                '}';
    }
}
