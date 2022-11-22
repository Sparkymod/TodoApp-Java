package com.company.Models;

public class Autor {
    private int Id;
    private String Nombre;

    public Autor(){
        Nombre = "Na";
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre.isEmpty() ? "Na" : nombre;
    }
}
