package com.company.Models;

public class Autor {
    private int Id;
    private String Nombre;

    /**
     * Este valor simula que es generado en base de datos para obtener
     * un ID diferente cada vez que una tarea nueva es construida
     **/
    public static int DbId = 0;

    public Autor() {
        DbId++;
        Id = DbId;
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
