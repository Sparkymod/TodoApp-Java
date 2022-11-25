package com.company.Models;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private int Id;
    private String Descripcion;
    private List<Tarea> Tareas;

    /**
     * Este valor simula que es generado en base de datos para obtener
     * un ID diferente cada vez que una tarea nueva es construida
     **/
    public static int DbId = 0;

    public Categoria() {
        DbId++;
        Id = DbId;
        Descripcion = "Na";
        Tareas = new ArrayList<>();
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion.isEmpty() ? "Na" : descripcion;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public List<Tarea> getTareas() {
        return Tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        Tareas = tareas != null ? tareas : new ArrayList<>();
    }
}
