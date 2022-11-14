package com.company;

public class iOS {
    private String version;
    private String nombreOS;

    public iOS(){
        version = "";
        nombreOS = "";
    }

    public String getVersion(){
        return version;
    }
    public String getNombreOS(){
        return nombreOS;
    }
    public void setVersion(String version){
        this.version = version;
    }
    public void setNombreOS(String nombreOS){
        this.nombreOS = nombreOS;
    }

    public String obtenerInfo(){
        return "Versión: "+version+"\n"+"Nombre OS: "+nombreOS;
    }
}
