package com.company;

import com.company.Database.DbStorage;
import com.company.Models.Categoria;
import com.company.Models.Propietario;
import com.company.Models.Tarea;
import com.company.Views.AgregarVista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class TodoApp {
    private JPanel panelContenedor;             // Contenedor de toda la app
    private JTable tablaMostrarTareas;          // Tabla de las tareas
    private JButton agregarTareaBtn;            // Boton de agregar tarea
    private JButton modificarTareaBtn;          // Boton de modificar tarea
    private JButton eliminarTareaBtn;           // Boton de eliminar tarea
    private JButton agregarCategoriaBtn;        // Boton de agregar categoria
    private JButton modificarCategroriaBtn;     // Boton de modificar categoria
    private JButton agregarPropietarioBtn;      // Boton de agregar propietario
    private JButton modificarPropietarioBtn;    // Boton de modificar propietario
    private JButton eliminarCategoriaBtn;       // Boton de eliminar categoria
    private JButton eliminarPropietarioBtn;     // Boton de eliminar propietario
    private JList<String> listCategoria;                // Lista de categorias
    private JList<String> listPropietario;              // Lista de propietarios

    /**
     * Campo privado que será utilizado en toda la app para servir como modelo de la tabla
     */
    private DefaultTableModel tableModel;

    /**
     * Metodo para crear la aplicación.
     */
    public void crearApp() {
        inicializarComponentes();
    }

    /**
     * Metodo para inicializar todos los componentes necesarios.
     */
    private void inicializarComponentes() {
        // Aqui creamos el frame que contendrá la aplicación
        JFrame frame = new JFrame("Todo App");
        // Lo ponemos visible
        frame.setVisible(true);
        // Le damos un size minimo para cuando se ejecute
        frame.setMinimumSize(new Dimension(1080, 520));
        // Agregamos el contenedor que contiene toda la app con todos los demas componentes JPanel
        frame.add(panelContenedor);

        // Desde aqui agregamos los demas metodos que van a inicializar componentes
        asignarTextosBtn();
        cargarCategorias();
        cargarPropietarios();
        cargarAcciones();
        cargarTabla();
    }

    /**
     * Metodo para cargar las acciones de los componentes.
     */
    private void cargarAcciones() {
        // Agregamos el ActionListener que estara esperando a que se haga algo con el boton.
        agregarTareaBtn.addActionListener(new ActionListener() {

            // Cuando el boton sea clickeado ejecutara este metodo
            public void actionPerformed(ActionEvent e) {

                // Aquí llamamos a la otra vista que servirá para agregar la tarea.
                AgregarVista vista = new AgregarVista();

                // Empacamos la vista para que tenga el size minimo que contiene todos los componentes.
                vista.pack();

                // Lo hacemos visibles
                vista.setVisible(true);

                // Ejecutamos el metodo que recargará la tabla una vez se haya agregado la tarea.
                cargarTabla();
            }
        });
        eliminarTareaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí obtenemos la linea seleccionada de la tabla
                // Luego de obtenerlo verificamos si realmente existe y luego la borramos.
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

                    AgregarVista vista = new AgregarVista();
                    Tarea tarea = DbStorage.obtenerTarea(row);

                    vista.editarTarea(tarea);
                    vista.pack();
                    vista.setVisible(true);

                    cargarTabla();
                }
            }
        });
    }

    /**
     * Metodo para asignar Textos en los botones.
     */
    private void asignarTextosBtn() {
        eliminarTareaBtn.setText("Eliminar tarea");
        agregarCategoriaBtn.setText("Agregar categoría");
        modificarCategroriaBtn.setText("Modificar categoría");
        modificarTareaBtn.setText("Modificar tarea");
        agregarTareaBtn.setText("Agregar tarea");
        agregarPropietarioBtn.setText("Agregar propietario");
        modificarPropietarioBtn.setText("Modificar propietario");
        eliminarCategoriaBtn.setText("Eliminar categoría");
        eliminarPropietarioBtn.setText("Eliminar propietario");
    }

    /**
     * Metodo para crear la tabla modelo con sus cabeceras
     * que usará el componente JTable para mostrar los datos.
     */
    private void crearCabeceraTabla() {
        tableModel = new DefaultTableModel();
        // Asignamos el modelo al componente.
        tablaMostrarTareas.setModel(tableModel);

        // Agrandamos las filas para que se vea mas.
        tablaMostrarTareas.setRowHeight(30);

        tableModel.addColumn("Id");
        tableModel.addColumn("Titulo");
        tableModel.addColumn("Descripcion");
        tableModel.addColumn("Categoria");
        tableModel.addColumn("Propietario");
        tableModel.addColumn("Completado");
        tableModel.addColumn("FechaInicio");
        tableModel.addColumn("FechaFinal");
    }

    /**
     * Metodo para cargar la cabecera de la tabla con
     * cada dato de la lista de <b>DbStorage.Tareas</b>
     */
    private void cargarTabla() {
        crearCabeceraTabla();
        for (Tarea tarea : DbStorage.Tareas) {
            if (tarea != null) {
                // Se crea un arreglo de objetos que contendra la informacion de cada columna
                // para luego agregarlo a la tabla debido a la naturaleza
                // de la tabla que solo agrega
                String completado = "";
                if (tarea.isCompletado()) {
                    completado = "Completado";
                } else {
                    completado = "No completado";
                }
                Object[] tareaTabla = new Object[]{
                        tarea.getId(), tarea.getTitulo(), tarea.getDescripcion(),
                        tarea.getCategoria().getDescripcion(), tarea.getPropietario().getNombre(),
                        completado, tarea.getFechaInicio(), tarea.getFechaFinal()
                };
                tableModel.addRow(tareaTabla);
            }
        }
    }

    private void cargarCategorias() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listCategoria.setModel(listModel);

        for (Categoria cat : DbStorage.Categorias) {
            listModel.addElement(cat.getDescripcion());
        }
    }

    private void cargarPropietarios() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listPropietario.setModel(listModel);

        for (Propietario prop : DbStorage.Propietarios) {
            listModel.addElement(prop.getNombre());
        }
    }
}

