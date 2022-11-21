package com.company.Models;

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
        Titulo = titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
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
        FechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return FechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        FechaFinal = fechaFinal;
    }

    public Propietario getPropietario() {
        return Propietario;
    }

    public void setPropietario(Propietario propietario) {
        Propietario = propietario;
    }

    public Categoria getCategoria() {
        return Categoria;
    }

    public void setCategoria(Categoria categoria) {
        Categoria = categoria;
    }
}
