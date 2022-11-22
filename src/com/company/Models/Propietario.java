package com.company.Models;

import java.util.Date;

public class Propietario extends Autor{
    private Date FechaCreacion;
    private boolean Activo;

    public Propietario(){
        FechaCreacion = new Date();
        Activo = true;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean activo) {
        Activo = activo;
    }
}
