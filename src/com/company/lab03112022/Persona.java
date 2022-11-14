package com.company.lab03112022;

public abstract class Persona {
    private int id, edad;
    private String nombreCompleto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Persona(){
        id = 0;
        edad = 0;
        nombreCompleto = "";
    }

    public Persona(int id, String nombreCompleto, int edad){
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
    }

    public Persona(String nombreCompleto, int edad){
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
    }

    public abstract void obtenerInfo();
}
