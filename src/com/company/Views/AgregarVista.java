package com.company.Views;

import com.company.Database.DbStorage;
import com.company.Models.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;

public class AgregarVista extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel labelTitulo;
    private JTextField txtTitulo;
    private JLabel labelDescripcion;
    private JTextField txtDescripcion;
    private JLabel labelCategoria;
    private JCheckBox boxCompletado;
    private JComboBox<String> boxCategorias;
    private JLabel labelPropietario;
    private JComboBox<String> boxPropietarios;
    private JLabel labelFechaInicial;
    private JTextField textFechaInicial;
    private JLabel labelFechaFinal;
    private JTextField textFechaFinal;

    private Tarea tareaActual;
    private boolean editando = false;

    public AgregarVista() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        asignarTextos();
        if (boxCategorias.getItemCount() == 0) {
            cargarCategorias();
        }
        if (boxPropietarios.getItemCount() == 0) {
            cargarPropietarios();
        }
    }

    private void onOK() {
        agregarTarea();
        dispose();
    }

    private void agregarTarea() {
        if (tareaActual == null){
            tareaActual = new Tarea();
        }
        Categoria categoria = getCategoriaSeleccionado();
        Propietario propietario = getPropietarioSeleccionado();

        tareaActual.setTitulo(txtTitulo.getText());
        tareaActual.setDescripcion(txtDescripcion.getText());
        tareaActual.setCategoria(categoria);
        tareaActual.setPropietario(propietario);
        tareaActual.setCompletado(boxCompletado.isSelected());
        tareaActual.setFechaInicio(Calendar.getInstance().getTime());
        tareaActual.setFechaFinal(Calendar.getInstance().getTime());

        if (editando) {
            DbStorage.editarTarea(tareaActual);
        } else {
            DbStorage.agregarTarea(tareaActual);
        }
    }

    public void editarTarea(Tarea tarea) {
        if (tarea == null) {
            editando = false;
        } else {
            editando = true;
            tareaActual = tarea;
            txtTitulo.setText(tareaActual.getTitulo());
            txtDescripcion.setText(tareaActual.getDescripcion());
            boxCategorias.setSelectedItem(tareaActual.getCategoria().getDescripcion());
            boxPropietarios.setSelectedItem(tareaActual.getPropietario().getNombre());
            boxCompletado.setSelected(tareaActual.isCompletado());
            textFechaInicial.setText(tarea.getFechaInicio().toString());
            textFechaFinal.setText(tarea.getFechaFinal().toString());
        }
    }

    private void cargarCategorias() {
        for (Categoria cat : DbStorage.Categorias) {
            boxCategorias.addItem(cat.getDescripcion());
        }
    }

    private void cargarPropietarios() {
        for (Propietario prop : DbStorage.Propietarios) {
            boxPropietarios.addItem(prop.getNombre());
        }
    }

    private Propietario getPropietarioSeleccionado() {
        Object categoriaSeleccionada = boxPropietarios.getSelectedItem();

        if (categoriaSeleccionada != null) {
            Propietario propietario = DbStorage.obtenerPropietario(categoriaSeleccionada.toString());

            return propietario != null ? propietario : new Propietario();
        }
        return new Propietario();
    }

    private Categoria getCategoriaSeleccionado() {
        Object categoriaSeleccionada = boxCategorias.getSelectedItem();

        if (categoriaSeleccionada != null) {
            Categoria categoria = DbStorage.obtenerCategoria(categoriaSeleccionada.toString());

            return categoria != null ? categoria : new Categoria();
        }
        return new Categoria();
    }

    private void onCancel() {
        dispose();
    }

    private void asignarTextos() {
        labelTitulo.setText("Titulo");
        labelDescripcion.setText("Descripción");
        labelCategoria.setText("Categoría");
        labelPropietario.setText("Propietario");
        labelFechaFinal.setText("Fecha final");
        labelFechaInicial.setText("Fecha inicial");
        boxCompletado.setText("Completado");
        buttonOK.setText("Aplicar");
    }
}
