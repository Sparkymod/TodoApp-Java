package com.company;

import javax.swing.*;
import java.awt.*;

public class TodoApp {
    private JPanel panelContenedor;
    private JPanel panelControles;
    private JScrollPane panelTabla;
    private JTable tablaMostrarTareas;
    private JButton agregarTareaBtn;
    private JButton modificarTareaBtn;
    private JButton eliminarTareaBtn;
    private JButton agregarCategoriaBtn;
    private JButton modificarCategroriaBtn;
    private JList listCategoria;
    private JScrollPane panelCategoria;
    private JPanel panelControlCategoria;

    public void CrearApp(){
        InicializarComponentes();
        AsignarTextos();
    }

    private void AsignarTextos(){
        eliminarTareaBtn.setText("Eliminar tarea");
        agregarCategoriaBtn.setText("Agregar categoría");
        modificarCategroriaBtn.setText("Modificar categoría");
        modificarTareaBtn.setText("Modificar tarea");
        agregarTareaBtn.setText("Agregar tarea");
    }

    private void InicializarComponentes(){
        JFrame app = new JFrame("Todo App");
        app.setVisible(true);
        app.setMinimumSize(new Dimension(960,520));
        app.add(panelContenedor);
    }
}

