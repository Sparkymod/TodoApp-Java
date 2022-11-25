package com.company.Models;

import java.util.Calendar;
import java.util.Date;

public class Tarea {
    private int Id;
    private String Titulo;
    private String Descripcion;
    private boolean Completado;
    private Date FechaInicio;
    private Date FechaFinal;
    private Propietario Propietario;
    private Categoria Categoria;

    /**
     * Este valor simula que es generado en base de datos para obtener
     * un ID diferente cada vez que una tarea nueva es construida
     **/
    public static int DbId = 0;

    public Tarea() {
        DbId++;
        Id = DbId;
        Titulo = "Na";
        Descripcion = "Na";
        Completado = false;
        FechaInicio = Calendar.getInstance().getTime();
        FechaFinal = Calendar.getInstance().getTime();
        Propietario = new Propietario();
        Categoria = new Categoria();
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo.isEmpty() ? "Na" : titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion.isEmpty() ? "Na" : descripcion;
    }

    public boolean isCompletado() {
        return Completado;
    }

    public void setCompletado(boolean completado) {
        Completado = completado;
    }

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        FechaInicio = fechaInicio != null ? fechaInicio : Calendar.getInstance().getTime();
    }

    public Date getFechaFinal() {
        return FechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        FechaFinal = fechaFinal != null ? fechaFinal : Calendar.getInstance().getTime();
    }

    public Propietario getPropietario() {
        return Propietario;
    }

    public void setPropietario(Propietario propietario) {
        Propietario = propietario != null ? propietario : new Propietario();
    }

    public Categoria getCategoria() {
        return Categoria;
    }

    public void setCategoria(Categoria categoria) {
        Categoria = categoria != null ? categoria : new Categoria();
    }
}
