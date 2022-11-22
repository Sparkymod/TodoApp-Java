package com.company;

import com.company.Models.Categoria;
import com.company.Models.Propietario;
import com.company.Models.Tarea;
import com.company.Views.AgregarVista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;
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
        crearCabeceraTabla();
    }

    private void inicializarComponentes(){
        JFrame app = new JFrame("Todo App");
        app.setVisible(true);
        app.setMinimumSize(new Dimension(1080,520));
        app.add(panelContenedor);
        app.pack();

        Tareas = new Tarea[]{ new Tarea()};
        Categorias = new Categoria[]{new Categoria()};
        Propietarios = new Propietario[]{new Propietario()};
    }

    private void agregarAcciones(){
        agregarTareaBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AgregarVista vista = new AgregarVista();
                vista.pack();
                vista.setVisible(true);
            }
        });
    }

    private void asignarTextos(){
        eliminarTareaBtn.setText("Eliminar tarea");
        agregarCategoriaBtn.setText("Agregar categoría");
        modificarCategroriaBtn.setText("Modificar categoría");
        modificarTareaBtn.setText("Modificar tarea");
        agregarTareaBtn.setText("Agregar tarea");
    }

    private void crearCabeceraTabla(){
        DefaultTableModel tableModel = new DefaultTableModel();
        tablaMostrarTareas.setModel(tableModel);

        tablaMostrarTareas.setRowHeight(30);
        tableModel.addColumn("Id");
        tableModel.addColumn("Titulo");
        tableModel.addColumn("Descripcion");
        tableModel.addColumn("Propietario");
        tableModel.addColumn("Categoria");
        tableModel.addColumn("Completado");
        tableModel.addColumn("FechaInicio");
        tableModel.addColumn("FechaFinal");

        tableModel.addRow(Tareas);

        TableColumn sportColumn = tablaMostrarTareas.getColumnModel().getColumn(4);

        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Snowboarding");
        comboBox.addItem("Rowing");
        comboBox.addItem("Chasing toddlers");
        comboBox.addItem("Speed reading");
        comboBox.addItem("Teaching high school");
        comboBox.addItem("None");
        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
    }

    private void agregarTarea(Tarea nuevaTarea){
        Tarea[] nuevaLista = new Tarea[Tareas.length + 1];
        if (nuevaTarea != null){
            for(int i = 0; i < Tareas.length; i++){
                nuevaLista[i] = Tareas[i];
            }
            nuevaLista[Tareas.length] = nuevaTarea;
            Tareas = nuevaLista;
        }
    }
}

