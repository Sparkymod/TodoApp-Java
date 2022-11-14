package com.company;

public class Tarea {
    public static void TareaIphone(){
        IPhone iPhoneX = new IPhone();
        iOS iOSinfo = new iOS();

        iOSinfo.setVersion("15.0.0");
        iOSinfo.setNombreOS("Boobalu");

        iPhoneX.setCantidadCamaras(2);
        iPhoneX.setFaceCam(true);
        iPhoneX.setSistemaOperativo(iOSinfo);
        iPhoneX.asignarColor("Azul");

        System.out.println(iPhoneX.obtenerInfo());
    }
}
