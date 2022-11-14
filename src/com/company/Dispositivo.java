package com.company;

public abstract class Dispositivo {
    private String color;

    public Dispositivo(){
        color = "";
    }

    public String obtenerColor() {
        return color;
    }

    public void asignarColor(String color){
        this.color = color;
    }

    public abstract void encender();

    public abstract void apagar();

    public abstract String obtenerInfo();
}


