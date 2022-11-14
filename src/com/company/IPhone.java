package com.company;

public class IPhone extends Dispositivo {
    private Boolean faceCam;
    private Integer cantidadCamaras;
    private iOS sistemaOperativo;

    public IPhone(){
        faceCam = false;
        cantidadCamaras = 0;
        sistemaOperativo = new iOS();
    }

    @Override
    public void encender() {
        System.out.println("Dispositivo se ha encendido!");
    }

    @Override
    public void apagar() {
        System.out.println("Dispositivo se ha apagado!");
    }

    public Boolean getFaceCam() {
        return faceCam;
    }

    public void setFaceCam(Boolean faceCam) {
        this.faceCam = faceCam;
    }

    public Integer getCantidadCamaras() {
        return cantidadCamaras;
    }

    public void setCantidadCamaras(Integer cantidadCamaras) {
        this.cantidadCamaras = cantidadCamaras;
    }

    public iOS getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(iOS sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    @Override
    public String obtenerInfo(){
        String info = "FaceCam: " + faceCam + "\n" + "Cantidad de Cámaras: "+cantidadCamaras +"\n";
        info += sistemaOperativo.obtenerInfo() +"\n";
        info += "Color: " + obtenerColor();
        return info;
    }
}

