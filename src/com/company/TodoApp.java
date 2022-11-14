package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TodoApp {
    private JPanel panelContenedor;
    private JPanel panelControles;
    private JScrollPane panelTabla;
    private JButton cargarDataBtn;
    private JButton agregarTareaBtn;
    private JButton editarTareaBtn;
    private JButton eliminarTareaBtn;
    private JButton guardarDataBtn;
    private JTable tablaMostrarTareas;

    public void CrearApp(){
        InicializarComponentes();
        AsignarTextos();
    }

    public TodoApp(){
        agregarTareaBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void AsignarTextos(){
        agregarTareaBtn.setText("Agregar Tarea");
        editarTareaBtn.setText("Editar Tarea");
        eliminarTareaBtn.setText("Eliminar Tarea");
        guardarDataBtn.setText("Guardar Data");
        cargarDataBtn.setText("Cargar Data");
    }

    private void InicializarComponentes(){
        JFrame app = new JFrame("Todo App");
        app.setVisible(true);
        app.setMinimumSize(new Dimension(960,520));
        app.add(panelContenedor);
    }
}

