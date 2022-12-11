package com.company.Database;

import com.company.Models.*;

import java.util.ArrayList;
import java.util.LinkedList;

public class DbStorage {

    public static LinkedList<Tarea> Tareas = new LinkedList<>();
    public static LinkedList<Categoria> Categorias = new LinkedList<>();
    public static LinkedList<Propietario> Propietarios = new LinkedList<>();

    /**
     * Agregar tarea a la Base de Datos
     *
     * @param nuevaTarea
     */
    public static void agregarTarea(Tarea nuevaTarea) {
        if (nuevaTarea != null && !Tareas.contains(nuevaTarea)) {
            Tareas.add(nuevaTarea);
        }
    }

    /**
     * Se crea un arreglo de objetos que contendra la informacion de cada columna
     * para luego agregarlo a la tabla debido a su naturaleza.
     *
     * @param tarea
     * @return
     */
    public static Object[] tareaAMostrar(Tarea tarea) {
        String completado;
        if (tarea.isCompletado()) {
            completado = "Completado";
        } else {
            completado = "No completado";
        }

        return new Object[]{
                tarea.getId(), tarea.getTitulo(), tarea.getDescripcion(),
                tarea.getCategoria().getDescripcion(), tarea.getPropietario().getNombre(),
                completado, tarea.getFechaInicio(), tarea.getFechaFinal()
        };
    }

    /**
     * Agregar propietario a la base de datos
     *
     * @param nuevoProp
     */
    public static void agregarPropietario(Propietario nuevoProp) {
        // Punto 16
        if (nuevoProp != null && !Propietarios.contains(nuevoProp)) {
            Propietarios.add(nuevoProp);
        }
    }

    /**
     * Agregar categoria a la base de datos
     *
     * @param nuevaCategoria
     */
    public static void agregarCategoria(Categoria nuevaCategoria) {
        // Punto 16
        if (nuevaCategoria != null && !Categorias.contains(nuevaCategoria)) {
            Categorias.add(nuevaCategoria);
        }
    }

    /**
     * Editar tarea de la base de datos
     *
     * @param tareaEditada
     */
    public static void editarTarea(Tarea tareaEditada) {
        if (tareaEditada != null) {
            Tareas.set(Tareas.indexOf(tareaEditada), tareaEditada);
        }
    }

    /**
     * Editar categoria de la base de datos
     *
     * @param categoria
     */
    public static void editarCategoria(Categoria categoria) {
        if (categoria != null) {
            Categorias.set(Categorias.indexOf(categoria), categoria);
        }
    }

    /**
     * Remover tarea de la base de datos
     *
     * @param fila
     */
    public static void removerTarea(int fila) {
        if (!Tareas.isEmpty()) {
            // Debe haber almenos 1 en la lista, simulando el valor por "Default"
            if(Tareas.size() <= 1){
                return;
            }
            Tareas.remove(fila);
        }
    }

    /**
     * Remover categoría de la base de datos
     *
     * @param fila
     */
    public static void removerCategoria(int fila) {
        if (!Categorias.isEmpty()) {
            // Debe haber almenos 1 en la lista, simulando el valor por "Default"
            if(Categorias.size() <= 1){
                return;
            }
            Categoria cat = obtenerCategoria(fila);
            Categorias.remove(fila);
            reasignarTareasPorCategoria(cat);
        }
    }

    /**
     * Remover propietario de la base de datos
     *
     * @param fila
     */
    public static void removerPropietario(int fila) {
        if (!Propietarios.isEmpty()) {
            // Debe haber almenos 1 en la lista, simulando el valor por "Default"
            if(Propietarios.size() <= 1){
                return;
            }
            Propietario prop = obtenerPropietario(fila);
            Propietarios.remove(fila);
            reasignarTareasPorPropietario(prop);
        }
    }

    /**
     * Obtener tarea por su index en la base de datos
     *
     * @param fila
     * @return Tarea encontrada; de lo contrario nulo
     */
    public static Tarea obtenerTarea(int fila) {
        if (!Tareas.isEmpty()) {
            return Tareas.get(fila);
        }
        return null;
    }

    /**
     * Obtener propietario por su nombre en la base de datos
     *
     * @param propNombre
     * @return Propietario encontrada; de lo contrario nulo
     */
    public static Propietario obtenerPropietario(String propNombre) {
        if (!propNombre.isEmpty() && !Propietarios.isEmpty()) {
            for (Propietario prop : Propietarios) {
                if (prop.getNombre().equals(propNombre)) {
                    return prop;
                }
            }
        }
        return null;
    }

    /**
     * Obtener propietario por su index en la base de datos
     *
     * @param fila
     * @return Propietario encontrado; de lo contrario nulo
     */
    public static Propietario obtenerPropietario(int fila) {
        if (!Propietarios.isEmpty()) {
            return Propietarios.get(fila);
        }
        return null;
    }

    /**
     * Obtener categoria por su descripcion en la base de datos
     *
     * @param catDescripcion
     * @return Categoria encontrada; de lo contrario nulo
     */
    public static Categoria obtenerCategoria(String catDescripcion) {
        if (!catDescripcion.isEmpty() && !Categorias.isEmpty()) {
            for (Categoria cat : Categorias) {
                if (catDescripcion.equalsIgnoreCase(cat.getDescripcion())) {
                    return cat;
                }
            }
        }
        return null;
    }

    /**
     * Obtener categoria por su index en la base de datos
     *
     * @param fila
     * @return Categoria encontrada; de lo contrario nulo
     */
    public static Categoria obtenerCategoria(int fila) {
        if (!Categorias.isEmpty()) {
            return Categorias.get(fila);
        }
        return null;
    }

    public static void reasignarTareasPorCategoria(Categoria cat){
        if(cat != null){
            for (Tarea tar:Tareas) {
                if(tar.getCategoria().equals(cat)){
                    tar.setCategoria(Categorias.getFirst());
                    Tareas.set(Tareas.indexOf(tar), tar);
                }
            }
        }
    }

    public static void reasignarTareasPorPropietario(Propietario prop){
        if(prop != null){
            for (Tarea tar:Tareas) {
                if(tar.getPropietario().equals(prop)){
                    tar.setPropietario(Propietarios.getFirst());
                    Tareas.set(Tareas.indexOf(tar), tar);
                }
            }
        }
    }
}
