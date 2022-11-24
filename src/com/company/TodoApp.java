package com.company;

import com.company.Database.DbStorage;
import com.company.Models.Categoria;
import com.company.Models.Tarea;
import com.company.Views.AgregarVista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

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
    private JPanel panelCategoriaContainer;
    private JPanel panelPropietarioContainer;
    private JPanel panelListContainer;
    private JScrollPane scrollPropietario;
    private JList listPropietario;
    private JButton agregarPropietarioBtn;
    private JButton modificarPropietarioBtn;

    private DefaultTableModel tableModel;

    public void crearApp() {
        inicializarComponentes();
        asignarTextos();
        cargarAcciones();
        crearCabeceraTabla();
        cargarTabla();
    }

    private void inicializarComponentes() {
        JFrame app = new JFrame("Todo App");
        app.setVisible(true);
        app.setMinimumSize(new Dimension(1080, 520));
        app.add(panelContenedor);
        app.pack();

    }

    private void cargarAcciones() {
        agregarTareaBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AgregarVista vista = new AgregarVista();
                vista.pack();
                vista.setVisible(true);
                cargarTabla();
            }
        });
        eliminarTareaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tablaMostrarTareas.getSelectedRow();
                if (tablaMostrarTareas.isRowSelected(row)) {
                    DbStorage.removerTarea(row);
                    tableModel.removeRow(row);
                }
            }
        });
        modificarTareaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tablaMostrarTareas.getSelectedRow();
                if (tablaMostrarTareas.isRowSelected(row)) {

                }
            }
        });
    }

    private void asignarTextos() {
        eliminarTareaBtn.setText("Eliminar tarea");
        agregarCategoriaBtn.setText("Agregar categoría");
        modificarCategroriaBtn.setText("Modificar categoría");
        modificarTareaBtn.setText("Modificar tarea");
        agregarTareaBtn.setText("Agregar tarea");
        agregarPropietarioBtn.setText("Agregar propietario");
        modificarPropietarioBtn.setText("Modificar propietario");
    }

    private void crearCabeceraTabla() {
        tableModel = new DefaultTableModel();
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

    }

    private void cargarTabla() {
        crearCabeceraTabla();
        for (Tarea tarea : DbStorage.Tareas) {
            if (tarea != null) {
                Object[] tareaTabla = new Object[]{
                        tarea.getId()
                };
                tableModel.addRow(tareaTabla);
            }
        }
    }
}

