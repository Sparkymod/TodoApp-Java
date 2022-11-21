package com.company;

import com.company.Models.Categoria;
import com.company.Models.Propietario;
import com.company.Models.Tarea;
import com.company.Views.AgregarVista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

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
    private JList<Categoria> listCategoria;
    private JScrollPane panelCategoria;
    private JPanel panelControlCategoria;

    public Tarea[] Tareas;
    public Categoria[] Categorias;
    public Propietario[] Propietarios;

    public void crearApp(){
        inicializarComponentes();
        asignarTextos();
        agregarAcciones();
    }

    private void inicializarComponentes(){
        JFrame app = new JFrame("Todo App");
        app.setVisible(true);
        app.setMinimumSize(new Dimension(960,520));
        app.add(panelContenedor);
        app.pack();

        Tareas = new Tarea[]{};
        Categorias = new Categoria[]{};
        Propietarios = new Propietario[]{};
    }

    private void agregarAcciones(){
        agregarTareaBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AgregarVista vista = new AgregarVista();
                vista.pack();
                vista.setVisible(true);
                Tareas = new Tarea[]{
                        vista.getTarea()
                };
            }
        });
    }

    private void asignarTextos(){
        eliminarTareaBtn.setText("Eliminar tarea");
        agregarCategoriaBtn.setText("Agregar categoría");
        modificarCategroriaBtn.setText("Modificar categoría");
        modificarTareaBtn.setText("Modificar tarea");
        agregarTareaBtn.setText("Agregar tarea");

        DefaultTableModel table = new DefaultTableModel();
        tablaMostrarTareas.setModel(table);

        table.addColumn("Id");
        table.addColumn("Titulo");
        table.addColumn("Descripcion");
        table.addColumn("Completado");
        table.addColumn("FechaInicio");
        table.addColumn("FechaFinal");
        table.addColumn("Propietario");
        table.addColumn("Categoria");
        table.addRow(Tareas);

    }
}

