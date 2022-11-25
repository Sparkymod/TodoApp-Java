package com.company;

import com.company.Database.DbStorage;
import com.company.Models.Categoria;
import com.company.Models.Propietario;

import java.util.Calendar;

public class App {
    public static void main(String[] args) {
        // Simular el cargado de base de datos
        inyectarCategorias();
        inyectarPropietarios();

        TodoApp todo = new TodoApp();
        todo.crearApp();
    }

    private static void inyectarCategorias(){
        var categoria1 = new Categoria();
        categoria1.setDescripcion("Trabajo");
        DbStorage.agregarCategoria(categoria1);

        var categoria2 = new Categoria();
        categoria2.setDescripcion("Casa");
        DbStorage.agregarCategoria(categoria2);

        var categoria3 = new Categoria();
        categoria3.setDescripcion("Universidad");
        DbStorage.agregarCategoria(categoria3);

        var categoria4 = new Categoria();
        categoria4.setDescripcion("Otros");
        DbStorage.agregarCategoria(categoria4);
    }

    private static void inyectarPropietarios(){
        var propietario1 = new Propietario();
        propietario1.setNombre("Nelson Mandela");
        propietario1.setActivo(true);
        propietario1.getFechaCreacion(Calendar.getInstance().getTime());
        DbStorage.agregarPropietario(propietario1);

        var propietario2 = new Propietario();
        propietario2.setNombre("Nichardson");
        propietario2.setActivo(true);
        propietario2.getFechaCreacion(Calendar.getInstance().getTime());
        DbStorage.agregarPropietario(propietario2);
    }
}
