package com.company.Models;

import java.util.List;

public class Categoria {
    private int Id;
    private String Descripcion;
    private List<Tarea> Tareas;

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
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
        Tareas = tareas;
    }
}
