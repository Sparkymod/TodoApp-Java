package com.company;

import com.company.Database.DbStorage;
import com.company.Models.Categoria;
import com.company.Models.Propietario;
import com.company.Models.Tarea;
import com.company.Views.AgregarVista;
import com.company.Views.CategoriaVista;
import com.company.Views.PropietarioVista;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JList<String> listCategoria;        // Lista de categorias
    private JList<String> listPropietario;      // Lista de propietarios
    private JButton tareasCompletadasBtn;
    private JButton tareasPendientesBtn;

    /**
     * Campo privado que será utilizado en toda la app para servir como modelo de la tabla
     */
    private DefaultTableModel tableModel;
    /**
     * Campo privado que será utilizado en toda la app para servir como modelo de la lista de categoria
     */
    private DefaultListModel<String> listModelCategoria;
    /**
     * Campo privado que será utilizado en toda la app para servir como modelo de la lista de propietario
     */
    private DefaultListModel<String> listModelPropietario;

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
        tareasCompletadasBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarTareasCompletadas();
            }
        });
        tareasPendientesBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarTareasPendiente();
            }
        });

        // Seccián de Categoría
        agregarCategoriaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CategoriaVista vista = new CategoriaVista();

                vista.pack();
                vista.setVisible(true);

                cargarCategorias();
            }
        });
        modificarCategroriaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = listCategoria.getSelectedIndex();
                if (listCategoria.isSelectedIndex(row)) {

                    CategoriaVista vista = new CategoriaVista();
                    Categoria categoria = DbStorage.obtenerCategoria(row);

                    vista.editarCategoria(categoria);
                    vista.pack();
                    vista.setVisible(true);

                    cargarCategorias();
                }
            }
        });
        eliminarCategoriaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = listCategoria.getSelectedIndex();
                if (listCategoria.isSelectedIndex(row)) {
                    DbStorage.removerCategoria(row);
                    listModelCategoria.remove(row);
                }
                cargarCategorias();
            }
        });
        listCategoria.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                cargarTabla();
            }
        });

        // Seccián de Propietario
        agregarPropietarioBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PropietarioVista vista = new PropietarioVista();

                vista.pack();
                vista.setVisible(true);

                cargarPropietarios();
            }
        });
        modificarPropietarioBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = listPropietario.getSelectedIndex();
                if (listPropietario.isSelectedIndex(row)) {

                    PropietarioVista vista = new PropietarioVista();
                    Propietario propietario = DbStorage.obtenerPropietario(row);

                    vista.editarPropietario(propietario);
                    vista.pack();
                    vista.setVisible(true);

                    cargarPropietarios();
                }
            }
        });
        eliminarPropietarioBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = listPropietario.getSelectedIndex();
                if (listPropietario.isSelectedIndex(row)) {
                    DbStorage.removerPropietario(row);
                    listModelPropietario.remove(row);
                }
                cargarPropietarios();
            }
        });
        listPropietario.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                cargarTabla();
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
        tareasCompletadasBtn.setText("Ver tareas completadas");
        tareasPendientesBtn.setText("Ver tareas pendientes");
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
        // Se recarga la tabla con su cabecera
        crearCabeceraTabla();
        for (Tarea tarea : DbStorage.Tareas) {
            if (tarea != null) {
                int row = listCategoria.getSelectedIndex();
                boolean catIgual = false;

                // Si tenemos una categoria seleccionada entonces procede a mostrar en base a esa categoria.
                if (listCategoria.isSelectedIndex(row)) {
                    String categoria = DbStorage.Categorias.get(row).getDescripcion();
                    catIgual = categoria.equalsIgnoreCase(tarea.getCategoria().getDescripcion());
                }

                if (catIgual) {
                    // Aislamos el metodo para mejor lectura de codigo.
                    Object[] tareaTabla = DbStorage.tareaAMostrar(tarea);
                    tableModel.addRow(tareaTabla);
                }
            }
        }
    }

    private void cargarTareasCompletadas() {
        crearCabeceraTabla();
        for (Tarea tarea : DbStorage.Tareas) {
            if (tarea != null) {
                if (tarea.isCompletado()) {
                    Object[] tareaTabla = DbStorage.tareaAMostrar(tarea);
                    tableModel.addRow(tareaTabla);
                }
            }
        }
    }

    private void cargarTareasPendiente() {
        crearCabeceraTabla();
        for (Tarea tarea : DbStorage.Tareas) {
            if (tarea != null) {
                if (!tarea.isCompletado()) {
                    Object[] tareaTabla = DbStorage.tareaAMostrar(tarea);
                    tableModel.addRow(tareaTabla);
                }
            }
        }
    }

    /**
     * Metodo para cargar y recargar categorias en la lista
     */
    private void cargarCategorias() {
        // Se reinicia la lista y recarga con los datos.
        listModelCategoria = new DefaultListModel<>();
        listCategoria.setModel(listModelCategoria);

        for (Categoria cat : DbStorage.Categorias) {
            listModelCategoria.addElement(cat.getDescripcion());
        }
    }

    /**
     * Metodo para cargar y recargar propietarios en la lista
     */
    private void cargarPropietarios() {
        // Se reinicia la lista y recarga con los datos
        listModelPropietario = new DefaultListModel<>();
        listPropietario.setModel(listModelPropietario);

        for (Propietario prop : DbStorage.Propietarios) {
            listModelPropietario.addElement(prop.getNombre());
        }
    }
}

