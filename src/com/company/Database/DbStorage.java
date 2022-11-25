package com.company.Database;

import com.company.Models.*;

import java.util.ArrayList;
import java.util.LinkedList;

public class DbStorage {

    public static LinkedList<Tarea> Tareas = new LinkedList<>();
    public static LinkedList<Categoria> Categorias = new LinkedList<>();
    public static LinkedList<Propietario> Propietarios = new LinkedList<>();
    public static LinkedList<Tarea> TareasCompletadas = new LinkedList<>();

    /**
     * Agregar tarea a la Base de Datos
     * @param nuevaTarea
     */
    public static void agregarTarea(Tarea nuevaTarea) {
        if (nuevaTarea != null && !Tareas.contains(nuevaTarea)) {
            Tareas.add(nuevaTarea);
        }
    }

    /**
     * Agregar propietario a la base de datos
     * @param nuevoProp
     */
    public static void agregarPropietario(Propietario nuevoProp) {
        if (nuevoProp != null && !Propietarios.contains(nuevoProp)) {
            Propietarios.add(nuevoProp);
        }
    }

    /**
     * Agregar categoria a la base de datos
     * @param nuevaCategoria
     */
    public static void agregarCategoria(Categoria nuevaCategoria) {
        if (nuevaCategoria != null && !Categorias.contains(nuevaCategoria)) {
            Categorias.add(nuevaCategoria);
        }
    }

    public static void editarTarea(Tarea tareaEditada){
        if (tareaEditada != null){
            Tareas.set(Tareas.indexOf(tareaEditada), tareaEditada);
        }
    }

    /**
     * Remover tarea de la base de datos
     * @param fila
     */
    public static void removerTarea(int fila) {
        if (!Tareas.isEmpty()) {
            Tareas.remove(fila);
        }
    }

    /**
     * Remover categoría de la base de datos
     * @param fila
     */
    public static void removerCategoria(int fila) {
        if (!Categorias.isEmpty()) {
            Categorias.remove(fila);
        }
    }

    /**
     * Remover propietario de la base de datos
     * @param fila
     */
    public static void removerPropietario(int fila) {
        if (!Propietarios.isEmpty()) {
            Propietarios.remove(fila);
        }
    }

    /**
     * Obtener tarea por su index en la base de datos
     * @param fila
     * @return Tarea encontrada; de lo contrario nulo
     */
    public static Tarea obtenerTarea(int fila) {
        if(!Tareas.isEmpty()){
            return Tareas.get(fila);
        }
        return null;
    }

    /**
     * Obtener propietario por su nombre en la base de datos
     * @param propNombre
     * @return Propietario encontrada; de lo contrario nulo
     */
    public static Propietario obtenerPropietario(String propNombre) {
        if (!propNombre.isEmpty() && !Propietarios.isEmpty()) {
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

    /**
     * Obtener categoria por su descripcion en la base de datos
     * @param catDescripcion
     * @return Categoria encontrada; de lo contrario nulo
     */
    public static Categoria obtenerCategoria(String catDescripcion) {
        if (!catDescripcion.isEmpty() && !Categorias.isEmpty()) {
            for (Categoria cat : Categorias) {
                if (catDescripcion.equalsIgnoreCase(cat.getDescripcion())) {
                    return cat;
                } else {
                    return null;
                }
            }
        }
        return null;
    }
}
