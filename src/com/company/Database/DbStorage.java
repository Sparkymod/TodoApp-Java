package com.company.Database;

import com.company.Models.*;

import java.util.LinkedList;

public class DbStorage {

    public static LinkedList<Tarea> Tareas = new LinkedList<>();
    public static LinkedList<Categoria> Categorias = new LinkedList<>();
    public static LinkedList<Propietario> Propietarios = new LinkedList<>();
    public static LinkedList<Tarea> TareasCompletadas = new LinkedList<>();

    public static void agregarTarea(Tarea nuevaTarea) {
        if (nuevaTarea != null) {
            Tareas.add(nuevaTarea);
        }
    }

    public static void agregarPropietario(Propietario nuevaPropietario) {
        if (nuevaPropietario != null) {
            Propietarios.add(nuevaPropietario);
        }
    }

    public static void agregarCategoria(Categoria nuevaCategoria) {
        if (nuevaCategoria != null) {
            Categorias.add(nuevaCategoria);
        }
    }

    public static void removerTarea(int fila) {
        Tareas.remove(fila);
    }

    public static Tarea obtenerTarea(String tareaNombre) {
        if (!tareaNombre.isEmpty()) {
            for (Tarea tarea : Tareas) {
                if (tareaNombre.equalsIgnoreCase(tarea.getTitulo())) {
                    return tarea;
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    public static Propietario obtenerPropietario(String propNombre) {
        if (!propNombre.isEmpty()) {
            for (Propietario prop : Propietarios) {
                if (propNombre.equalsIgnoreCase(prop.getNombre())) {
                    return prop;
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    public static Categoria obtenerCategoria(String catNombre) {
        if (!catNombre.isEmpty()) {
            for (Categoria cat : Categorias) {
                if (catNombre.equalsIgnoreCase(cat.getDescripcion())) {
                    return cat;
                } else {
                    return null;
                }
            }
        }
        return null;
    }
}
